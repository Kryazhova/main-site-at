package ru.geekbrain.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.elementsTestSearch.CountTest;
import ru.geekbrain.main.site.at.elementsTestSearch.SearchElement;
import ru.geekbrain.main.site.at.elementsTestSearch.TextSearchTest;

public class SearchPage {
    private WebDriver driver;
    private CountTest countTest;
    private SearchElement searchElement;
    public TextSearchTest textSearchTest;

    //элемент поп-апа
    @FindBy(css ="button>[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement popupClose;

    @FindBy(css = "[class=\"show-search-form\"] [class=\"svg-icon icon-search \"]")
    private WebElement searchIcon;

    @FindBy(css = "[class=\"search-panel__search-field\"]")
    private WebElement searchPanel;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        countTest = new CountTest(driver);
        searchElement = new SearchElement(driver);
        textSearchTest = new TextSearchTest(driver);
        PageFactory.initElements(driver,this);
    }

   @Step("Закрытие поп-апа на стартовой странице")
    public SearchPage closePopup() {
        popupClose.click();
        return this;
    }

    @Step("Нажатие на иконку поиска")
    public SearchPage clickIconSearch(){
        searchIcon.click();
        return this;
    }

    @Step("Ввод текста 'Java' для проверки поиска")
    public SearchPage inputSearchText(String search) {
        searchPanel.sendKeys(search);
        return this;
    }

    public CountTest getCountTest() {
        return countTest;
    }

    public TextSearchTest getTextSearchTest(){
        return textSearchTest;
    }

    public SearchElement getSearchElement() {
        return searchElement;
    }

}

