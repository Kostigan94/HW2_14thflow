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
      $("[for='gender-radio-1']").click();
      $("#userNumber").setValue("7777934256");
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select").selectOption(5);
      $(".react-datepicker__year-select").selectOption("1992");
      $(".react-datepicker__day--018").click();
      $("#subjectsInput").setValue("Maths").pressEnter();
      $("[for='hobbies-checkbox-1']").click();
      $("#uploadPicture").uploadFile(new File("src/test/resources/fOwl.PNG"));
      $("#currentAddress").setValue("Prospect Mira 123");
      $("#react-select-3-input").setValue("Rajasthan").pressEnter();
      $("#react-select-4-input").setValue("Jaipur").pressEnter();
      $("#submit").pressEnter();

      //Assertions
        $(".modal-body").shouldHave(
                text("Kos Kosov"),
                text("Kosov@mail.ru"),
                text("Male"),
                text("7777934256"),
                text("18 JUne,1992"),
                text("Maths"),
                text("Sports"),
                text("fOwl.PNG"),
                text("Prospect Mira 123"),
                text("Rajasthan Jaipur"));
                }
    }

