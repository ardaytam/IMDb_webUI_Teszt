package editprofile;

import base.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.AccountSettingsPage;
import pages.EditProfilePage;
import pages.SignInPage;
import pages.SignInWithIMDbPage;

@Epic("Felhasználói profil beállítása, szerkesztése")
@Feature("A felhasználó beállítja, szerkeszti a profil adatait")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EditProfileTests extends BaseTests {

    @Story("A felhasználó adatokat ad meg és ment el a profiljába")
    @Description("Annak ellenőrzése, hogy a felhasználó képes adatokat megadni és azt elmenteni a profiljába")
    @Test
    @Order(1)
    public void testWriteDescription() {

        //Bejelentkezés
        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztelojunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();


        //Navigálás a Felhasználói profilhoz
        AccountSettingsPage accountSettingsPage = mainPage.clickAccountSettings();

        //A Felhasználói profil szerkesztése, szöveg bevitele a Bio "szövegterületbe"(textarea)
        EditProfilePage editProfilePage = accountSettingsPage.clickEditProfileLink();

        String textToSend = "I was born a month ago. I am an automated program.";
        editProfilePage.writeDescription(textToSend);

        //A szöveg bevitelének ellenőrzése
        accountSettingsPage.clickEditProfileLink();
        Assertions.assertEquals(textToSend, editProfilePage.getDescriptionText());
    }

    @Story("A felhasználó adatokat módosít és ment el a profiljában")
    @Description("Annak ellenőrzése, hogy a felhasználó képes adatokat módosítani és azt elmenteni a profiljába")
    @Test
    @Order(2)
    public void testModifyDescription() {

        //Navigálás a Felhasználói profilhoz
        AccountSettingsPage accountSettingsPage = mainPage.clickAccountSettings();

        //A Felhasználói profil szerkesztése, meglévő szöveg módosítása a Bio "szövegterületben"(textarea)
        EditProfilePage editProfilePage = accountSettingsPage.clickEditProfileLink();

        editProfilePage.modifyDescription("a month","two months");

        //A szöveg módosítás ellenőrzése
        accountSettingsPage.clickEditProfileLink();
        String changedText = "I was born two months ago. I am an automated program.";
        Assertions.assertEquals(changedText, editProfilePage.getDescriptionText());
    }

    @Story("A felhasználó adatokat töröl a profiljából")
    @Description("Annak ellenőrzése, hogy a felhasználó képes adatokat törölni a profiljából")
    @Test
    @Order(3)
    public void testDeleteDescription() {

        //Navigálás a Felhasználói profilhoz
        AccountSettingsPage accountSettingsPage = mainPage.clickAccountSettings();

        //A Felhasználói profil szerkesztése, meglévő szöveg törlése a Bio "szövegterületből"(textarea)
        EditProfilePage editProfilePage = accountSettingsPage.clickEditProfileLink();
        editProfilePage.deleteDescription();

        //A szöveg törlésének ellenőrzése
        accountSettingsPage.clickEditProfileLink();
        Assertions.assertEquals("", editProfilePage.getDescriptionText());
    }
}