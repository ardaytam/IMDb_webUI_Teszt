package signinandout;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import pages.SignInWithIMDbPage;


@Epic("Login Tests")


public class SignInTests extends BaseTests {

    @Test
    @Feature("Valid Login")
    @Story("User tries to login the system with valid username and valid password.")
    @Description("Valid Login Test with Valid Username and Valid Password.")
    public void testSuccessfulLogIn() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();

        String currentTestUserName = "Junior";
        
        Assertions.assertEquals(currentTestUserName, mainPage.userIsSignedIn());

    }

    @Disabled
    @Test
    @Feature("Invalid Login")
    @Story("User tries to login the system with valid username and invalid password.")
    @Description("Invalid Login Test with valid Username and Invalid Password.")
    public void testLoginWithInvalidPassword() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600"); //wrong password
        signInWithIMDbPage.clickSignInButton();

        String errormessage1 = "Your password is incorrect";
        String errormessage2 = "Important Message!"; //This message appears after the second unsuccessfull attempt

        Assertions.assertTrue(errormessage1.equals(signInWithIMDbPage.firstPasswordError())
                || errormessage2.equals(signInWithIMDbPage.secondPasswordError()));

    }
}
