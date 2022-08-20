package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class AddressComponent {

        public  AddressComponent  setAddress(String city, String region) {
            $("#react-select-3-input").setValue("Rajasthan").pressEnter();
            $("#react-select-4-input").setValue("Jaipur").pressEnter();

            return this;
        }
    }

