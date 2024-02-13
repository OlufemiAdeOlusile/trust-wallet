package com.trustWallet.page.home;

import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage<HomePage> {
    private static final By MAIN_BALANCE = By.xpath("//android.widget.TextView[@resource-id='main_balance']");
    private static final By MANAGE_CRYPTO_BUTTON = By.xpath("//android.widget.TextView[@text='Home']/following-sibling::android.widget.Button");

    private By walletView(String walletName) {
        return By.xpath("//android.widget.TextView[@text='" + walletName + "']");
    }

    private By cryptoView(String crypto) {
        return By.xpath("//android.widget.TextView[@text='" + crypto + "']");
    }

    public void chooseManageCrypto() {
        clickElement(MANAGE_CRYPTO_BUTTON);
    }

    public boolean isWalletDisplayed(String walletName) {
        return isElementDisplayed(walletView(walletName));
    }

    public boolean isCryptoDisplayed(String crypto) {
        return isElementDisplayed(cryptoView(crypto));
    }

    @Override
    public BasePage<HomePage> waitForPage() {
        waitForVisibility(MAIN_BALANCE);
        return this;
    }
}
