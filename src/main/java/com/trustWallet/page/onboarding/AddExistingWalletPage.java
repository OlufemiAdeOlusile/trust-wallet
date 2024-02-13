package com.trustWallet.page.onboarding;

import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class AddExistingWalletPage extends BasePage<AddExistingWalletPage> {
    private static final By SECRET_PHRASE_BUTTON = By.xpath("//android.widget.TextView[@text='Secret phrase']");

    public void chooseSecretPhrase() {
        clickElement(SECRET_PHRASE_BUTTON);
    }

    @Override
    public AddExistingWalletPage waitForPage() {
        waitForVisibility(SECRET_PHRASE_BUTTON);
        return this;
    }
}
