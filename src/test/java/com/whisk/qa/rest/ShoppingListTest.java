package com.whisk.qa.rest;

import com.whisk.qa.rest.dao.ShoppingListResponseWrapper;
import com.whisk.qa.rest.dao.shoppingList.Item;
import com.whisk.qa.rest.dao.shoppingList.ShoppingListDao;
import com.whisk.qa.rest.dao.ShoppingListGetAllResponse;
import com.whisk.qa.web.utility.Utility;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import kong.unirest.Header;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.util.Collections;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.text.MatchesPattern.matchesPattern;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShoppingListTest {

    private static RequestSpecification requestSpec;
    private static String shoppingListId;

    @BeforeAll
    public void testData(){
        baseURI="https://api.whisk-dev.com";
        basePath="list/v2";

        requestSpec=new RequestSpecBuilder()
                .addHeader("Authorization","Bearer 4S6sAfpswCnp0N32xLv5VYgyrdVDCa1ENK0KA781GrzvGRgSlTxQFa5SaH6UPbIL")
                .build();

    }
    @Test
    public void createAndVerifyShoppingList(){
        //Step 1 : Create shopping list
        ShoppingListResponseWrapper createResponse = given()
                .spec(requestSpec)
                .body(new ShoppingListDao(null,Utility.getRandomName(),false))
                .post()
                .getBody()
                .as(ShoppingListResponseWrapper.class);

        shoppingListId=createResponse.getList().getId();
        //Step 2 : Get and verify shopping list
        given()
                .spec(requestSpec)
                .get("/"+shoppingListId)
                .then()
                .assertThat()
                .statusCode(200)
                .body("list.id",matchesPattern("[a-z,0-9]{35}"))
                .body("content",not(hasItemInArray(Item.class)));

    }

    @Test
    public void createAndDeleteShoppingList(){
        //Step 1 : Create shopping list
        ShoppingListResponseWrapper createResponse = given()
                .spec(requestSpec)
                .body(new ShoppingListDao(null,Utility.getRandomName(),false))
                .post()
                .getBody()
                .as(ShoppingListResponseWrapper.class);

        shoppingListId=createResponse.getList().getId();

        //Step 3 : Verify that shopping list exists
        given()
                .spec(requestSpec)
                .get("/"+shoppingListId)
                .then()
                .assertThat()
                .statusCode(200);

        //Step 4 : Remove shopping list
        given()
                .spec(requestSpec)
                .delete("/"+shoppingListId)
                .then()
                .assertThat()
                .statusCode(200);

        //Step 5 : Try to get non-existent shopping list with hamcrest validation
        given()
                .spec(requestSpec)
                .get("/"+shoppingListId)
                .then()
                .assertThat()
                .statusCode(400)
                .body("code", equalTo("shoppingList.notFound"))
                .body("error_code", equalTo("LIST_ERROR_NOT_FOUND"))
                .body("message", equalTo("Shopping list not found"));

    }

    @AfterAll
    public void cleanUp(){
        //Retrieve all lists which are currently present
        ShoppingListGetAllResponse allListResponse = given()
                .spec(requestSpec)
                .get()
                .getBody()
                .as(ShoppingListGetAllResponse.class);

        //Remove list by list
        for(ShoppingListDao list:allListResponse.getList()){
            given()
                    .spec(requestSpec)
                    .delete("/"+list.getId());
        }

        //Check if not lists are present for user
        given()
                .spec(requestSpec)
                .get()
                .then()
                .assertThat().statusCode(200);
    }
}
