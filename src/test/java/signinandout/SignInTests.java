package signinandout;

import base.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.SignInPage;
import pages.SignInWithIMDbPage;

import java.io.ByteArrayInputStream;

@Epic("Bejelentkezés")

public class SignInTests extends BaseTests {

    @Test
    @Feature("Sikeres bejelentkezés")
    @Story("A felhasználó érvényes adatokkal jelentkezik be az alkalmazásba")
    @Description("Sikeres bejelentkezéss érvényes adatokkal")
    public void testSuccessfulLogIn() {

        //Bejelentkezés
        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztelojunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());

        //Bejelentkezés ellenőrzése: a megadott felhasználónév meglétének vizsgálata a főoldalon a felhasználói menüben
        String currentTestUserName = "Junior";
        Assertions.assertEquals(currentTestUserName, mainPage.userIsSignedIn());
    }

    @Disabled("A weboldal biztonsági funkciói (captcha védelem) miatt  automatizálása nem javasolt")
    @Test
    @Feature("Érvénytelen bejelentkezés")
    @Story("A felhasználó érvényes felhasználónévvel és érvénytelen jelszóval próbál bejelentkezni")
    @Description("Sikeres bejelentkezés érvénytelen jelszóval")
    public void testLoginWithInvalidPassword() {

        //Bejelentkezés
        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600"); //hibás jelszó
        signInWithIMDbPage.clickSignInButton();





        //Bejelentkezés ellenőrzése a lehetséges hibaüzenetek szövegének vizsgálatával
        String errormessage1 = "Your password is incorrect"; //Hibaüzenet jellemzően az 1. sikertelen  bejelntkezést követően
        String errormessage2 = "Important Message!"; // Hibaüzenet a 2. és azt követő sikertelen bejelentkezést követően

        Assertions.assertTrue(errormessage1.equals(signInWithIMDbPage.firstPasswordError())
                || errormessage2.equals(signInWithIMDbPage.secondPasswordError()));
    }
}
