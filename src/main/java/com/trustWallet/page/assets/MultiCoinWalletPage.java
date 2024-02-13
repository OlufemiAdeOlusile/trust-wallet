package com.trustWallet.page.assets;

import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class MultiCoinWalletPage extends BasePage<MultiCoinWalletPage> {
    private static final By WALLET_NAME_VIEW = By.xpath("//android.widget.TextView[@text='Wallet name']");
    private static final By WALLET_NAME_TEXT_BOX = By.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
    private static final By SECRET_PHRASE_TEXT_BOX = By.xpath("//android.widget.ScrollView/android.widget.EditText[2]");
    private static final By RESTORE_WALLET_BUTTON = By.xpath("//android.widget.TextView[@text='Restore wallet']");

    public MultiCoinWalletPage writeSecretPhrase(String walletName, String secret) {
        this.clearAndType(WALLET_NAME_TEXT_BOX, walletName);
        this.clearAndType(SECRET_PHRASE_TEXT_BOX, secret);
        androidDriver.hideKeyboard();
        return this;
    }

    public void restoreWallet() {
        clickElement(RESTORE_WALLET_BUTTON);
    }

    @Override
    public MultiCoinWalletPage waitForPage() {
        waitForVisibility(WALLET_NAME_VIEW);
        return this;
    }
}
