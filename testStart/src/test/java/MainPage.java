/*
main page https://appleinsider.ru/
 */

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage
{
    public MainPage(String link)
    {
        Selenide.open(link);
    }

    private final SelenideElement searchButton = $x("//form");

    public void clickOnSearch()
    {
        searchButton.click();
    }
}
