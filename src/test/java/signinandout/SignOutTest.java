package signinandout;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SignInPage;
import pages.SignInWithIMDbPage;

public class SignOutTest extends BaseTests {

    @Test
    public void testSuccessfulSignOut() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();
        mainPage.clickSignOut();

        String currentTestUserName = "Junior";
        Assertions.assertFalse(mainPage.userIsSignedIn(currentTestUserName));

    }

}

