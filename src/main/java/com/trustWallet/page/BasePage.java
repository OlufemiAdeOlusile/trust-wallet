package com.trustWallet.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public abstract class BasePage<V> {
    protected static final By CONTINUE_BUTTON = By.xpath("//android.widget.TextView[@text='Continue']");
    protected static final By BACK_BUTTON = By.xpath("//android.view.View[@content-desc='Back']");
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    @Autowired
    protected AndroidDriver<MobileElement> androidDriver;

    public abstract BasePage<V> waitForPage();

    @SuppressWarnings("unchecked")
    public V and() {
        return (V) this;
    }

    protected void waitForVisibility(By element) {
        try {
            getAndroidDriverFluentWait().until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            LOGGER.error("Timeout waiting for visibility of element: {}", element, e);
        }
    }

    protected void waitForClickableAndClick(By element) {
        try {
            getAndroidDriverFluentWait().until(ExpectedConditions.elementToBeClickable(element));
            clickElement(element);
        } catch (TimeoutException e) {
            LOGGER.error("Timeout waiting for element to be clickable: {}", element, e);
        }
    }

    private FluentWait<AndroidDriver<MobileElement>> getAndroidDriverFluentWait() {
        return new FluentWait<>(androidDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return androidDriver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            LOGGER.debug("Element not found: {}", locator);
            return false;
        }
    }

    protected void clearAndType(By locator, String text) {
        MobileElement element = androidDriver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clickElement(By locator) {
        try {
            androidDriver.findElement(locator).click();
        } catch (Exception e) {
            LOGGER.error("Error clicking on element: {}", locator, e);
        }
    }

}
