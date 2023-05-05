package com.vladfrolov.tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;
import static com.vladfrolov.tests.TestData.*;

public class FormTest extends TestBase {

    File file = new File("src/test/resources/formTest/gosling.png");
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void test() throws Exception {
        open("/automation-practice-form");
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
        registrationPage.clickOnSubmitButton();

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
    }
}