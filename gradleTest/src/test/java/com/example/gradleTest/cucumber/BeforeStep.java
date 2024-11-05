package com.example.gradleTest.cucumber;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("Открываем сайт {string}")
    public void openWebSite(String string)
    {
        Selenide.open(string);
    }
}
