package com.whisk.qa.web.pageLoggedIn.topBar.toolBar;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.whisk.qa.web.pageLoggedIn.content.Page;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.$;

@AllArgsConstructor
@NoArgsConstructor
public class ToolBarSetting {
    SelenideElement accountLink = $("[data-testid=user-settings-account-settings-link-title]");
    SelenideElement closePopup =$("[data-testid=user-settings-close-button]");

    public Account accountLink(){
        accountLink.click();
        return new Account();
    }

    public Page closeSettingsPopup(){
        closePopup.click();
        return new Page();
    }
}
