package com.whisk.qa.web.pageLoggedIn.topBar;

import com.codeborne.selenide.SelenideElement;
import com.whisk.qa.web.pageLoggedIn.content.CommunityPage;
import com.whisk.qa.web.pageLoggedIn.content.PlannerPage;
import com.whisk.qa.web.pageLoggedIn.content.SavedPage;
import com.whisk.qa.web.pageLoggedIn.content.ShopingPage;

import static com.codeborne.selenide.Selenide.$;

public class TopBar {
    //Menu items
    private SelenideElement clickMenuHome=$("[data-testid=home-nav-link]");
    private SelenideElement clickMenuCommunities=$("[data-testid=5baeaaa4-dd14-d060-8f1f-037f12662889]");
    private SelenideElement clickMenuSaved=$("[data-testid=recipes-nav-link[");
    private SelenideElement clickMenuPlanner=$("[data-testid=meal-plan-nav-link]");
    private SelenideElement clickMenuShopping=$("[data-testid=shopping-list-nav-link]");
    //ToolBar
    private ToolBar toolBar=new ToolBar();
    private Search search=new Search();
    //Search


    public ToolBar toolBar() {
        return toolBar;
    }

    //Menu
    public CommunityPage home(){
        clickMenuHome.click();
        return new CommunityPage();
    }

    public CommunityPage communities(){
        clickMenuCommunities.click();
        return new CommunityPage();
    }

    public SavedPage saved(){
        clickMenuSaved.click();
        return new SavedPage();
    }

    public PlannerPage plannerPage(){
        clickMenuPlanner.click();
        return new PlannerPage();
    }

    public ShopingPage shopping(){
        clickMenuShopping.click();
        return new ShopingPage();
    }
}
