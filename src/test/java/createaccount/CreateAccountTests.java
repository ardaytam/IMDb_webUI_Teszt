package createaccount;

import base.BaseTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.CreateAccountPage;
import pages.SignInPage;


public class CreateAccountTests extends BaseTests {

    

    @Disabled("Can not be automatized cause the email verification process")
    @Test
    public void testSuccessfullRegistration() {
        SignInPage signInPage = mainPage.clickSignIn();
        CreateAccountPage createAccountPage = signInPage.clickCreateNewAccountButton();
//        CreateAccountPage createAccountPage = mainPage.clickSignIn().clickCreateNewAccountButton();
        createAccountPage.setName("Junior Autoteszt");
        createAccountPage.setEmail("autotesztjunior@gmail.com");
        createAccountPage.setPassword("Oszip12600*");
        createAccountPage.setPasswordCheck("Oszip12600*");
        createAccountPage.clickCreateAccountButton();

        //*[@id="imdbHeader"]/div[2]/div[5]/div/label[2]/div/span
        //div[@class ="ipc-button__text"]//*[text()="Junior"]


//        Assertions.assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),"Alert text is incorrect");
//        Assertions.assertEquals("You logged into a secure area!", alertmessage, "Alert text is incorrect");//nem lesz jó mert sortörést is egy x-et is beletesz
    }

}
