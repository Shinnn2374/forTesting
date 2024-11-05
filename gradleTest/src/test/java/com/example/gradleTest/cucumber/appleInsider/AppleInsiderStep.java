package com.example.gradleTest.cucumber.appleInsider;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AppleInsiderStep {

    private final String searchWord = "Чем iphone 13 отличается от iphone 12?";
    private final SelenideElement openSearch = $x("//form[@method='get']");
    private final SelenideElement search = $x("//input[@type='text']");
    private final ElementsCollection articleTitles = $$x("//h2//a");

    @When("Открываем поиск")
    public void openSearch()
    {
        openSearch.click();
    }

    @And("Вбиваем в поиск нужную фразу и переходим на страницу с результатами поиска")
    public void searchWord()
    {
        search.setValue(searchWord);
        search.sendKeys(Keys.ENTER);
    }

    @And("Обрабатываем полученные данные и проводим сравнения")
    public void dataAn()
    {
        String href = articleTitles.first().getAttribute("href");
        Assert.assertTrue("iphone".contains(href));
    }
}
