package com.trustWallet.page.onboarding;

import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ConfirmPasscodePage extends BasePage<ConfirmPasscodePage> {
    private static final By CONFIRM_PASSCODE = By.xpath("//android.widget.TextView[@text='Confirm passcode']");

    private By passCodeButtons(String text) {
        return By.xpath("//android.widget.TextView[@text='" + text + "']");
    }

    public void inputPassCode(String passcodeNumber) {
        clickElement(passCodeButtons(passcodeNumber));
    }

    @Override
    public ConfirmPasscodePage waitForPage() {
        waitForVisibility(CONFIRM_PASSCODE);
        return this;
    }
}
