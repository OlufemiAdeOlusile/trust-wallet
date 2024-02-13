package com.trustWallet.context;

import com.trustWallet.page.assets.MultiCoinWalletPage;
import com.trustWallet.page.home.HomePage;
import com.trustWallet.page.onboarding.*;
import com.trustWallet.page.widgetAndUtilities.WidgetsPopUpsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OnboardingScenario {
    public String[] secretPhase;

    @Autowired
    public GettingStartedPage gettingStartedPage;

    @Autowired
    public CreateOrAddWalletPage createOrAddWalletPage;

    @Autowired
    public BackUpSecretPage backUpSecretPage;

    @Autowired
    public SecretPhaseTermsAndConditionsPage secretPhaseTermsAndConditionsPage;

    @Autowired
    public CopySecretToClipBoardPage copySecretToClipBoardPage;

    @Autowired
    public ConfirmSecretPhrasePage confirmSecretPhrasePage;

    @Autowired
    public CreatePasscodePage createPasscodePage;

    @Autowired
    public ConfirmPasscodePage confirmPasscodePage;

    @Autowired
    public WidgetsPopUpsUtility widgetsPopUpsUtilities;

    @Autowired
    public HomePage homePage;

    @Autowired
    public AddExistingWalletPage addExistingWalletPage;

    @Autowired
    public SelectNetworkPage selectNetworkPage;

    @Autowired
    public MultiCoinWalletPage multiCoinWalletPage;
}
