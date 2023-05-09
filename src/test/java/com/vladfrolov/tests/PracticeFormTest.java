package com.vladfrolov.tests;

import com.vladfrolov.tests.actions.RegistrationPageActions;
import com.vladfrolov.tests.asserts.RegistrationPageAsserts;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;
import static com.vladfrolov.tests.TestData.*;

public class PracticeFormTest extends TestBase {

    File file = new File("src/test/resources/formTest/gosling.png");
    RegistrationPageActions action = new RegistrationPageActions();
    RegistrationPageAsserts assertion = new RegistrationPageAsserts();

    @Test
    public void test() throws Exception {
        open("/automation-practice-form");
        action.typeFirstName(FIRST_NAME);
        action.typeLastName(LAST_NAME);
        action.typeEmail(EMAIL);
        action.checkMaleCheckBox();
        action.typeNumber(PHONE_NUMBER);
        action.calendarComponent.setBirthday(MONTH, YEAR, DAY);
        action.chooseSubject(SUBJECT);
        action.checkReadingCheckbox();
        action.uploadFile(file);
        action.typeAddress(ADDRESS);
        action.chooseStateAndCity(STATE, CITY);
        action.clickOnSubmitButton();

        assertion.resultPopupTitleIsVisible();
        assertion.checkResultsValue("Student Name", FIRST_NAME + " " + LAST_NAME);
        assertion.checkResultsValue("Student Email", EMAIL);
        assertion.checkResultsValue("Gender", GENDER);
        assertion.checkResultsValue("Mobile", PHONE_NUMBER);
        assertion.checkResultsValue("Date of Birth", DAY + " " + MONTH + "," + YEAR);
        assertion.checkResultsValue("Subjects", SUBJECT);
        assertion.checkResultsValue("Hobbies", HOBIE);
        assertion.checkResultsValue("Picture", file.getName());
        assertion.checkResultsValue("Address", ADDRESS);
        assertion.checkResultsValue("State and City", STATE + " " + CITY);
    }
}