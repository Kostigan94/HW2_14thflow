package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTestPageObjects {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Kos")
                .setLastName("Kosov")
                .setEmail("Kosov@mail.ru")
                .setGender("Male")
                .setNumber("7777934256")
                .setBirthdate("18", "May", "1992")
                .uploadPicture("fOwl.PNG")
                .setSubject("Math")
                .setHobby("Sports")
                .setAddress("Prospect Mira 123")
                .setCityState("Rajasthan", "Jaipur")
                .submit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Kos Kosov")
                .checkResult("Student Email", "Kosov@mail.ru")
                .checkResult("Date of Birth", "18 May,1992")
                .checkResult("Mobile", "7777934256")
                .checkResult("Address", "Prospect Mira 123")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "fOwl.PNG")
                .checkResult("State and City", "Rajasthan Jaipur");

    }
}

