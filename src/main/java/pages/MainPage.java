package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;


    //    private By userRollDownMenu = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]");//Ezért hasalnak el most a tesztek, mert nem találják
    private By userRollDownMenu = By.xpath("//*[@for=\"navUserMenu\"][2]");//Ezért hasalnak el most a tesztek, mert nem találják

    private By yourListMenuItem = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[5]");
    private By accountSettingsMenuItem = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[6]");
    private By signOutMenuItem = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[7]");
    private By signInMenuItem = By.linkText("Sign In");
    private By privacyPolicyLink = By.linkText("Privacy Policy");
    private By searchOptionsDropdownMenu = By.xpath("//*[@id=\"nav-search-form\"]//div[text()=\"All\"]");
    private By advancedSearchMenuItem = By.xpath("//*[@id=\"navbar-search-category-select-contents\"]/ul/a[7]");


    //*[@id="navbar-search-category-select-contents"]/ul/a//[1] = All
    //*[@id="navbar-search-category-select-contents"]/ul/a//[2] = Titles
    //*[@id="navbar-search-category-select-contents"]/ul/a//[3] = TV Episodes
    //*[@id=\"navbar-search-category-select-contents\"]/ul/a//*[text()=\"Advanced Search\"]"


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //driver.get("https://www.imdb.com/");//mainPagebe átteni navigate

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 10);
    }


    public SignInPage clickSignIn() {
        driver.findElement(signInMenuItem).click();
        return new SignInPage(driver);
    }

    public Boolean userIsSignedIn(String signedinname) {
        Boolean result;
        try {
            result = signedinname.equals(driver.findElement(By.xpath("//div[@class =\"ipc-button__text\"]//*[text()=" + "'" + signedinname + "']")).getText());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }


    public String userIsSignedIn() {
        String result;

        result = driver.findElement(By.xpath("//span[contains(@class, 'user-menu-toggle')]")).getText();

        return result;
    }


    public void clickSignOut() {

        driver.findElement(userRollDownMenu).click();
        driver.findElement(signOutMenuItem).click();
        //*[@id="navUserMenu-contents"]/ul/a[7]

    }

    public AdvancedSearchPage clickAdvancedSearch() {
        driver.findElement(searchOptionsDropdownMenu).click();
        driver.findElement(advancedSearchMenuItem).click();
        return new AdvancedSearchPage(driver);

    }

    public AccountSettingsPage clickAccountSettings() {

        driver.findElement(userRollDownMenu).click();
        driver.findElement(accountSettingsMenuItem).click();
        return new AccountSettingsPage(driver);

    }

    public YourListsPage clickYourLists() {

        driver.findElement(userRollDownMenu).click();
        driver.findElement(yourListMenuItem).click();
        return new YourListsPage(driver);

    }

    public PrivacyPolicyPage clickPrivacyPolicy() {
        driver.findElement(privacyPolicyLink).click();
        return new PrivacyPolicyPage(driver);
    }


}
