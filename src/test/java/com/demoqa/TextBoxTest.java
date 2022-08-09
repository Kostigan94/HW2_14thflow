package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.beans.PropertyEditor;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTest {

        @BeforeAll
        static void  configure() {
            Configuration.baseUrl="https://demoqa.com";
            Configuration.browserSize = "1920x1080";
            Configuration.browser = "chrome";
        }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
      $("#firstName").setValue("Kos");
      $("#lastName").setValue("Kosov");
      $("#userEmail").setValue("Kosov@mail.ru");
      $("#genterWrapper").$(byText("Male")).click();
      //$("[for='gender-radio-1']").click();
      $("#userNumber").setValue("7777934256");
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select").selectOption(5);
      $(".react-datepicker__year-select").selectOption("1992");
      $(".react-datepicker__day--018").click();
      $("#subjectsInput").setValue("Maths").pressEnter();
      $("#hobbiesWrapper").$(byText("Sports")).click();
      //$("[for='hobbies-checkbox-1']").click();
      $("#uploadPicture").uploadFromClasspath("fOwl.PNG");
      //$("#uploadPicture").uploadFile(new File("src/test/resources/fOwl.PNG"));
      $("#currentAddress").setValue("Prospect Mira 123");
      $("#react-select-3-input").setValue("Rajasthan").pressEnter();
      $("#react-select-4-input").setValue("Jaipur").pressEnter();
      $("#submit").pressEnter();

      //Assertions
        $(".modal-body").$(byText("Student Name")).sibling(0).shouldHave(text("Kos Kosov"));
        $(".modal-body").$(byText("Student Email")).sibling(0).shouldHave(text("Kosov@mail.ru"));
        $(".modal-body").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".modal-body").$(byText("Date of Birth")).sibling(0).shouldHave(text("18 JUne,1992"));
        $(".modal-body").$(byText("Mobile")).sibling(0).shouldHave(text("7777934256"));
        $(".modal-body").$(byText("Address")).sibling(0).shouldHave(text("Prospect Mira 123"));
        $(".modal-body").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
        $(".modal-body").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".modal-body").$(byText("Picture")).sibling(0).shouldHave(text("fOwl.PNG"));
        $(".modal-body").$(byText("State and City")).sibling(0).shouldHave(text("Rajasthan Jaipur"));
        }
    }

