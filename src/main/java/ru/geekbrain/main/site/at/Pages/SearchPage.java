package ru.geekbrain.main.site.at.Pages;

import io.qameta.allure.Step;
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
    public SearchPage inputSearchText() {
        searchPanel.sendKeys("java");
        return this;
    }

    //Проверка отображеения передаваемого блока - Step прописан в методе
    public SearchElement getSearchElement() {
        return searchElement;
    }

    //Проверка  на количество найденных элементов - Step прописан в методе
    public CountSearchElement getCountSearchElement(){
        return countSearchElement;
    }

    //Проверка, что найдены нужные элементы - Step прописан в методе
    public TextSearchTest getTextSearchTest(){
        return textSearchTest;
    }

}
