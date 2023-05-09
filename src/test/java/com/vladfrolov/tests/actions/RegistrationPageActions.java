package com.vladfrolov.tests.actions;

import com.vladfrolov.tests.pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.element;

public class RegistrationPageActions extends RegistrationPage {

    public void typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void typeEmail(String email) {
        userEmailInput.setValue(email);
    }

    public void checkMaleCheckBox() {
        maleGenderRadio.click();
    }

    public void checkFemaleCheckbox() {
        femaleGenderRadio.click();
    }

    public void checkOtherCheckbox() {
        otherGenderRadio.click();
    }

    public void chooseSubject(String subject) {
        subjectField.setValue(subject);
        element("#react-select-2-option-0").click();
    }

    public void typeNumber(String number) {
        numberInput.setValue(number);
    }

    public void checkSportsCheckbox() {
        sportsCheckbox.click();
    }

    public void checkReadingCheckbox() {
        readingCheckbox.click();
    }

    public void checkMusicCheckbox() {
        musicCheckbox.click();
    }

    public void uploadFile(File file) {
        fileInput.uploadFile(file);
    }

    public void typeAddress(String address) {
        addressField.setValue(address);
    }

    public void chooseStateAndCity(String state, String city) {
        stateDropMenu.click();
        element(byText(state)).click();
        cityDropMenu.click();
        element(byText(city)).click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }
}
