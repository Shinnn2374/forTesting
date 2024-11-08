package com.example.gradleTest.testing;

import com.example.gradleTest.testing.Pages.Log;
import com.example.gradleTest.testing.Pages.MainToPIM;
import com.example.gradleTest.testing.Pages.PimPage;
import org.junit.jupiter.api.Test;

public class test extends Configuration
{
    Log log = new Log();
    MainToPIM pim = new MainToPIM();
    PimPage pimPage = new PimPage();

    public void authorisation()
    {
        before();
        log.toBringInUserName();
        log.toBringInUserPassword();
        log.clickToButton();
    }

    @Test
    public void pimSearchButtonTest()
    {
        authorisation();
        pim.clickToPIM();
        pimPage.test();
    }
}
