import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта appleinsider.ru
 */

public class MainPage
{
    private final SelenideElement textInTextBoxInput = $x("//input[@type=\"text\"]");

    public  MainPage(String url)
    {
        Selenide.open(url);
    }

    /**
     * Выполняется поиск среди статей и нажимается ентер
     * @param search
     */
    public SearchPage search(String search)
    {
        textInTextBoxInput.setValue(search);
        textInTextBoxInput.sendKeys(Keys.ENTER);
        return new SearchPage();
    }

}
