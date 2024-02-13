package com.trustWallet.runner;

import com.trustWallet.config.AppConfig;
import com.trustWallet.context.NetworkManagementScenario;
import com.trustWallet.context.OnboardingScenario;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/trustWallet")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.trustWallet")
@CucumberContextConfiguration
@ContextConfiguration(classes = {AppConfig.class, OnboardingScenario.class, NetworkManagementScenario.class})
public class CucumberRunnerTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AndroidDriver<MobileElement> androidDriver;

    @After
    public void afterScenario() {
        if (androidDriver != null) {
            androidDriver.quit();
        }
        ((ConfigurableApplicationContext) applicationContext).getBeanFactory().destroySingletons();
    }
}
