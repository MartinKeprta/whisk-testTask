package com.whisk.qa.web.pageLoggedIn.content;

import com.codeborne.selenide.Selenide;
import com.whisk.qa.web.pageLoggedIn.topBar.TopBar;

import static com.codeborne.selenide.Selenide.*;

public class Page {

    //TODO put this shit into external config or something.
    private static String mainUrl ="https://my.whisk-dev.com";
    public String getMainUrl(){
        return mainUrl;
    }
    public String getCommunityPageUrl(){
        return mainUrl+"/communities";
    }
    public String getShoppingUrl(){
        return mainUrl+"/shopping-list";
    }
    public String getFeedUrl(){return mainUrl+"/feed";}

    private TopBar topBar = new TopBar();

    public TopBar topBar(){
        return this.topBar;
    }

    public Page(){

    }

    public Page(boolean open){
        if(open)open(getFeedUrl());
    }

    public Page clear(){
        clearBrowserCookies();
        clearBrowserLocalStorage();
        return this;
    }
    public void closeWindow(){
        Selenide.closeWindow();
    }
    public void closeAllPopups(){

    }
}
