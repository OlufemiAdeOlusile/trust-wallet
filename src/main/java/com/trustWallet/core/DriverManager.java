package com.trustWallet.core;

import com.trustWallet.exceptions.AndroidDriverException;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.trustWallet.config.Configs.*;

public class DriverManager {
    public AndroidDriver<MobileElement> getDriver() {
        return createDriver(APPIUM_URL, setupCapabilities());
    }


    private DesiredCapabilities setupCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        capabilities.setCapability(MobileCapabilityType.APP, getBaseDir() + APP_PATH);
        capabilities.setCapability("avd", AVD);
        capabilities.setCapability("avdLaunchTimeout", 1800000000);
        capabilities.setCapability("ensureWebviewsHavePages", true);
        return capabilities;
    }

    private AndroidDriver<MobileElement> createDriver(String url, DesiredCapabilities capabilities) {
        try {
            return new AndroidDriver<>(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            throw new AndroidDriverException("Malformed URL: " + url, e);
        }
    }

    private String getBaseDir() {
        return System.getProperty("user.dir");
    }
}
