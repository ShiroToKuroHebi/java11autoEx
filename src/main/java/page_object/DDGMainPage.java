package page_object;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class DDGMainPage {
    public static String url = "http://duckduckgo.com";
    public SelenideElement searchField = $(byName("q"));
    public SelenideElement searchButton = $(byId("search_button_homepage"));
}
