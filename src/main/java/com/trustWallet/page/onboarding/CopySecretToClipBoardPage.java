package com.trustWallet.page.onboarding;


import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class CopySecretToClipBoardPage extends BasePage<CopySecretToClipBoardPage> {
    private static final By COPY_TO_CLIPBOARD_BUTTON = By.xpath("//android.widget.TextView[@text='Copy to Clipboard']");
    private static final By SECRET_PHRASE_HEADER = By.xpath("//android.widget.TextView[@text='Secret phrase']");
    public String[] copySecret() {
        clickElement(COPY_TO_CLIPBOARD_BUTTON);

        String[] secret = androidDriver.getClipboardText().split("\\s+");
        androidDriver.hideKeyboard();

        clickElement(SECRET_PHRASE_HEADER);
        clickElement(CONTINUE_BUTTON);

        return secret;
    }

    @Override
    public CopySecretToClipBoardPage waitForPage() {
        waitForVisibility(COPY_TO_CLIPBOARD_BUTTON);
        return this;
    }

}
