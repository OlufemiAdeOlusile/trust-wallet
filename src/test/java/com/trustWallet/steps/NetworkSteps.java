package com.trustWallet.steps;

import com.trustWallet.context.NetworkManagementScenario;
import com.trustWallet.page.BasePage;
import com.trustWallet.page.assets.ManageCryptoPage;
import com.trustWallet.page.home.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;



@Scope("cucumber-glue")
public class NetworkSteps {

    private final NetworkManagementScenario networkManagementScenario;

    public NetworkSteps(NetworkManagementScenario networkManagementScenario) {
        this.networkManagementScenario = networkManagementScenario;
    }

    @And("User navigates to manage crypto page")
    public void userNavigatesToManageCryptoPage() {
        networkManagementScenario.homePage.waitForPage().and().chooseManageCrypto();
    }

    @When("User manages network and returns to home page")
    public void userManagesNetworkAndReturnsToHomePage(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        BasePage<ManageCryptoPage> manageCryptoPage = networkManagementScenario.manageCryptoPage.waitForPage();

        for (Map<String, String> columns : rows) {
            String network = columns.get("network");
            String status = columns.get("status");
            if ("checked".equalsIgnoreCase(status)) {
                manageCryptoPage.and().checkNetwork(network);
            } else {
                manageCryptoPage.and().unCheckNetwork(network);
            }
        }
        manageCryptoPage.and().returnToHomePage();
    }

    @Then("User verifies the following cryptos are displayed on home page")
    public void userVerifiesTheFollowingCryptosAreDisplayedOnHomePage(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        BasePage<HomePage> homePage = networkManagementScenario.homePage.waitForPage();

        for (Map<String, String> columns : rows) {
            String crypto = columns.get("crypto");
            boolean shouldBeDisplayed = Boolean.parseBoolean(columns.get("displayed"));
            boolean isDisplayed = homePage.and().isCryptoDisplayed(crypto);

            String assertionMessage = String.format("Expected crypto '%s' to be %s but was %s.", crypto, shouldBeDisplayed ? "displayed" : "not displayed", isDisplayed ? "displayed" : "not displayed");
            assertEquals(assertionMessage, shouldBeDisplayed, isDisplayed);
        }
    }
}
