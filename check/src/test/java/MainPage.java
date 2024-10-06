import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage
{
    private final SelenideElement clickOnButon = $x("//input[@type=\"text\"]");

    public MainPage(String url)
    {
        Selenide.open(url);
    }

    public SearchPage search(String search)
    {
        clickOnButon.setValue(search);
        clickOnButon.sendKeys(Keys.ENTER);
        return new SearchPage();
    }

}
