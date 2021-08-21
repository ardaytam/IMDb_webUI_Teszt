package signinandout;

import base.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SignInPage;
import pages.SignInWithIMDbPage;

@Epic("Kijelentkezés")
public class SignOutTest extends BaseTests {

    @Feature("Sikeres kijelentkezés")
    @Story("A felhasználó sikeresen kijelentkezik az alkalmazásból")
    @Description("Annak ellenőrzése, hogy a felhasználó sikeresen ki tud jelentkezni az alkalmazásból\n")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testSuccessfulSignOut() {

        //Bejelentkezés
        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztelojunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();

        //Kijelentkezés menüpont használata a felhasználói menüből
        mainPage.clickSignOut();

        //Kijelentkezés sikerességének ellnőrzése
        String currentTestUserName = "Junior";
        Assertions.assertNotEquals(currentTestUserName, mainPage.userIsSignedIn());
    }
}

