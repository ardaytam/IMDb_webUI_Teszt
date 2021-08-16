package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchResultPage {

    private WebDriver driver;
    private By nextPageLink = By.cssSelector("#main > div > div:nth-child(3) > a.lister-page-next.next-page");
    //    private By previousPageLink = By.cssSelector("#main > div > div:nth-child(3) > a.lister-page-prev.prev-page");
    private By NumberOfResultListItem = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[1]/div[3]/h3/span[1]");

    //*[@id="main"]/div/div[1]/span[1]


    public AdvancedSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 10);
    }

    public void CrawlingThroughSearchResultList() {


        while (true) {
            String LastItemNumber = null;
            try {
//                List<WebElement> resultItemNumberList = driver.findElements(NumberOfResultListItem);

                getWebDriverWait().until(ExpectedConditions.elementToBeClickable(nextPageLink));
//                getWebDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NumberOfResultListItem));
//                LastItemNumber = resultItemNumberList.get(resultItemNumberList.size() - 1).getText();
//                System.out.println(LastItemNumber);
                driver.findElement(nextPageLink).click();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
