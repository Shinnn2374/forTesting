/*
main page https://appleinsider.ru/
 */

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage
{
    private final SelenideElement searchButton = $x("//form");
    private final SelenideElement searchBox = $x("//input");

    public MainPage(String link)
    {
        Selenide.open(link);
    }

    public void search(String text)
    {
        searchButton.setValue(searchBox.);
    }
}
