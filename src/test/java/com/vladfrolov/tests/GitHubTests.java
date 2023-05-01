package com.vladfrolov.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class GitHubTests {

    String wikiUrl = "https://github.com/selenide/selenide";
    String softAssertionsUrl = "https://github.com/selenide/selenide/wiki/SoftAssertions";
    String JUnit5codeExample = "com.codeborne.selenide.junit5.SoftAssertsExtension";

    @Test
    public void PageHaveSoftAssertionsLink() {
        open(wikiUrl);
        element("#wiki-tab").click();
        element(byText("Soft assertions")).shouldBe(visible);
    }

    @Test
    public void pageHaveJUnit5CodeExample() {
        open(softAssertionsUrl);
        $$("code").filter(exactText(JUnit5codeExample)).first().shouldBe(visible);
    }
}
