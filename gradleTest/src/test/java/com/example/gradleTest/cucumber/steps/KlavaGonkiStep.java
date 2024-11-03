package com.example.gradleTest.cucumber.steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class KlavaGonkiStep {

    private final SelenideElement closeButton = $x("//input[@value='Закрыть']");
    private final SelenideElement startButton = $x("//a[@id='host_start']");


    static
    {
        
    }

    @When("Начинаем игру")
    public void startGame()
    {
        closeButton.click();
        if (startButton.isDisplayed())
        {
            startButton.click();
        }
    }
}
