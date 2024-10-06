import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

/**
 * Возвращается href из первой статьи
 */

public class SearchPage
{
    private final ElementsCollection articles = $$x("//h2//a");

    public String getHrefForFirstArticle()
    {
        return articles.first().getAttribute("href");
    }
}
