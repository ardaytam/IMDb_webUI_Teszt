package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver webDriver;

    private By userRollDownMenu = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]");
    private By signOutMenuItem = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[7]");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public SignInPage clickSignIn() {
        clickLink("Sign In");  //there is only one method use this, if there are more -> place on the top
        return new SignInPage(webDriver);
    }

    public Boolean userIsSignedIn(String testUserName) {
        Boolean result;
        if (testUserName.equals(webDriver.findElement(By.xpath("//div[@class =\"ipc-button__text\"]//*[text()=\"Junior\"]")).getText())) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public Boolean userIsNotSignedIn (String signinlegend) {
        Boolean result;
        if (signinlegend.equals(webDriver.findElement(By.xpath("//*[text()=\"Sign In\"]")).getText())) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public void clickSignOut() {
        webDriver.findElement(userRollDownMenu).click();
        webDriver.findElement(signOutMenuItem).click();
        //*[@id="navUserMenu-contents"]/ul/a[7]

    }

    public PrivacyPolicyPage clickPrivacyPolicy() {
        clickLink("Privacy Policy");  //there is only one method use this, if there are more -> place on the top
        return new PrivacyPolicyPage(webDriver);
    }

    private void clickLink(String linktext) { //private <-- tests do not need to call it
        webDriver.findElement(By.linkText(linktext)).click();
    } //generic method for clicking on a link

}
