package com.whisk.qa.web.pageVisitor;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.whisk.qa.web.pageLoggedIn.content.CommunityPage;
import com.whisk.qa.web.pageLoggedIn.content.Page;
import com.whisk.qa.web.utility.ErrorMsg;
import com.whisk.qa.web.utility.Utility;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;

public class LandingPage extends Page {

    protected SelenideElement popup_email=$("[data-testid=UI_KIT_INPUT");
    protected SelenideElement popup_submit=$("[data-testid=auth-continue-button]");
    protected SelenideElement popup_validation_errorMsg=$("[data-testid=email-phone-number-auth-input] span");

    public LandingPage(Boolean open){
        Selenide.open(getMainUrl());
    }

    public LandingPage(){

    }

    /**
     * Signs up for newsletter using predetermined text
     * @param string
     * @return
     */
    public LandingPage signUp(String string){
        popup_email.setValue(string);
     return this;
    }
    /**
     * Signs up using random text in email format
     */
    public LandingPage signUpWithRandomEmail(){
        return signUp(Utility.getRandomEmail());
    }

    //TODO
    /**
     * Signs up  using random text in mobile phone format
     */
    public LandingPage signUpWithPhoneNumber(){
        return signUp(Utility.getRandomEmail());
    }

    /**
     * Submits form and stays on same page
     * @return
     */
    public LandingPage submit(){
        popup_submit.click();
        sleep(1000);
        return this;
    }

    public LandingPage submit(ErrorMsg errorMsg){
        popup_submit.click();
        Assertions.assertTrue(expectedErrorMessage(errorMsg));
        return this;
    }

    /**
     * Return true of false based if error message was returned
     * @param errorMsg
     * @return
     */
    private Boolean expectedErrorMessage(ErrorMsg errorMsg){
        //Returns true or false if we recieved expected error
        if(popup_validation_errorMsg.getOwnText().isEmpty()){
            if(errorMsg==null){
                return true;
            }
        }else{
            return (popup_validation_errorMsg.getOwnText().equals(errorMsg.text));
        }

        //Code should not get here.
        return false;
    }

    public CommunityPage continueToComunityPage(){
        return new CommunityPage();
    }

    public LandingPage wait(int milis){
        sleep(milis);
        return this;
    }

}
