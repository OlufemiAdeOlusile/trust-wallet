package com.trustWallet.page.onboarding;

import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class BackUpSecretPage extends BasePage<BackUpSecretPage> {
    private static final By BACK_UP_MANUALLY_BUTTON = By.xpath("//android.widget.TextView[@text='Back up manually']");
    private static final By SKIP_BUTTON = By.xpath("//android.widget.TextView[@text='SKIP']");

    public void backupManually() {
        clickElement(BACK_UP_MANUALLY_BUTTON);
    }

    public void skip() {
        clickElement(SKIP_BUTTON);
    }

    @Override
    public BackUpSecretPage waitForPage() {
        waitForVisibility(BACK_UP_MANUALLY_BUTTON);
        return this;
    }
}
