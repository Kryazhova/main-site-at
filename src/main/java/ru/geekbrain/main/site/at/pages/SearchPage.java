package ru.geekbrain.main.site.at.pages;

import org.openqa.selenium.WebDriver;
import ru.geekbrain.main.site.at.commonBlocks.ContentBasePage;
import ru.geekbrain.main.site.at.elementsTestSearch.SearchElement;
import ru.geekbrain.main.site.at.elementsTestSearch.SearchTextElement;

public class SearchPage  extends ContentBasePage {
    private SearchElement searchElement;
    private SearchTextElement searchTextElement;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.searchElement = new SearchElement(driver);
        this.searchTextElement = new SearchTextElement(driver);
    }

    @Override
    public SearchPage openUrl() {
        driver.get("https://geekbrains.ru/search");
        return this;
    }

    public SearchElement getSearchElement() {
        return searchElement;
    }

    public SearchTextElement getSearchTextElement(){
        return searchTextElement;
    }

}

