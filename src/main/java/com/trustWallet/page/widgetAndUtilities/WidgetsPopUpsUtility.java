package com.trustWallet.page.widgetAndUtilities;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class WidgetsPopUpsUtility extends BaseWidget {
    public void startUsingTrustWallet() {
        By startUsingWalletButton = By.xpath("//android.widget.TextView[@text=\"Start using Trust Wallet\"]");
        waitForClickableAndClick(startUsingWalletButton);
    }

    public void allowNotifications() {
        By allowNotification = By.id("com.android.permissioncontroller:id/permission_allow_button");
        waitForClickableAndClick(allowNotification);
    }

    public void resetApp(){
        androidDriver.resetApp();
    }
}
