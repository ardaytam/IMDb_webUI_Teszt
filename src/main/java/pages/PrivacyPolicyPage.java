package pages;

import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage {

    private WebDriver driver;

    public PrivacyPolicyPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public boolean searchRelevantContentOfPrivacyPolicy(String expression) {

        boolean isExpressionThere = driver.getPageSource().contains(expression);
        return isExpressionThere;
    }
}