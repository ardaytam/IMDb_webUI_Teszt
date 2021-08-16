package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInWithIMDbPage {

    private WebDriver driver;

    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");
    private By passwordError1 = By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span");
    private By passwordError2 = By.xpath(" //*[@id=\"auth-warning-message-box\"]/div/h4");


    public SignInWithIMDbPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public String firstPasswordError() {
        String result = "";
        try {
            result = driver.findElement(passwordError1).getText();
            }
        catch(Exception NoSuchElementException){
            NoSuchElementException.printStackTrace();
        }
        return result;
    }

    public String secondPasswordError() {
        String result = "";
        try {
            result = driver.findElement(passwordError2).getText();
            System.out.println(result);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;


    }
}



