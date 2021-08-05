package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

    private WebDriver webDriver;
    private By nameField = By.id("ap_customer_name");
    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By checkPasswordField = By.id("ap_password_check");
    private By createAccountButton = By.id("continue");


    public CreateAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setName(String name) {
        webDriver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }
    public void setPasswordCheck(String password) {
        webDriver.findElement(checkPasswordField).sendKeys(password);
    }
    public void clickCreateAccountButton() {
        webDriver.findElement(createAccountButton).click();
}
}

