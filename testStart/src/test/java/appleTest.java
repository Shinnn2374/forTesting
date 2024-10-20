import org.junit.Test;

public class appleTest extends BaseTest
{
    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String BASE_LINE = "Чем iphone 13 отличается от iphone 12?";

    @Test
    public void checkHrefArticul()
    {
        MainPage mainPage = new MainPage(BASE_URL);
    }
}
