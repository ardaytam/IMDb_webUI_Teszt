package signinandout;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SignInPage;
import pages.SignInWithIMDbPage;

@Epic("Kijelentkezés")
public class SignOutTest extends BaseTests {

    @Feature("Sikeres kijelentkezés")
    @Story("A felhasználó sikeresen kijelentkezik az alkalmazásból")
    @Description("Sikeres kijelentkezés az alkalmazásból")
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

