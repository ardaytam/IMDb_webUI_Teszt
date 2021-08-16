package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

//https://github.com/ardaytam/IMDb_webUI_Teszt
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//JUnitException: @BeforeAll method 'public void base.BaseTests.setUp()' must be static
// unless the test class is annotated with @TestInstance(Lifecycle.PER_CLASS).

public class BaseTests {

    private WebDriver driver;
    protected MainPage mainPage; //test classes can inherit from this


    @BeforeAll
    public void setUp() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options); // új böngésző nyitása az opciókkal
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        driver.get("https://www.imdb.com/");//mainPagebe átteni navigate
        mainPage = new MainPage(driver);

    }

    @BeforeEach

    public void goHomePage (){
        driver.get("https://www.imdb.com/"); //PL Egy tesztosztályban több teszteset van ugyanonnan induljanak
    }
//
//
//    driver.get("https://www.imdb.com"); // Egy tesztosztályban több teszteset van ugyanonnan induljanak
//    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}
    

