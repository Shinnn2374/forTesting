package PageObjectAppleInside.pages;/*
main page https://appleinsider.ru/
 */

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage
{
    private final SelenideElement searchButton = $x("//form");
    private final SelenideElement searchBox = $x("//input");

    public MainPage(String link)
    {
        Selenide.open(link);
    }

    /*
    Выполняется поиск среди статей
    нажимается кнопка enter
     */
    public void search(String text)
    {
        searchBox.setValue(text);
        searchBox.sendKeys(Keys.ENTER);
    }
}
