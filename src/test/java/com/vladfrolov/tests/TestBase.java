package com.vladfrolov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
    public DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeEach
    void beforeEach() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1980");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "99.0");
        Configuration.pageLoadTimeout = 60000;
        SelenideLogger.addListener("Allure", new AllureSelenide());
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", credentials.login(), credentials.password());

    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}