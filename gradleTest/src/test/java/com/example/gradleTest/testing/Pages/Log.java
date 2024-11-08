package com.example.gradleTest.testing.Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class Log
{
    private final String userName = "Admin";
    private final String password = "admin123";

    private final SelenideElement userNamePull = $x("//input[@name='username']");
    private final SelenideElement passwordPull = $x("//input[@name='password']");
    private final SelenideElement buttonPull = $x("//button");

    public void toBringInUserName()
    {
        userNamePull.setValue(userName);
    }

    public void toBringInUserPassword()
    {
        passwordPull.setValue(password);
    }
    public void clickToButton()
    {
        buttonPull.click();
    }
}
