package editprofile;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.AccountSettingsPage;
import pages.EditProfilePage;
import pages.SignInPage;
import pages.SignInWithIMDbPage;

@Epic("Edit Profile Tests")
@Feature("User can write, modify, delete data in the profile")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Tests should be run in a specific order
public class EditProfileTests extends BaseTests {

    @Story("User write Biographic data in the profile")
    @Description("Checking that user can write data in the profile")
    @Test
    @Order(1)
    public void testWriteDescription() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();

        AccountSettingsPage accountSettingsPage = mainPage.clickAccountSettings();
        EditProfilePage editProfilePage = accountSettingsPage.clickEditProfileLink();

        String textToSend = "I was born a month ago. I am an automated program.";
        editProfilePage.writeDescription(textToSend);
        accountSettingsPage.clickEditProfileLink(); //goes back to the previous page


        Assertions.assertEquals(textToSend, editProfilePage.getDescriptionText());


    }

    @Story("User modify Biographic data in the profile")
    @Description("Checking that user can overwrite data in the profile")
    @Test
    @Order(2)
    public void testModifyDescription() {

//        SignInPage signInPage = mainPage.clickSignIn();
//        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
//        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
//        signInWithIMDbPage.setPassword("Oszip12600*");
//        signInWithIMDbPage.clickSignInButton();
//
        AccountSettingsPage accountSettingsPage = mainPage.clickAccountSettings();
        EditProfilePage editProfilePage = accountSettingsPage.clickEditProfileLink();


        editProfilePage.modifyDescription("a month","two months");

        accountSettingsPage.clickEditProfileLink(); //goes back to the previous page

        String changedText = "I was born two months ago. I am an automated program.";
        Assertions.assertEquals(changedText, editProfilePage.getDescriptionText());
    }

    @Story("User delete Biographic data in the profile")
    @Description("Checking that user can delete data from the profile")
    @Test
    @Order(3)
    public void testDeleteDescription() {

//        SignInPage signInPage = mainPage.clickSignIn();
//        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
//        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
//        signInWithIMDbPage.setPassword("Oszip12600*");
//        signInWithIMDbPage.clickSignInButton();

        AccountSettingsPage accountSettingsPage = mainPage.clickAccountSettings();
        EditProfilePage editProfilePage = accountSettingsPage.clickEditProfileLink();
        editProfilePage.deleteDescription();

        accountSettingsPage.clickEditProfileLink(); //goes back to the previous page

        Assertions.assertEquals("", editProfilePage.getDescriptionText());
    }
}