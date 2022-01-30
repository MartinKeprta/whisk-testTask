package com.whisk.qa.web.login;

import com.whisk.qa.web.pageLoggedIn.content.Page;
import com.whisk.qa.web.pageVisitor.LandingPage;
import com.whisk.qa.web.utility.ErrorMsg;
import com.whisk.qa.web.utility.Utility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * This is not part of test task
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserProfileTest {

    @ParameterizedTest
    @CsvSource(value =
            {
            "Martin,Keprta,NO_ERROR,NO_ERROR",
            ",,FIELD_REQUIRED,NO_ERROR",
            "^%$#,Keprta,EMAIL_STRING_INVALID,NO_ERROR",
            },
            delimiter = ',')
    public void testValidRegistrationWithEmail(String firstName,String lastName,String err1,String err2){
        //Open page with new user
        new LandingPage(true)
                .signUp(Utility.getRandomEmail())
                .submit()
                .continueToComunityPage()
                .submitChannelSubscription();

        //Change user name
        new Page()
                .topBar()
                .toolBar()
                .settings()
                .accountLink()
                .setName(firstName,lastName, ErrorMsg.valueOf(err1),ErrorMsg.valueOf(err2));

    }

    @AfterEach
    public void close(){
        new Page()
                .clear()
                .closeWindow();
    }
}
