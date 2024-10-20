package test;

import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.SearchPage;

public class appleTest extends BaseTest
{
    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH_LINE = "Чем iphone 13 отличается от iphone 12?";

    @Test
    public void checkHrefArticul()
    {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.search(SEARCH_LINE);
        SearchPage searchPage = new SearchPage();
        Boolean res = searchPage.getFirstHref().contains("iphone");
        Assert.assertTrue(res);
    }
}
