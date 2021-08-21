package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSettingsPage {

    private WebDriver driver;
    private By editProfileLink = By.linkText("Edit profile");

    public AccountSettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public EditProfilePage clickEditProfileLink() {
        driver.findElement(editProfileLink).click();
        return new EditProfilePage(driver);
    }
}