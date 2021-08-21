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


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTests {

    protected WebDriver driver;
    protected MainPage mainPage;

    // A ChromeDriver beállítása a WebDriverManager használatával
    // A ChromeDriver és a MainPage példányosítása a tesztosztályok futtatásanak megkezdése előtt
    @BeforeAll
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--incognito");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
    }

    //Visszaugrás a főoldalra, minden teszteset/tesztmetódus lefutását követően
    @BeforeEach
    public void goHomePage() {
        driver.get("https://www.imdb.com/");
    }

    //Kilépés a böngészőből a tesztoszályok futtatása után
    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
    

