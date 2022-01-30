package com.whisk.qa.web.registration;

import com.whisk.qa.web.pageLoggedIn.content.Page;
import com.whisk.qa.web.pageVisitor.LandingPage;
import com.whisk.qa.web.utility.ErrorMsg;
import com.whisk.qa.web.utility.Utility;
import org.junit.jupiter.api.*;

/**
 * This is not part of test task
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegistrationTest {


    @Test
    @Order(1)
    public void testErrorMessageEmpty(){
        new LandingPage(true)
                .signUp("")
                .submit(ErrorMsg.FIELD_REQUIRED);
    }

    @Test
    @Order(2)
    public void testErrorMessageInvalid(){
        new LandingPage(true)
                .signUp("1")
                .submit(ErrorMsg.EMAIL_PHONE_INVALID);
    }

    @Test
    @Order(3)
    public void testErrorMessageInvalidEmail(){
        new LandingPage(true)
                .signUp(Utility.getRandomEmail()+"@@")
                .submit(ErrorMsg.EMAIL_PHONE_INVALID);
    }

    @Test
    @Order(4)
    public void testValidRegistrationWithEmail(){
        new LandingPage(true)
                .signUp(Utility.getRandomEmail())
                .submit(null);

    }

    @AfterAll
    public void close(){
        new Page().closeWindow();
    }

}
