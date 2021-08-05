package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//JUnitException: @BeforeAll method 'public void base.BaseTests.setUp()' must be static
// unless the test class is annotated with @TestInstance(Lifecycle.PER_CLASS).

public class BaseTests {

    private WebDriver webDriver;
    protected MainPage mainPage; //test classes can inherit from this


    @BeforeAll
    public void setUp() {

//        System.setProperty("webdriver.chrome.webdriver", "chromedriver.exe");
//        driver = new ChromeDriver();
//System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); /A WebDriver manager elintézi ezt a dolgot

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // teljes képernyőben való használat
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        webDriver = new ChromeDriver(options); // új böngésző nyitása az opciókkal
        webDriver.get("https://www.imdb.com/");

        mainPage = new MainPage(webDriver);


    }

//    @BeforeEach
//
//    public void goHomePage() {
//        webDriver.get("https://www.imdb.com"); //PL Egy tesztosztályban több teszteset van ugyanonnan induljanak
//    }

    @AfterAll
    public void tearDown() {
        webDriver.quit();
    }

}
    

