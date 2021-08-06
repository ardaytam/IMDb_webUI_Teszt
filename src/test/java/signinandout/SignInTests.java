package signinandout;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import pages.SignInWithIMDbPage;


@Epic("Login Tests Epic")
@Feature("Valid Login Features")

public class SignInTests extends BaseTests {


    @Test
    @Story("User tries to login the system with valid username and valid password.")
    @Description("Valid Login Test with Valid Username and Valid Password.")
    public void testSuccessfulLogIn() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();

        String testUserName = "Junior";
        Assertions.assertTrue(mainPage.userIsSignedIn(testUserName));

    }

    @Test
    @Story("User tries to login the system with valid username and invalid password.")
    @Description("Invalid Login Test with vali Username and Invalid Password.")
    public void testLoginWithInvalidPassword() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600");
        signInWithIMDbPage.clickSignInButton();

        //*[@id="auth-error-message-box"]/div/div/ul/li/span
        String errormessage = "Your password is incorrect";

        Assertions.assertEquals(errormessage, signInWithIMDbPage.Passworderror());

    }

}
