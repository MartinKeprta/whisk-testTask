package com.whisk.qa.web.shopping;

import com.whisk.qa.web.pageLoggedIn.content.Page;
import com.whisk.qa.web.pageLoggedIn.content.ShopingPage;
import com.whisk.qa.web.pageVisitor.LandingPage;
import com.whisk.qa.web.utility.Utility;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static com.codeborne.selenide.Selenide.sleep;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShoppingTest {

    ShopingPage shopingPage = new ShopingPage();
    String shopingListName=Utility.getRandomName();

    /**
     * Creates new user account and signs in into application
     */
    @BeforeAll
    public void loginIntoApp(){
      new LandingPage(true)
              .signUp(Utility.getRandomEmail())
              .submit()
              .continueToComunityPage()
              .submitChannelSubscription()
              .topBar().shopping();

      sleep(4000);

    }
    /**
     * Creates new shopping list , selects it and populates with products
     */
    @Test
    public void createShopList(){

        shopingPage
        .createShoppingList(shopingListName)
        .selectShoppingList(shopingListName)
             .submitItemToShoppingList("Milk")
             .submitItemToShoppingList("Cookies")
             .submitItemToShoppingList("Sugar")
             .submitItemToShoppingList("Eggs")
             .submitItemToShoppingList("Oil");
    }
    /**
     * Verifies if selected products are in basket ( it is parametrizedso technically it is not  using for cycle , but there is NO WAY i am writing 5 exactly same testcases
     */
    @ParameterizedTest
    @ValueSource(strings = {"Milk","Cookies","Sugar","Eggs","Oil"})
    void checkifItemIsAddedToShoppingList(String item) {
        Assertions.assertTrue(shopingPage
                .selectShoppingList(shopingListName)
                .checkIfShoppingListContains(item));
    }

    /**
     * Removes shopping list and does assertion if shopping list exists
     */
    @Test
    public void removeShoppingList(){
        shopingPage
                .selectShoppingList(shopingListName)
                .deleteShopingList(shopingListName);

        Assertions.assertFalse(shopingPage.checkIfShopingListExists(shopingListName));

    }
    /**
     * Deletes used user account
     */
    @AfterAll
    public void logoutFromApp(){
        new Page()
                .topBar()
                .toolBar()
                .settings()
                .accountLink()
                .deleteAccount();
    }


}
