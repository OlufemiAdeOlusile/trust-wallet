package com.trustWallet.config;

import com.trustWallet.core.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@ComponentScan(basePackages = "com.trustWallet.page")
public class AppConfig {
    @Value("${appium.wait.timeout:30}")
    private long timeoutInSeconds;

    @Value("${appium.wait.polling:1}")
    private long pollingInSeconds;

    @Bean(destroyMethod = "quit")
    public AndroidDriver<MobileElement> androidDriver() {
        return new DriverManager().getDriver();
    }

    @Bean
    public FluentWait<AndroidDriver<MobileElement>> mobileWait(AndroidDriver<MobileElement> androidDriver) {
        return new FluentWait<>(androidDriver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(pollingInSeconds))
                .ignoring(NoSuchElementException.class);
    }

}
