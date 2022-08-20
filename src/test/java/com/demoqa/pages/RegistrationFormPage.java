package com.demoqa.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.AddressComponent;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultModal;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private AddressComponent addressComponent = new AddressComponent();
    private ResultModal resultModal = new ResultModal();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    @BeforeAll
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthdate(String day, String month, String year) {
        $("#dateOfBirthInput").scrollIntoView(true).click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setCityState(String state, String city) {
        addressComponent.setAddress(state, city);

        return this;
    }

    public RegistrationFormPage submit() {
        $("#submit").pressEnter();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultModal.isVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultModal.checkResult(key, value);

        return this;
    }



}




