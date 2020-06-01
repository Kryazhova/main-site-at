package ru.geekbrain.main.site.at.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.ElementsTestSearch.CountSearchElement;
import ru.geekbrain.main.site.at.ElementsTestSearch.SearchElement;
import ru.geekbrain.main.site.at.ElementsTestSearch.TextSearchTest;

public class SearchPage {
    private WebDriver driver;
    private SearchElement searchElement;
    private CountSearchElement countSearchElement;
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
        searchElement = new SearchElement(driver);
        countSearchElement = new CountSearchElement(driver);
        textSearchTest = new TextSearchTest(driver);
        PageFactory.initElements(driver,this);
    }

    //закрытие поп-апа
    public SearchPage closePopup() {
        popupClose.click();
        return this;
    }

    //открытие строки поиска
    public SearchPage clickIconSearch(){
        searchIcon.click();
        return this;
    }

    //ввод текста
    public SearchPage inputSearchText() {
        searchPanel.sendKeys("java");
        return this;
    }

    //проверка, что отобразились все необходимые блоки
    public SearchElement getSearchElement() {
        return searchElement;
    }

    //проверка, что количество найденных элементов верное
    public CountSearchElement getCountSearchElement(){
        return countSearchElement;
    }

    //проверка, что найдены нужные элементы
    public TextSearchTest getTextSearchTest(){
        return textSearchTest;
    }

}
