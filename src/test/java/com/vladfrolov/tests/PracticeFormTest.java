package com.vladfrolov.tests;

import com.vladfrolov.tests.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;
import static com.vladfrolov.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTest extends TestBase {

    File file = new File("src/test/resources/formTest/gosling.png");
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void test() throws Exception {
        step("Open students registration form", () -> {
            open("/automation-practice-form");
        });

        step("Fill form", () -> {
            registrationPage.typeFirstName(FIRST_NAME);
            registrationPage.typeLastName(LAST_NAME);
            registrationPage.typeEmail(EMAIL);
            registrationPage.checkMaleCheckBox();
            registrationPage.typeNumber(PHONE_NUMBER);
            registrationPage.calendarComponent.setBirthday(MONTH, YEAR, DAY);
            registrationPage.chooseSubject(SUBJECT);
            registrationPage.checkReadingCheckbox();
            registrationPage.uploadFile(file);
            registrationPage.typeAddress(ADDRESS);
            registrationPage.chooseStateAndCity(STATE, CITY);
        });

        step("Submit filled form", () -> {
            registrationPage.clickOnSubmitButton();
        });

        step("Virify successful form submit", () -> {
            registrationPage.resultPopupTitleIsVisible();
            registrationPage.checkResultsValue("Student Name", FIRST_NAME + " " + LAST_NAME);
            registrationPage.checkResultsValue("Student Email", EMAIL);
            registrationPage.checkResultsValue("Gender", GENDER);
            registrationPage.checkResultsValue("Mobile", PHONE_NUMBER);
            registrationPage.checkResultsValue("Date of Birth", DAY + " " + MONTH + "," + YEAR);
            registrationPage.checkResultsValue("Subjects", SUBJECT);
            registrationPage.checkResultsValue("Hobbies", HOBIE);
            registrationPage.checkResultsValue("Picture", file.getName());
            registrationPage.checkResultsValue("Address", ADDRESS);
            registrationPage.checkResultsValue("State and City", STATE + " " + CITY);
        });
    }
}