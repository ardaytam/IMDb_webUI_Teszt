package editprofile;

import base.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.AccountSettingsPage;
import pages.EditProfilePage;
import pages.SignInPage;
import pages.SignInWithIMDbPage;

import java.io.ByteArrayInputStream;

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


        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());

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


        AccountSettingsPage accountSettingsPage = mainPage.clickAccountSettings();
        EditProfilePage editProfilePage = accountSettingsPage.clickEditProfileLink();
        editProfilePage.deleteDescription();

        accountSettingsPage.clickEditProfileLink(); //goes back to the previous page

        Assertions.assertEquals("", editProfilePage.getDescriptionText());
    }
}