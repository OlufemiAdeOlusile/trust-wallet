package com.trustWallet.page.onboarding;

import com.trustWallet.page.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class CreateOrAddWalletPage extends BasePage<CreateOrAddWalletPage> {
    private static final By CREATE_NEW_WALLET_BUTTON = By.xpath("//android.widget.TextView[@text='Create new wallet']");
    private static final By ADD_WALLET_BUTTON = By.xpath("//android.widget.TextView[@text='Add existing wallet']");

    public void chooseCreateNewWallet() {
        clickElement(CREATE_NEW_WALLET_BUTTON);
    }

    public void chooseAddExistingWallet() {
        clickElement(ADD_WALLET_BUTTON);
    }

    @Override
    public CreateOrAddWalletPage waitForPage() {
        waitForVisibility(CREATE_NEW_WALLET_BUTTON);
        return this;
    }
}
