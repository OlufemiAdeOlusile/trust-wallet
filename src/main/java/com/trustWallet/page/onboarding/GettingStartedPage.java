package com.trustWallet.page.onboarding;


import com.trustWallet.page.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class GettingStartedPage extends BasePage<GettingStartedPage> {
    private static final By GETTING_STARTED_BUTTON = By.xpath("//android.widget.TextView[@text='Get Started']");

    public void clickGettingStarted() {
        clickElement(GETTING_STARTED_BUTTON);
    }

    @Override
    public GettingStartedPage waitForPage() {
        waitForVisibility(GETTING_STARTED_BUTTON);
        return this;
    }
}
