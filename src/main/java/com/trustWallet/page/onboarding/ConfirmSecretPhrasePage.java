package com.trustWallet.page.onboarding;

import com.trustWallet.page.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfirmSecretPhrasePage extends BasePage<ConfirmSecretPhrasePage> {

    private static final By TAP_CORRECT_ANSWER_SUB_HEADING = By.xpath("//android.widget.TextView[@text='Please tap on the correct answer of the below seed phrases.']");
    private static final By WORD_SUB_HEADINGS = By.xpath("//android.widget.TextView[contains(@text, 'Word #')]");
    private static final By CONFIRM_BUTTON = By.xpath("//android.widget.TextView[@text='Confirm']");

    private By secretWord(String text) {
        return By.xpath("//android.widget.TextView[@text='" + text + "']");
    }

    public void fillSecretsBasedOnWords(String[] secrets) {
        List<MobileElement> wordElements = androidDriver.findElements(WORD_SUB_HEADINGS);

        for (MobileElement element : wordElements) {
            String text = element.getText();
            String[] parts = text.split("#");
            int index = Integer.parseInt(parts[1].trim()) - 1;
            String secret = secrets[index];
            clickElement(secretWord(secret));
        }

        clickElement(CONFIRM_BUTTON);
    }

    @Override
    public ConfirmSecretPhrasePage waitForPage() {
        waitForVisibility(TAP_CORRECT_ANSWER_SUB_HEADING);
        return this;
    }
}
