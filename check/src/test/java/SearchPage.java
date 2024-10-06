import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage
{
    private final ElementsCollection articles = $$x("//h2//a");

    public String getHrefForFirstArticle()
    {
        return articles.first().getAttribute("href");
    }
}
