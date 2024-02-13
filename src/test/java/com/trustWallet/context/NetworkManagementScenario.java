package com.trustWallet.context;

import com.trustWallet.page.assets.ManageCryptoPage;
import com.trustWallet.page.home.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NetworkManagementScenario {
    @Autowired
    public HomePage homePage;
    @Autowired
    public ManageCryptoPage manageCryptoPage;
}
