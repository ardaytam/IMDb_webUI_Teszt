package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

    private WebDriver driver;
    private By nameField = By.id("ap_customer_name");
    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By checkPasswordField = By.id("ap_password_check");
    private By createAccountButton = By.id("continue");
    private By missingEmailError = By.xpath("//*[@class=\"a-list-item\"]");


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setPasswordCheck(String password) {
        driver.findElement(checkPasswordField).sendKeys(password);
    }

    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
}

    public String missingEmailError() {
        String missingEmailErrorMessage = driver.findElement(missingEmailError).getText();
        return missingEmailErrorMessage;
    }

}

