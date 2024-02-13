package com.trustWallet.steps;

import com.trustWallet.context.OnboardingScenario;
import com.trustWallet.page.BasePage;
import com.trustWallet.page.onboarding.ConfirmPasscodePage;
import com.trustWallet.page.onboarding.CreatePasscodePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Scope("cucumber-glue")
public class OnboardingSteps {

    private final OnboardingScenario onboardingScenario;

    public OnboardingSteps(OnboardingScenario onboardingScenario) {
        this.onboardingScenario = onboardingScenario;
    }

    @Given("User is on homepage with new MultiCoin wallet")
    public void userIsOnHomepageWithNewMultiCoinWallet() {
        onboardingScenario.gettingStartedPage.waitForPage().and().clickGettingStarted();
        onboardingScenario.createOrAddWalletPage.waitForPage().and().chooseCreateNewWallet();
        onboardingScenario.backUpSecretPage.waitForPage().and().skip();

        String[] passCode = {"1", "2", "3", "4", "5", "6"};
        BasePage<CreatePasscodePage> createPasscodePageBasePage = onboardingScenario.createPasscodePage.waitForPage();
        Arrays.stream(passCode).forEach(f -> {
            createPasscodePageBasePage.and().inputPassCode(f);
        });

        BasePage<ConfirmPasscodePage> confirmPasscodePageBasePage = onboardingScenario.confirmPasscodePage.waitForPage();
        Arrays.stream(passCode).forEach(f -> {
            confirmPasscodePageBasePage.and().inputPassCode(f);
        });

        onboardingScenario.widgetsPopUpsUtilities.startUsingTrustWallet();
        onboardingScenario.widgetsPopUpsUtilities.allowNotifications();

        onboardingScenario.homePage.waitForPage();
    }

    @Given("User creates wallet with no secret phase or back up")
    public void userCreatesWalletWithNoSecretPhaseOrBackUp() {
        onboardingScenario.gettingStartedPage.waitForPage().and().clickGettingStarted();
        onboardingScenario.createOrAddWalletPage.waitForPage().and().chooseCreateNewWallet();
        onboardingScenario.backUpSecretPage.waitForPage().and().skip();
    }

    @And("User sets a passcode {string}")
    public void userIncludesAPasscode(String passcode) {
        String[] passCode = passcode.split(",");
        BasePage<CreatePasscodePage> createPasscodePageBasePage = onboardingScenario.createPasscodePage.waitForPage();
        Arrays.stream(passCode).forEach(f -> {
            createPasscodePageBasePage.and().inputPassCode(f);
        });

        BasePage<ConfirmPasscodePage> confirmPasscodePageBasePage = onboardingScenario.confirmPasscodePage.waitForPage();
        Arrays.stream(passCode).forEach(f -> {
            confirmPasscodePageBasePage.and().inputPassCode(f);
        });
    }

    @Then("Wallet should be displayed on homepage with name {string}")
    public void newWalletShouldBeCreatedWithName(String walletName) {
        onboardingScenario.widgetsPopUpsUtilities.startUsingTrustWallet();
        onboardingScenario.widgetsPopUpsUtilities.allowNotifications();

        boolean walletDisplayed = onboardingScenario.homePage.waitForPage().and().isWalletDisplayed(walletName);
        assertTrue(walletDisplayed);
    }

    @Given("User creates wallet with secret phase")
    public void userCreatesWalletWithSecretPhase() {
        onboardingScenario.gettingStartedPage.waitForPage().and().clickGettingStarted();
        onboardingScenario.createOrAddWalletPage.waitForPage().and().chooseCreateNewWallet();
        onboardingScenario.backUpSecretPage.waitForPage().and().backupManually();
        onboardingScenario.secretPhaseTermsAndConditionsPage.waitForPage().and().acceptAll();
        onboardingScenario.secretPhase = onboardingScenario.copySecretToClipBoardPage.waitForPage().and().copySecret();

        onboardingScenario.confirmSecretPhrasePage.waitForPage().and().fillSecretsBasedOnWords(onboardingScenario.secretPhase);
    }

    @When("User resets the app")
    public void userResetsTheApp() {
        onboardingScenario.widgetsPopUpsUtilities.resetApp();
    }

    @And("User adds existing wallet with secret phase and name {string}")
    public void userAddsExistingWalletWithSecretPhaseAndName(String walletName) {

        onboardingScenario.gettingStartedPage.waitForPage().and().clickGettingStarted();
        onboardingScenario.createOrAddWalletPage.waitForPage().and().chooseAddExistingWallet();
        onboardingScenario.addExistingWalletPage.waitForPage().and().chooseSecretPhrase();
        onboardingScenario.selectNetworkPage.waitForPage().and().chooseMultiCoinWallet();

        String secret = String.join(" ", onboardingScenario.secretPhase);
        onboardingScenario.multiCoinWalletPage.waitForPage().and().writeSecretPhrase(walletName, secret).and().restoreWallet();
    }
}
