package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedSearchPage {
    private WebDriver driver;

    private By searchMovieTopicField = By.xpath("//*[@class= \"imdb-search-gateway__text-search-option\"][2]//*[@id=\"query\"]");
    private By rightsearchButton= By.xpath("//div/button[@type=\"submit\"]");

    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public AdvancedSearchResultPage searchMovieByPlotKeywords(String keyword) {

        driver.findElement(searchMovieTopicField).sendKeys(keyword);
        driver.findElement(rightsearchButton).click();
        return new AdvancedSearchResultPage(driver);
    }
//https://www.imdb.com/search/title-text/?plot=orca
}


