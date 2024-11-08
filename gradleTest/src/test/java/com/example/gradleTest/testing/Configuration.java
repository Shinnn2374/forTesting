package com.example.gradleTest.testing;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;

public class Configuration
{
    public void before()
    {
        Selenide.open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void after()
    {
        WebDriverRunner.getWebDriver().quit();
    }
}
