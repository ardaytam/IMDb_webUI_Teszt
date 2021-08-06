package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInWithIMDbPage {

    private WebDriver webDriver;

    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");
//    private By passwordError1 = By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span");
//    private By passwordError1 = By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span");


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

//    public String Passworderror() {
//        String passwordErrorMessage = webDriver.findElement(passwordError).getText();
//        return passwordErrorMessage;
//        https://www.imdb.com/ap/signin (get url-lel)

        //*[@id="auth-warning-message-box"]/div/h4

    }



