import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import page_object.DDGMainPage;
import page_object.DDGSearchResultsPage;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UiSearchTest {

    @Test
    public void SearchForString() {
        Selenide.open(DDGMainPage.url);

        DDGMainPage mainPage = new DDGMainPage();
        mainPage.searchField.setValue("java selenide");
        mainPage.searchButton.click();

        DDGSearchResultsPage searchResultsPage = new DDGSearchResultsPage();
        //check using JUnit
        assertFalse(searchResultsPage.results.isEmpty());
        //check using Selenide
        searchResultsPage.checkResultByIndexContainsText(0, "Selenide: concise UI tests in Java");
    }
}
