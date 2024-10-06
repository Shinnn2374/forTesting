import org.junit.Assert;
import org.junit.Test;

public class AppleTest extends BaseTest
{
    private static final String BASE_URL = "https://appleinsider.ru/";
    private static final String SEARCH_STRING = "Чем iPhone 13 отличается от iPhone 12";
    private static final String expectedWord = "iphone-12";

    @Test
    public void checkHref()
    {
        Assert.assertTrue(new MainPage(BASE_URL)
                .search(SEARCH_STRING).getHrefForFirstArticle()
                .contains(expectedWord));
    }
}
