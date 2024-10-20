package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;


public class SearchPage
{
    private static final ElementsCollection elementst = $$x("//h2//a");

    public String getFirstHref()
    {
        return elementst.first().getAttribute("href");
    }

}
