package com.example.gradleTest.testing.Pages;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

public class MainToPIM
{
    private final SelenideElement PIM = $x("//a[./span[text()='PIM']]");

    public void clickToPIM()
    {
        PIM.click();
    }
}
