package com.example.gradleTest.cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("Открываем сайт {string}")
    public void openWebSite(String url)
    {
        Configuration.timeout = 60_000;
        Selenide.open(url);
    }
}
