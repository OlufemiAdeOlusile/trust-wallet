package com.trustWallet.page.onboarding;

import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class CreatePasscodePage extends BasePage<CreatePasscodePage> {
    private static final By CREATE_PASSCODE = By.xpath("//android.widget.TextView[@text='Create passcode']");

    private By passCodeButtons(String text) {
        return By.xpath("//android.widget.TextView[@text='" + text + "']");
    }

    public void inputPassCode(String passcodeNumber) {
        clickElement(passCodeButtons(passcodeNumber));
    }

    @Override
    public CreatePasscodePage waitForPage() {
        waitForVisibility(CREATE_PASSCODE);
        return this;
    }
}
