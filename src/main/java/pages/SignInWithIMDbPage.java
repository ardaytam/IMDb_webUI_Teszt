package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInWithIMDbPage {

    private WebDriver webDriver;

    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");

    public SignInWithIMDbPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        webDriver.findElement(signInButton).click();
    }




}
