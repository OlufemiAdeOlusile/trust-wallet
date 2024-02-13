package com.trustWallet.page.onboarding;

import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class SelectNetworkPage extends BasePage<SelectNetworkPage> {
    private static final By MULTI_COIN_WALLET_VIEW = By.xpath("//android.widget.TextView[@text='Multi-coin wallet']");

    public void chooseMultiCoinWallet() {
        clickElement(MULTI_COIN_WALLET_VIEW);
    }

    @Override
    public BasePage<SelectNetworkPage> waitForPage() {
        waitForVisibility(MULTI_COIN_WALLET_VIEW);
        return this;
    }
}
