package com.trustWallet.page.assets;

import com.trustWallet.page.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ManageCryptoPage extends BasePage<ManageCryptoPage> {
    private static final By ALL_NETWORKS_BUTTON = By.xpath("//android.widget.TextView[@text='All networks']");

    private By manageCryptoNetworkCheckBox(String network) {
        return By.xpath("//android.widget.TextView[@text='" + network + "']/following-sibling::android.view.View");
    }

    public void checkNetwork(String network) {
        MobileElement checkbox = androidDriver.findElement(manageCryptoNetworkCheckBox(network));
        if (!Boolean.parseBoolean(checkbox.getAttribute("checked"))) {
            clickElement(manageCryptoNetworkCheckBox(network));
        }
    }

    public void unCheckNetwork(String network) {
        MobileElement checkbox = androidDriver.findElement(manageCryptoNetworkCheckBox(network));
        if (Boolean.parseBoolean(checkbox.getAttribute("checked"))) {
            clickElement(manageCryptoNetworkCheckBox(network));
        }
    }

    public void returnToHomePage() {
        clickElement(BACK_BUTTON);
    }

    @Override
    public ManageCryptoPage waitForPage() {
        waitForVisibility(ALL_NETWORKS_BUTTON);
        return this;
    }
}
