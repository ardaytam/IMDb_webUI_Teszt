package signinandout;

import base.BaseTests;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.SignInPage;
import pages.SignInWithIMDbPage;

import java.io.ByteArrayInputStream;

public class SignOutTest extends BaseTests {

    @Test
    public void testSuccessfulSignOut() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();
        mainPage.clickSignOut();
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());

        String currentTestUserName = "Junior";
        Assertions.assertNotEquals(currentTestUserName, mainPage.userIsSignedIn());


    }

}

