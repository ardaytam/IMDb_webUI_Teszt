package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchResultPage {

    private WebDriver driver;
    private By nextPageLink = By.cssSelector("#main > div > div:nth-child(3) > a.lister-page-next.next-page");
    //    private By previousPageLink = By.cssSelector("#main > div > div:nth-child(3) > a.lister-page-prev.prev-page");
    private By numberOfResultListItem = By.xpath("//*[@id=\"main\"]/div/div[1]/span[1]");
    private By LastNumberOfResultListItem = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[last()]/div[3]/h3/span[1]");
    private By resultTitles = By.className("lister-item-header");


    public AdvancedSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 10);
    }


    public String getNumberOfResults() {
        String resultNumberLong = driver.findElement(numberOfResultListItem).getText();
        System.out.println(resultNumberLong);
        String [] result = resultNumberLong.split(" ");
        System.out.println(result[2]);
        return result[3]; //return the number 809 from "1-50 of 809 titles."

    }

    public String CrawlingThroughSearchResultList() {
        String lastItemNumber ="";
        while (true) {


            //              getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(LastNumberOfResultListItem));

            try {
                lastItemNumber = driver.findElement(LastNumberOfResultListItem).getText();
              System.out.println(lastItemNumber);
                getWebDriverWait().until(ExpectedConditions.elementToBeClickable(nextPageLink));
                driver.findElement(nextPageLink).click();

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
//
        }
        return lastItemNumber;
    }

    public void saveSearchResultTitles() {

        try {
            List<WebElement> elements = driver.findElements(resultTitles);
            FileWriter myWriter = new FileWriter("searchResultTitles.txt");
            for (int i = 0; i < elements.size(); i++) {

                myWriter.append((elements.get(i).getText() + "\n"));

            }
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


