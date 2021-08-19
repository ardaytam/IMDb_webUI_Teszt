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


@Epic("Create list tests")
@Feature("User can create lists from the IMDB database eg. save actors/movies in a list")
public class ListTests extends BaseTests {
    @Story("User can create a list contains her/his favourite actors")
    @Description("Checking that user can create a list contains her/his favourite actors")
    @Test
    public void testCreateNewPeopleList() {

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

//Assertion missing

        mainPage.clickSignOut();

    }

    //sign out!!!
    @Story("User can not create list that  contains the same  person's name")
    @Description("Checking that user can not create a list that  contains the same name multiple times")
    @Test
    public void testCreateNewPeopleListUsingOnlyOneNameMultipleTimes() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();

        YourListsPage yourListsPage = mainPage.clickYourLists();
        yourListsPage.createNewPeopleList("My favourite actor", "List of my favourite actor");

        //Assertion missing

        mainPage.clickSignOut();

        File file = new File("src/main/resources/redundant_actors.txt");
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
