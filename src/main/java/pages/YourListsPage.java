package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourListsPage {

    private WebDriver driver;

    private By createNewListButton = By.xpath("//*[@id=\"sidebar\"]//button[text()=\"create a new list\"]");
    private By listTitleInput = By.id("list-create-name");
    private By listDescriptionInput = By.id("list-create-description");
    private By listTypeSelector = By.id("list-create-type");
    private By createButton = By.xpath("//*[@id=\"list-create-form\"]/button");
    private By addToListSearchInput = By.id("add-to-list-search");
    private By firstSearchResult = By.xpath("//*[@id=\"add-to-list-search-results\"]/a[1]");
    private By listFillDoneButton = By.xpath("//button[@class= \"btn-raised btn-raised--primary list-edit-done\"]");


    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 10);
    }

    public YourListsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewPeopleList(String title, String description) {
        driver.findElement(createNewListButton).click();

        driver.findElement(listTitleInput).sendKeys(title);

        driver.findElement(listDescriptionInput).sendKeys(description);

        Select selectList = new Select(driver.findElement(listTypeSelector));
        selectList.selectByValue("People");
        driver.findElement(createButton).click();
    }

    public void addNameToPeopleList(String name) {
//        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(addToListSearchInput));

        driver.findElement(addToListSearchInput).sendKeys(name);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(firstSearchResult)).click();
//    getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(firstSearchResult)).click();

        driver.navigate().refresh();
    }

    public void finishPeopleListFilling() {
        driver.findElement(listFillDoneButton).click();
    }
}

