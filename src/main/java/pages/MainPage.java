package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    private By userRollDownMenu = By.xpath("//*[@for=\"navUserMenu\"][2]");

    private By yourListMenuItem = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[5]");
    private By accountSettingsMenuItem = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[6]");
    private By signOutMenuItem = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[7]");
    private By signInMenuItem = By.linkText("Sign In");
    private By privacyPolicyLink = By.linkText("Privacy Policy");
    private By searchOptionsDropdownMenu = By.xpath("//*[@id=\"nav-search-form\"]//div[text()=\"All\"]");
    private By advancedSearchMenuItem = By.xpath("//*[@id=\"navbar-search-category-select-contents\"]/ul/a[7]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickSignIn() {
        driver.findElement(signInMenuItem).click();
        return new SignInPage(driver);
    }

    public String userIsSignedIn() {
        String result = "";
        try {
            result = driver.findElement(By.xpath("//span[contains(@class, 'user-menu-toggle')]")).getText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void clickSignOut() {

        driver.findElement(userRollDownMenu).click();
        driver.findElement(signOutMenuItem).click();
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
