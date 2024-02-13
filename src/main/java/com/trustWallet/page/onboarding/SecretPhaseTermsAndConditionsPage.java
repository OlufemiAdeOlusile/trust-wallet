package com.trustWallet.page.onboarding;


import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class SecretPhaseTermsAndConditionsPage extends BasePage<SecretPhaseTermsAndConditionsPage> {
    private static final By SECRET_PHASE_HEADING_TEXT = By.xpath("//android.widget.TextView[@text='This secret phrase is the master key to your wallet']");
    private static final By TRUST_WALLET_DOES_NOT_KEEP_A_COPY_CHECK_BOX = By.xpath("//android.widget.TextView[@text='Trust Wallet does not keep a copy of your secret phrase.']");
    private static final By SAVING_THIS_DIGITALLY_INFO_CHECK_BOX = By.xpath("//android.widget.TextView[@text='Saving this digitally in plain text is NOT recommended. Examples include screenshots, text files, or emailing yourself']");
    private static final By WRITE_DOWN_YOUR_SECRET_INFO_CHECK_BOX = By.xpath("//android.widget.TextView[@text='Write down your secret phrase, and store it in a secure offline location!']");
    public void acceptAll() {
        acceptTerm(TRUST_WALLET_DOES_NOT_KEEP_A_COPY_CHECK_BOX);
        acceptTerm(SAVING_THIS_DIGITALLY_INFO_CHECK_BOX);
        acceptTerm(WRITE_DOWN_YOUR_SECRET_INFO_CHECK_BOX);
        clickElement(CONTINUE_BUTTON);
    }

    private void acceptTerm(By checkBoxLocator) {
        waitForClickableAndClick(checkBoxLocator);
    }

    @Override
    public BasePage<SecretPhaseTermsAndConditionsPage> waitForPage() {
        waitForVisibility(SECRET_PHASE_HEADING_TEXT);
        return this;
    }
}
