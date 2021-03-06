package privacypolicy;

import base.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.PrivacyPolicyPage;


@Epic("Adatvkezelési házirend/nyilatkozat (Privacy Policy) használata")
@Feature("Az adatkezelési nyilatkozat releváns elemeket tartalmaz")
public class PrivacyPolicyTests extends BaseTests {

    @Story("A felhasználó releváns szöveget szeretne találni az adatkezelési nyilatkozatban.")
    @Description("Annak ellenőrzése, hogy az Adatkezelési Nyilatkozat releváns elemeket tartalmaz")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(strings = {"Provide, troubleshoot, and improve IMDb Services",
            "Recommendations and personalization",
            "Comply with legal obligations",
            "Communicate with you",
            "Advertising",
            "Fraud Prevention"})
    public void testRelevantContentOfPrivacyPolicy(String expression) {

        //Navigálás az Adatkezelési Nyilatkozatot tartalmazó oldalra
        PrivacyPolicyPage privacyPolicyPage = mainPage.clickPrivacyPolicy();

        //Az Adatkezelési Nyilatkozat tartalmának összevetése a paraméterként kapott kifejezéseekel
        Assertions.assertTrue(privacyPolicyPage.searchRelevantContentOfPrivacyPolicy(expression));
    }
}
