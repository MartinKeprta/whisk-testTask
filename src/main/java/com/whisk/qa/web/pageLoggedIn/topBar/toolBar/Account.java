package com.whisk.qa.web.pageLoggedIn.topBar.toolBar;

import com.codeborne.selenide.SelenideElement;
import com.whisk.qa.web.pageLoggedIn.content.Page;
import com.whisk.qa.web.pageVisitor.LandingPage;
import com.whisk.qa.web.utility.ErrorMsg;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AllArgsConstructor
@NoArgsConstructor
public class Account extends Page {
    //First name last name
    private SelenideElement name = $("[data-testid=user-settings-name-title]");
    private SelenideElement nameInputFirstName=$(By.name("firstName"));
    private SelenideElement nameInputFirstNameErrorMsg=$("[data-testid=name-options-first-name-input] span");
    private SelenideElement nameInputLastName=$(By.name("lastName"));
    private SelenideElement nameInputLastNameNameErrorMsg=$("[data-testid=name-options-last-name-input] span");
    private SelenideElement changeNameModalButton=$("[data-testid=change-name-modal] button");
    //Delete account
    private SelenideElement deleteButon=$(By.xpath(".//button[text()='Delete Account']"));
    private SelenideElement deleteButtonConfirmationText=$("[data-testid=delete-account-modal] input");
    private SelenideElement deleteButtonConfirmationButton=$("[data-testid=delete-account-modal] button[type=submit]");
    //Whole popup
    private SelenideElement closePopup=$("[data-testid=user-settings-account-settings-go-back-button]");

    /**
     * If errors are caught or required state differs from expected method will failed here.
     * @param firstName
     * @param lastName
     * @param firstNameErrMsg
     * @param lastNameErrMsg
     * @return
     */
    public Account setName(String firstName,String lastName,ErrorMsg firstNameErrMsg,ErrorMsg lastNameErrMsg){
        if(firstName==null)firstName="";
        if(lastName==null)lastName="";
        name.click();
        nameInputFirstName.sendKeys(firstName);
        nameInputLastName.sendKeys(lastName);

        assertEquals(firstNameErrMsg.text, nameInputFirstNameErrorMsg.getOwnText());

        sleep(1000);
        return this;
    }

    public ToolBarSetting submitNameChange(){
        changeNameModalButton.click();
        return new ToolBarSetting();
    }

    public Account setName(String firstName,String lastName){
        return setName(firstName,lastName,ErrorMsg.NO_ERROR,ErrorMsg.NO_ERROR);
    }

    public LandingPage deleteAccount(){
        deleteButon.click();
        deleteButtonConfirmationText.sendKeys("delete");
        deleteButtonConfirmationButton.click();
        return new LandingPage();
    }

    public ToolBarSetting closeAccountPopup(){
        closePopup.click();
        return new ToolBarSetting();
    }


}
