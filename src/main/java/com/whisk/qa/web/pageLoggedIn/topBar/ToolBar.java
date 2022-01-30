package com.whisk.qa.web.pageLoggedIn.topBar;

import com.codeborne.selenide.SelenideElement;
import com.whisk.qa.web.pageLoggedIn.topBar.toolBar.ToolBarSetting;

import static com.codeborne.selenide.Selenide.$;

public class ToolBar {

    private SelenideElement topBarAvatar =$("[data-testid=avatar-button]");
    private SelenideElement topBarMenuLogout = $("[data-testid=desktop-logout-button]");
    private SelenideElement toolBarMenu = $("[data-testid=avatar-button]");
    private SelenideElement toolBarMenuProfile=$("[data-testid=9a9a9b7c-3afe-4aad-b849-a35f49d219e5]");
    private SelenideElement toolBarMenuSettings=$("[data-testid=desktop-settings-button]");
    private SelenideElement toolBarMenuFeedBack=$("[data-testid=desktop-feedback-support-button]");
    private SelenideElement toolBarMenuLogout=$("[data-testid=desktop-logout-button]");
    public ToolBar(){

    }

    public void profile(){
        toolBarMenu.click();
        toolBarMenuProfile.click();
    }

    public ToolBarSetting settings(){
        toolBarMenu.click();
        toolBarMenuSettings.click();
        return new ToolBarSetting();
    }

    public void feedback(){
        toolBarMenu.click();
        toolBarMenuProfile.click();
    }
    public void logout(){
        toolBarMenu.click();
        toolBarMenuLogout.click();
    }
}
