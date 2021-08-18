package searching;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AdvancedSearchPage;
import pages.AdvancedSearchResultPage;
import pages.PrivacyPolicyPage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Epic("")//Ezeket magyarul kellene?
@Feature("")


public class AdvancedSearchTest extends BaseTests {
    @Description("Valid Login Test with Valid Username and Valid Password.")
    @Test
    public void testCrawlingThroughSearchResultList() {
        AdvancedSearchPage advancedSearchPage = mainPage.clickAdvancedSearch();
        AdvancedSearchResultPage advancedSearchResultPage = advancedSearchPage.searchMovieByPlotKeywords("orca");

        String numberOfResults=  advancedSearchResultPage.getNumberOfResults();
        String lastResult = advancedSearchResultPage.CrawlingThroughSearchResultList();

        Assertions.assertEquals(numberOfResults +".", lastResult);

    }

    @Description("Valid Login Test with Valid Username and Valid Password.")
    @Test
    public void testSaveSearchResultTitlesToFile() throws Exception {
        AdvancedSearchPage advancedSearchPage = mainPage.clickAdvancedSearch();
        //Searching in Movie pLots contains keyword mosquito
        AdvancedSearchResultPage advancedSearchResultPage = advancedSearchPage.searchMovieByPlotKeywords("COVID-19");
        advancedSearchResultPage.saveSearchResultTitles();


        String lastLineNumber = "50.";
        Assertions.assertEquals(lastLineNumber, getLastLine("searchResultTitles.txt"));
    }

     //Segédmetódus a fájl utolsó sorának kiolvasására
    public String getLastLine(String filename) throws Exception {

        File file = new File(filename);
        String line = new String();
        try {
            InputStreamReader streamReader =
                    new InputStreamReader(new FileInputStream(file));

            BufferedReader br = new BufferedReader(streamReader);

            while (br.ready()) {
                line = br.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String[] splittedline = line.split(" ");
        return splittedline[0];
    }
}