package com.demoqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;

import static java.lang.String.format;

public class TestData {

     Faker faker = new Faker();

String firstName,lastName,userEmail,userNumber,
        day,month,year,subject,hobbies,uploadPicture,
        currentAddress,state,
        city,fullName,
        dateOfBirth,stateAndCity,
            gender;
    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
                lastName = faker.name().lastName();
                userEmail = faker.internet().emailAddress();
                gender = "Male";
                userNumber = faker.phoneNumber().subscriberNumber(10);
                day = faker.number().numberBetween(1,27) + "";
                month = "July";
                year = faker.number().numberBetween(1990, 2000) + "";
                subject = "Math";
                hobbies = "Sports";
                uploadPicture = "fOwl.PNG";
                currentAddress = faker.address().fullAddress();
                state = "Rajasthan";
                city = "Jaipur";
                fullName = format("%s %s", firstName, lastName);dateOfBirth = format("%s %s,%s", day, month, year);
                stateAndCity = format("%s %s", state, city);

    }
}
