package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class DDGSearchResultsPage {
    public final List<SelenideElement> results = $$(byXpath("//div[contains(@class, 'nrn-react')]"));

    public void checkResultByIndexContainsText(int index, String expText) {
        results.get(index).shouldHave(Condition.text(expText));
    }
}
