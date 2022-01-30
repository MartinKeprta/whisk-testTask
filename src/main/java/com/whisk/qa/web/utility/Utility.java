package com.whisk.qa.web.utility;

import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.RandomType;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class Utility {

    private static MockNeat mockNeat= new MockNeat(RandomType.THREAD_LOCAL);

    /**
     * Returns randomly generated email.
     * @return email String
     */
    public static String getRandomEmail(){
       return mockNeat.emails().val();
    }
    //TODO

    /**
     * Returns random phone number in RF number format
     * @return
     */
    public static String gerRandomPhoneNumber(){
        return "";
    }

    /**
     * Returns random integer number from 0 to max
     * @param max
     * @return
     */
    public static int getRandomNumber(int max){
        return  (int)(Math.random()*(max));
    }

    /**
     * Returns random animal name with text before it
     * @param pre
     * @return
     */
    public static String getRandomName(String pre) {
        return pre+ " " +getRandomName();
    }

    /**
     * Returns random animal name
     * @return
     */
    public static String getRandomName() {
        return mockNeat.creatures().val();
    }

    /**
     * Returns shopping list with animal name
     * @return
     */
    public static String getShopingListName(){
        return "Shoping list to cook "+mockNeat.creatures().val();
    }

    /**
     * This is suppose to be solved using API
     * Creates disposable email adress to check magic link login
     * @return
     */
    @Deprecated
    public static String getOtpLink(){
        open("https://tempmailo.com/");
        sleep(20000);
        $("div.mail-item-sub").click();
        switchTo().frame("fullmessage");
        return  $$("a[href]").get(1).attr("href");

    }

    /**
     * This is suppose to be solved using API
     * Returns OTP code from disposable magic link login
     * @return
     */
    @Deprecated
    public static String getOtpAdress(){
        open("https://tempmailo.com/");
        return $("#i-email").val();
    }



}
