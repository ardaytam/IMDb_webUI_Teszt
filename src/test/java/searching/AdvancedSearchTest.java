package searching;

import base.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pages.AdvancedSearchPage;
import pages.AdvancedSearchResultPage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Epic("Összetett keresési funkció tesztelése")
@Feature("Találati lista bejárása, mentése")


public class AdvancedSearchTest extends BaseTests {
    @Story("A felhasználó szeretné végiglapozni az összetett keresés eredményeként kapott találati listát")
    @Description("Összetett keresés eredményeként kapott több oldalas találati lista bejárása")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testCrawlingThroughSearchResultList() {

        //Navigálás az Összetett keresés oldalra
        AdvancedSearchPage advancedSearchPage = mainPage.clickAdvancedSearch();

        //Keresőkifejezés bevitele
        AdvancedSearchResultPage advancedSearchResultPage = advancedSearchPage.searchMovieByPlotKeywords("orca");

        //Találati lista ellenőrzése: az utolsó listaelem sorszámának egyezése az összes elem számával
        String numberOfResults=  advancedSearchResultPage.getNumberOfResults();
        String lastResult = advancedSearchResultPage.CrawlingThroughSearchResultList();

        Assertions.assertEquals(numberOfResults +".", lastResult);

    }

    @Story("Az összetett keresés eredményeként kapott lista első 50 elemének címét fájlba mentése")
    @Description("Találati lista első 50 címének  megjelenítése és fájlba mentése")
    @Severity(SeverityLevel.NORMAL)
    @RepeatedTest(3)
    public void testSaveSearchResultTitlesToFile() throws Exception {

        //Navigálás az Összetett keresés oldalra
        AdvancedSearchPage advancedSearchPage = mainPage.clickAdvancedSearch();

        //Keresőkifejezés bevitele
        AdvancedSearchResultPage advancedSearchResultPage = advancedSearchPage.searchMovieByPlotKeywords("COVID-19");

        //A lista címeinek fájlba mentése
        advancedSearchResultPage.saveSearchResultTitles();


        //Találati lista ellenőrzése: az utolsó listaelem és a listát tartalmazó fájl utolsó sorának összevetése
        String lastLineNumber = "50.";
        String lastLineWithEpisode = "Episode:";
        Assertions.assertTrue(lastLineNumber.equals( getLastLine("searchResultTitles.txt"))
                ||lastLineWithEpisode.equals( getLastLine("searchResultTitles.txt")));
    }

    //Segédmetódus a fájl utolsó sorának kiolvasásához
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