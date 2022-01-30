package com.whisk.qa.web.pageLoggedIn.content;

import com.codeborne.selenide.SelenideElement;
import com.whisk.qa.web.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ShopingPage extends Page {

    private SelenideElement itemAutocomplete=$("[data-testid=desktop-add-item-autocomplete]");
    private SelenideElement addShoppingListButton=$("[data-testid=create-new-shopping-list-button]");
    private SelenideElement addShoppingListName=$("[data-testid=UI_KIT_INPUT]");
    private SelenideElement addShoppingListSubmit=$("[data-testid=create-new-shopping-list-create-button]");
    private List<SelenideElement> shopingLists=$$("[data-testid=shopping-lists-list-name]");
    private List<SelenideElement> shoppingListAutocompleteResult = $$("[data-testid=desktop-add-item-autocomplete]  div[data-testid]");
    private SelenideElement shoppingListDelete=$("[data-testid=shopping-list-delete-menu-button]");
    private SelenideElement shoppingListDeleteConfirm=$("[data-testid=confirm-delete-button]");
    private SelenideElement shoppingList=$("[data-testid=shopping-list-item-name]");



    private List<String> boughtItems=new ArrayList<>();

    public ShopingPage(Boolean openPage){
        open(getShoppingUrl());
    }

    public ShopingPage(){
    }

    public ShopingPage createShoppingList(String shoppingListName){
        addShoppingListButton.click();
        addShoppingListName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        addShoppingListName.sendKeys(shoppingListName);
        addShoppingListSubmit.click();
        sleep(3000);
        return this;
    }

    public ShopingPage deleteShoppingList(String shoppingListName){
        findShoppingList(shoppingListName).find("button").click();
        shoppingListDelete.click();
        shoppingListDeleteConfirm.click();
        return this;
    }

    public ShopingPage selectShoppingList(String shoppingListName){
        findShoppingList(shoppingListName).click();
        return this;
    }

    public ShopingPage submitItemToShoppingList(String itemName){
        itemAutocomplete.setValue(itemName);
        sleep(1000);


            SelenideElement item=shoppingListAutocompleteResult.get(0);
            sleep(1000);
            item.click();
        sleep(2000);
        //Warning shopping items empty! need to handle //todo

        if(shoppingList.find(By.linkText(itemName))==null){
            throw new IllegalArgumentException("Item was not added to baskedt!");
        };
        return this;
    }


    public ShopingPage deleteShopingList(String name){
        findShoppingList(name).parent().parent().find("button").click();
        shoppingListDelete.click();
        shoppingListDeleteConfirm.click();
        return this;
    }

    public ShopingPage deleteShopingList(int id){
        shopingLists.get(id).parent().parent().find("button").click();
        shoppingListDelete.click();
        shoppingListDeleteConfirm.click();
        return this;
    }


    public SelenideElement findShoppingList(String name){
        for(SelenideElement element:shopingLists){
            if(element.getOwnText().equals(name)){
                return element.parent().parent();
            }
        }
        return null;
    }

    public ShopingPage checkIfShopingListEmpty(){
        if(!shopingLists.isEmpty()){
            throw new IllegalStateException("Lists are present but they are not suppose to be!");
        }
        return this;
    }

    public Boolean checkIfShoppingListContains(String item) {
        if(shoppingList.find(By.linkText(item))==null){
           return false;
        };
        return true;
    }

    public boolean checkIfShopingListExists(String shopingListName) {
        if(findShoppingList(shopingListName)==null){
            return false;
        }
        return true;
    }
}
