package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver driver;
    private By createNewAccountButton = By.xpath("//a[text()=\"Create a New Account\"]");

    private By signInWithIMDbButton = By.xpath("//span[text()=\"Sign in with IMDb\"]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccountPage clickCreateNewAccountButton() {
        driver.findElement(createNewAccountButton).click();
        return new CreateAccountPage(driver);
    }

    public SignInWithIMDbPage clickSignInWithIMDbButton() {
        driver.findElement(signInWithIMDbButton).click();
        return new SignInWithIMDbPage(driver);
    }
}
