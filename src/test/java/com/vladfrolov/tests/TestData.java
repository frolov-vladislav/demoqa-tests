package com.vladfrolov.tests;

import com.github.javafaker.Faker;

public class TestData {

    private final static Faker FAKER = new Faker();
    public final static String FIRST_NAME = FAKER.name().firstName(),
            LAST_NAME = FAKER.name().lastName(),
            EMAIL = FAKER.internet().safeEmailAddress(),
            PHONE_NUMBER = FAKER.phoneNumber().subscriberNumber(10),
            GENDER = "Male",
            SUBJECT = "English",
            ADDRESS = FAKER.address().fullAddress(),
            STATE = "NCR",
            CITY = "Delhi",
            MONTH = "October",
            HOBIE = "Reading";

    public final static int DAY = 21,
            YEAR = 1998;
}