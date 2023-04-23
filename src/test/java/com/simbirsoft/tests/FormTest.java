package com.simbirsoft.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "3100x1080";
        Configuration.pageLoadTimeout = 60000;
    }

    @Test
    void test() {
        String url = "https://demoqa.com/automation-practice-form";
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String mobile = "2222222222";
        String email = "test@mail.com";
        String address = "some street 1";
        File file = new File("src/test/java/com/simbirsoft/attachments/gosling.png");

        open(url);
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("label[for=gender-radio-1]").click();

        $("input#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--021").click();
        $("#subjectsContainer #subjectsInput").setValue("E");
        $("#react-select-2-option-0").click();
        $("label[for=hobbies-checkbox-1]").click();
         $("input[type=file]").uploadFile(file);
        $("#currentAddress").setValue(address);
        $("#state").scrollTo().click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        SelenideElement table = $(By.tagName("table"));
        table.shouldHave(Condition.text(firstName));
        table.shouldHave(Condition.text(lastName));
        table.shouldHave(Condition.text(email));
        table.shouldHave(Condition.text("Male"));
        table.shouldHave(Condition.text(mobile));
        table.shouldHave(Condition.text("21 October,1998"));
        table.shouldHave(Condition.text("English"));
        table.shouldHave(Condition.text("Sports"));
        table.shouldHave(Condition.text(file.getName()));
        table.shouldHave(Condition.text(address));
        table.shouldHave(Condition.text("NCR Delhi"));





    }
}