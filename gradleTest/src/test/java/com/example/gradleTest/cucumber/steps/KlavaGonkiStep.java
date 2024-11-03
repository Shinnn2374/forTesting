package com.example.gradleTest.cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class KlavaGonkiStep {

    private final SelenideElement closeButton = $x("//input[@value='Закрыть']");
    private final SelenideElement startButton = $x("//a[@id='host_start']");
    private final SelenideElement highLight = $x("//span[@id='typefocus']");
    private final SelenideElement inputField = $x("//input[@id='inputtext']");
    private final SelenideElement afterFocus = $x("//span[@id='afterfocus']");


    @When("Начинаем игру")
    public void startGame()
    {
        closeButton.click();
        if (startButton.isDisplayed())
        {
            startButton.click();
        }
    }

    @And("Ждем начала игры")
    public void waitForStartGame()
    {
        highLight.click();
    }

    @And("Вводим подсвеченное слово в цикле")
    public void insertFocusWord()
    {
        while(true)
        {
            String currentWord = highLight.getText();
            String
        }
    }
}
