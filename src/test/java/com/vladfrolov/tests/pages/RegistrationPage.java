package com.vladfrolov.tests.pages;

import com.codeborne.selenide.SelenideElement;
import com.vladfrolov.tests.pages.components.CalendarComponent;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
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

    public void chooseStateAndCity(String state) {
        stateDropMenu.scrollTo().click();
        element(byText(state)).click();
        cityDropMenu.scrollTo().click();
        element("#stateCity-wrapper").$("#react-select-4-option-0").click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void checkResultsValue(String key, String value) {
        element(By.xpath("//td[text()='" + key + "']")).parent()
                .shouldHave(text(value));
    }

    public void resultPopupTitleIsVisible() {
        resultPopupTitle.shouldBe(visible);
    }
}