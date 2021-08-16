package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePage {

    private WebDriver driver;
    By bioTextBox = By.name("bio");
    By saveDescriptionButton = By.xpath("//*[@class=\"auth-button-link auth-button--primary\"]");

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void writeDescription(String description) {
        driver.findElement(bioTextBox).sendKeys(description);
        driver.findElement(saveDescriptionButton).click();
    }

    public void modifyDescription(String textToModify, String newText)  {
       String originaltext =  getDescriptionText();
       driver.findElement(bioTextBox).clear();
       driver.findElement(bioTextBox).sendKeys(originaltext.replace(textToModify, newText));
       driver.findElement(saveDescriptionButton).click();
    }

    public void deleteDescription()  {
        driver.findElement(bioTextBox).clear();
        driver.findElement(saveDescriptionButton).click();
    }




//*This method return the actual text of the  textarea Webelement called Bio
    public String getDescriptionText() {
        String descriptionText= driver.findElement(bioTextBox).getText();
        return descriptionText;
            }

}
//#main > div > div:nth-child(2) > div:nth-child(2) > textarea
//classname Bio

//*[@id="main"]/div/div[2]/div[2]/textarea
//*[@class="auth-button-link auth-button--primary"]
//linktext