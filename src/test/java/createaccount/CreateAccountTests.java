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

@Epic("Regisztráció")

public class CreateAccountTests extends BaseTests {


    @Disabled("Nem javasolt az automatizálás az email verifikációs folyamat (email címre küldött egyedi azonosító) miatt")
    @Feature("Sikeres regisztráció")
    @Story("A felhasználó érvényes adatokkal kísérli meg a regisztrációt")
    @Description("Regisztráció érvényes adatokkal")
    @Test
    public void testSuccessfulRegistration() {
        //Regisztráció
        SignInPage signInPage = mainPage.clickSignIn();
        CreateAccountPage createAccountPage = signInPage.clickCreateNewAccountButton();
        createAccountPage.setName("Junior Autotesztelo");
        createAccountPage.setEmail("autotesztelojunior@gmail.com");
        createAccountPage.setPassword("Oszip12600*");
        createAccountPage.setPasswordCheck("Oszip12600*");
        createAccountPage.clickCreateAccountButton();

    }

    @Feature("Sikertelen regisztráció")
    @Story("A felhasználó email cím megadsa nélkül próbál regisztrálni")
    @Description("Sikertelen regisztráció email cím megadása nélkül")
    @Test
    public void testRegistrationWithoutEmail() {
        //Regisztráció
        SignInPage signInPage = mainPage.clickSignIn();
        CreateAccountPage createAccountPage = signInPage.clickCreateNewAccountButton();
        createAccountPage.setName("Nagy Lajos");
        createAccountPage.setEmail(""); //üres email mező
        createAccountPage.setPassword("Oszip12600*");
        createAccountPage.setPasswordCheck("Oszip12600*");
        createAccountPage.clickCreateAccountButton();

        //Sikeretelen regisztráció ellenőrzése: hibaüzenet szövegének vizsgálata
        String emailerrormessage = "Enter your email";
        Assertions.assertTrue(emailerrormessage.equals(createAccountPage.missingEmailError()));

    }
}
