package createaccount;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.CreateAccountPage;
import pages.SignInPage;

@Epic("Registration Tests")

public class CreateAccountTests extends BaseTests {


    @Disabled("Can not be automatized cause the email verification process")
    @Feature("Valid Registration")
    @Story("User tries to register with properly given data")
    @Description("ValidRegistration Test with properly given data")
    @Test
    public void testSuccessfullRegistration() {
        SignInPage signInPage = mainPage.clickSignIn();
        CreateAccountPage createAccountPage = signInPage.clickCreateNewAccountButton();
        createAccountPage.setName("Junior Autoteszt");
        createAccountPage.setEmail("autotesztjunior@gmail.com");
        createAccountPage.setPassword("Oszip12600*");
        createAccountPage.setPasswordCheck("Oszip12600*");
        createAccountPage.clickCreateAccountButton();

    }
    @Disabled("Remote server does not allow user to sign in after this test has run?")
    @Feature("Invalid Registration")
    @Story("User tries to register without email")
    @Description("Invalid Registration Test: empty email field")
    @Test
    public void testRegistrationWithoutEmail() {
        SignInPage signInPage = mainPage.clickSignIn();
        CreateAccountPage createAccountPage = signInPage.clickCreateNewAccountButton();
        createAccountPage.setName("Nagy Lajos");
        createAccountPage.setEmail(""); //empty email field
        createAccountPage.setPassword("Oszip12600*");
        createAccountPage.setPasswordCheck("Oszip12600*");
        createAccountPage.clickCreateAccountButton();

        String emailerrormessage = "Enter your email";
        Assertions.assertTrue(emailerrormessage.equals(createAccountPage.missingEmailError()));


    }
}
