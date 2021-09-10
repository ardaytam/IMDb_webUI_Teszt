package lists;

import base.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.SignInPage;
import pages.SignInWithIMDbPage;
import pages.YourListsPage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Epic("Egyedi lista létrehozása")
@Feature("A felhasználó egyedi - pl. színészek adatait tartalmazó - listát állít össze")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Tests should be run in a specific order
public class ListTests extends BaseTests {

    @Story("A felhasználó összeállítja kedvenc színészeinek adatainak listáját")
    @Description("Annak ellenőrzése, hogy a felhasználó képes színészek adatait tartalmazó lista összeállítására")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Order(1)
    public void testCreateNewPeopleList() {

        //Bejelentkezés
        SignInPage signInPage = mainPage.clickSignIn();
        SignInWithIMDbPage signInWithIMDbPage = signInPage.clickSignInWithIMDbButton();
        signInWithIMDbPage.setEmail("autotesztjunior@gmail.com");
        signInWithIMDbPage.setPassword("Oszip12600*");
        signInWithIMDbPage.clickSignInButton();

        //Navigálás az egyedi lista beállításaihoz
        YourListsPage yourListsPage = mainPage.clickYourLists();

        //Egyedi lista címének és leírásnak megadása
        String listTitle ="My favourite actors";
        String listDescription=  "List of my favourite actors";
        yourListsPage.createNewPeopleList(listTitle,listDescription);

        //Színészek neveinek beolvasása és listához adása
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

        //Lista összeállításának befejezése
        yourListsPage.finishPeopleListFilling();

        //Lista létrejöttének és méretének ellenőrzése; képernyőkép készítése a teszt szerveren történő futtatásakor
        Assertions.assertTrue(driver.getPageSource().contains(listTitle));

        int numberOfNames = driver.findElements(By.xpath("//h3/a")).size();

        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());

        Assertions.assertTrue(numberOfNames == 5, "The list is empty or not all does not contains all names");
    }

    @Story("A felhasználó listát állít össze a kedvenc színészeinek nevéből, de többször ugyanazt a nevet adja meg")
    @Description("Annak ellenőrzése, hogy a webalkalmazás meggátolja azonos nevek szerepeltetését a listában")
    @Severity(SeverityLevel.MINOR)
    @Test
    @Order(2)
    public void testCreateNewPeopleListUsingOnlyOneNameMultipleTimes() {

        //Navigálás az egyedi lista beállításaihoz
        YourListsPage yourListsPage = mainPage.clickYourLists();

        //Egyedi lista címének és leírásnak megadása
        yourListsPage.createNewPeopleList("My favourite actor", "List of my favourite actor");

        //Színészek neveinek beolvasása és listához adása
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

        //Lista összeállításának befejezése
        yourListsPage.finishPeopleListFilling();

       //Lista méretének és tartalmának ellenőrzése; képernyőkép készítése a teszt szerveren történő futtatásakor
       int numberOfNameOccurrences = driver.findElements(By.xpath("//h3/a[contains(text(),\"John Travolta\")]")).size();

       Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
       System.out.println(driver.getCurrentUrl());

       Assertions.assertTrue(numberOfNameOccurrences ==1, "The number of occurences are: " + numberOfNameOccurrences);
    }
}
