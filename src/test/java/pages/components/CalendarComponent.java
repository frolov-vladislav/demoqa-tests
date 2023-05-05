package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class CalendarComponent {
    SelenideElement birthdayInput = element("#dateOfBirthInput"),
            monthSelect = element(".react-datepicker__month-select"),
            yearSelect = element(".react-datepicker__year-select");
    String daySelector = ".react-datepicker__day--0";

    public void setBirthday(String month, int year, int day) throws Exception {
        birthdayInput.click();
        monthSelect.selectOption(month);

        if (year >= 1900 && year <= 2100) {
            yearSelect.selectOption((String.valueOf(year)));
        } else {
            throw new Exception("Year value out of bounds");
        }

        if (day > 0 && day < 32) {
            element(String.format(daySelector + "%s", day)).click();
        } else {
            throw new Exception("Day value don`t exist");
        }
    }
}