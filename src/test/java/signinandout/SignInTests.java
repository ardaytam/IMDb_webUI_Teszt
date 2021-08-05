package signinandout;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SignInPage;
import pages.SignInWithIMDbPage;

public class SignInTests extends BaseTests {

    @Test
    public void testSuccessfulSignIn() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();

        String testUserName = "Junior";
        Assertions.assertTrue(mainPage.userIsSignedIn(testUserName));

    }

}
