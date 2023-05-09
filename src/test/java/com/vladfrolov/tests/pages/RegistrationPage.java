package com.vladfrolov.tests.pages;

import com.codeborne.selenide.SelenideElement;
import com.vladfrolov.tests.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.element;

public class RegistrationPage {

    protected static final SelenideElement firstNameInput = element("#firstName"),
            lastNameInput = element("#lastName"),
            userEmailInput = element("#userEmail"),
            maleGenderRadio = element("label[for=gender-radio-1]"),
            femaleGenderRadio = element("label[for=gender-radio-2]"),
            otherGenderRadio = element("label[for=gender-radio-3]"),
            numberInput = element("#userNumber"),
            subjectField = element("#subjectsContainer #subjectsInput"),
            sportsCheckbox = element("label[for=hobbies-checkbox-1]"),
            readingCheckbox = element("label[for=hobbies-checkbox-2]"),
            musicCheckbox = element("label[for=hobbies-checkbox-3]"),
            fileInput = element("#uploadPicture"),
            addressField = element("#currentAddress"),
            stateDropMenu = element("#state"),
            cityDropMenu = element("#city"),
            resultPopupTitle = element("#example-modal-sizes-title-lg"),
            submitButton = element("#submit");

    public CalendarComponent calendarComponent = new CalendarComponent();
}