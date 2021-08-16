package lists;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.SignInPage;
import pages.SignInWithIMDbPage;
import pages.YourListsPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


@Epic("Edit Profile Tests")
@Feature("User can write, modify, delete data in the profile")
public class ListTests extends BaseTests {
    @Story("User write Biographic data in the profile")
    @Description("Checking that user can write data in the profile")
    @Test
    public void testCreateNewPeopleList(){

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();

        YourListsPage yourListsPage = mainPage.clickYourLists();
        yourListsPage.createNewPeopleList("My favourite actors", "List of my favourite actors");


        File file = new File("src/main/resources/actors.txt");
        try {

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                yourListsPage.addNameToPeopleList(name);
                System.out.println(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        yourListsPage.finishPeopleListFilling();

    }

}
