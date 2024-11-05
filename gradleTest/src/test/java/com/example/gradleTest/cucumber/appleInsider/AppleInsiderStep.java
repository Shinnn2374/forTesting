package com.example.gradleTest.cucumber.appleInsider;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;

public class AppleInsiderStep {

    private final SelenideElement openSearch = $x("//form[@method='get']");

    @When("Открываем поиск")
    public void openSearch()
    {
        openSearch.click();
    }

    @And("Вбиваем в поиск нужную фразу")
    public void searchWord()
    {
        
    }
}
