package privacypolicy;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.PrivacyPolicyPage;


@Epic("Privacy Policy Tests")//Ezeket magyarul kellene?
@Feature("Privacy Policy contains relevant text")
public class PrivacyPolicyTests extends BaseTests {

    @Story("User gets relevant and informative text from Privacy Policy.")
    @Description("Checking that Privacy Policy contains relevant expressions.")
    @ParameterizedTest
    @ValueSource(strings = {"Provide, troubleshoot, and improve IMDb Services",
            "Recommendations and personalization",
            "Comply with legal obligations",
            "Communicate with you",
            "Advertising",
            "Fraud Prevention"})
    public void testRelevantContentOfPrivacyPolicy(String expression) {
        PrivacyPolicyPage privacyPolicyPage = mainPage.clickPrivacyPolicy();
        Assertions.assertTrue(privacyPolicyPage.searchRelevantContentOfPrivacyPolicy(expression));
    }

}
