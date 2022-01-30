package com.whisk.qa.web.pageLoggedIn.content;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CommunityPage extends Page {

    private SelenideElement submitCommunitySubscriptionButton=$("[data-testid='df93b370-5132-6be4-fbb2-632d6152a4e2']");
    private List<SelenideElement> avaliableChannels=$$("div[data-testid='9c5c1a2c-cdfe-09a6-1734-f1bf8c5cf28e'] a");



    public CommunityPage(){
        //When first opening page after login need to wait for it to dissapear
        sleep(5000);

    }

    public CommunityPage(Boolean open){
        open(getCommunityPageUrl());
    }


    public CommunityPage switchChannelSubscriptionById(int channelId){
        SelenideElement element=$("[data-test-id=hf-onboarding-community-"+channelId);
        element.click();
        return this;
    }

    public CommunityPage switchChannelSubscriptionByChannelName(String channelName){
        Boolean channelFound=false;
        for(SelenideElement element:avaliableChannels){
            SelenideElement channelElement = element.find("div.eHVbib");
            if(channelElement.getOwnText().equals(channelName)){
                element.click();
                channelFound=true;
                break;
            }
        }

        if(!channelFound){
            //TODO Error handling!
        }

        return this;
    }

    public CommunityPage submitChannelSubscription(){
        submitCommunitySubscriptionButton.click();
        return this;
    }


}
