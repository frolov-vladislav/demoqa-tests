package com.vladfrolov.tests.asserts;

import com.vladfrolov.tests.pages.RegistrationPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;

public class RegistrationPageAsserts extends RegistrationPage {
    public void checkResultsValue(String key, String value) {
        element(By.xpath("//td[text()='" + key + "']")).parent()
                .shouldHave(text(value));
    }

    public void resultPopupTitleIsVisible() {
        resultPopupTitle.shouldBe(visible);
    }
}
