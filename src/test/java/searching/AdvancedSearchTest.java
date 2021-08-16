package searching;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AdvancedSearchPage;
import pages.AdvancedSearchResultPage;
import pages.PrivacyPolicyPage;

@Epic("")//Ezeket magyarul kellene?
@Feature("")


public class AdvancedSearchTest extends BaseTests {

    @Test
    public void testCrawlingThroughSearchResultList() {
        AdvancedSearchPage advancedSearchPage = mainPage.clickAdvancedSearch();
        //Searching in Movie pLots contains keyword Orca
        AdvancedSearchResultPage advancedSearchResultPage = advancedSearchPage.searchMovieByPlotKeywords("orca");
        advancedSearchResultPage.CrawlingThroughSearchResultList();


//        Assertions.assertTrue(privacyPolicyPage.searchRelevantContentOfPrivacyPolicy(expression));
    }


}
