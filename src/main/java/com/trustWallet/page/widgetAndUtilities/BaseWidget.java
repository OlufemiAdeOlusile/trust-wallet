package com.trustWallet.page.widgetAndUtilities;

import com.trustWallet.page.BasePage;
import org.springframework.stereotype.Component;

@Component
public class BaseWidget extends BasePage<BaseWidget> {
    @Override
    public BasePage<BaseWidget> waitForPage() {
        return this;
    }
}
