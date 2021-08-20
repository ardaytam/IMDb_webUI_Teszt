package lists;

import base.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignInPage;
import pages.SignInWithIMDbPage;
import pages.YourListsPage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


@Epic("Create list tests")
@Feature("User can create lists from the IMDB database eg. save actors/movies in a list")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Tests should be run in a specific order
public class ListTests extends BaseTests {

    @Story("User can create a list contains her/his favourite actors")
    @Description("Checking that user can create a list contains her/his favourite actors")
    @Test
    @Order(1)
    public void testCreateNewPeopleList() {

        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();



        YourListsPage yourListsPage = mainPage.clickYourLists();

        String listTitle ="My favourite actors";
        String listDescription=  "List of my favourite actors";
        yourListsPage.createNewPeopleList(listTitle,listDescription);


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

        Assertions.assertTrue(driver.getPageSource().contains(listTitle));

        int numberOfNames = driver.findElements(By.xpath("//h3/a")).size();

        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());

        Assertions.assertTrue(numberOfNames == 5, "The list is empty or not all does not contains all names");
    }

    @Story("User can not create list that  contains the same  person's name")
    @Description("Checking that user can not create a list that  contains the same name multiple times")
    @Test
    @Order(2)
    public void testCreateNewPeopleListUsingOnlyOneNameMultipleTimes() {


        YourListsPage yourListsPage = mainPage.clickYourLists();
        yourListsPage.createNewPeopleList("My favourite actor", "List of my favourite actor");

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

        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());

        yourListsPage.finishPeopleListFilling();

       int numberOfNameOccurrences = driver.findElements(By.xpath("//h3/a[contains(text(),\"John Travolta\")]")).size();

       Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());


       Assertions.assertTrue(numberOfNameOccurrences ==1, "The number of Occurences are: " + numberOfNameOccurrences);



    }
}
