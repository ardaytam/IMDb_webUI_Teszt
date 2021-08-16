package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver driver;
    private By createNewAccountButton = By.xpath("//a[text()=\"Create a New Account\"]"); //xpath-szal
    //    private By createNewAccountButton = By.linkText("Create a New Account"); //
//    private By createNewAccountButton = By.cssSelector("#signin-options > div > div:nth-child(4) > a"); //css selectorral
    private By signInWithIMDbButton = By.xpath("//span[text()=\"Sign in with IMDb\"]"); //xpath text metódussal
    //    private By signInWithIMDbButton = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]"); //xpath-szal


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
