package com.example.gradleTest.testing.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class PimPage
{
    private final SelenideElement buttonSearch = $x("//button[@type='submit']");

    public void test()
    {
        buttonSearch.shouldBe(Condition.visible);
    }
}
