package com.example.gradleTest.cucumber.steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class KlavaGonkiStep {

    private final SelenideElement goToStartGame = $x("//a[@class=\"title\"]");
    private final SelenideElement closeButton = $x("//input[@value='Закрыть']");
    private final SelenideElement startButton = $x("//a[@id='host_start']");
    private final SelenideElement highLight = $x("//span[@id='typefocus']");
    private final SelenideElement inputField = $x("//input[@id='inputtext']");
    private final SelenideElement afterFocus = $x("//span[@id='afterfocus']");

    private String getCurrentWord()
    {
       return highLight.getText().replaceAll("с","c").replaceAll("о","o");

    }

    @When("Переходим на быструю игру")
    public void переходимНаБыструюИгру()
    {
        goToStartGame.click();
    }

    @And("Начинаем игру")
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
            String currentWord = getCurrentWord();
            String afterFocusSimbol = afterFocus.getText();
            inputField.sendKeys(currentWord);
            if (afterFocusSimbol.equals("."))
            {
                inputField.sendKeys(".");
                break;
            }
            inputField.sendKeys(Keys.SPACE);
        }
    }
}
