package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FormValidationTestFaker extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    TestData testdata = new TestData();

    @BeforeEach
    void setup() {
        testdata.prepareTestData();
    }

    @Test
    void firstTest() {
        registrationFormPage.openPage()
                .setFirstName(testdata.firstName)
                .setLastName(testdata.lastName)
                .setEmail(testdata.userEmail)
                .setGender(testdata.gender)
                .setNumber(testdata.userNumber)
                .setBirthDate(testdata.day,testdata. month, testdata.year)
                .setSubject(testdata.subject)
                .setHobbies(testdata.hobbies)
                .uploadPicture(testdata.picture)
                .setAddress(testdata.currentAddress)
                .setCityState(testdata.state, testdata.city)
                .submit();


        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name",testdata.fullName)
                .checkResult("Student Email",testdata.userEmail)
                .checkResult("Gender",testdata.gender)
                .checkResult("Mobile",testdata.userNumber)
                .checkResult("Date of Birth",testdata.dateOfBirth)
                .checkResult("Subjects",testdata.subject)
                .checkResult("Hobbies",testdata.hobbies)
                .checkResult("Picture", testdata.getPicture)
                .checkResult("Address", testdata.currentAddress)
                .checkResult("State and City",testdata.stateAndCity);


    }
}