package ru.geekbrain.main.site.at.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrain.main.site.at.ElementsTestNavigation.FooterElements;
import ru.geekbrain.main.site.at.ElementsTestNavigation.HeaderElements;
import ru.geekbrain.main.site.at.ElementsTestNavigation.NavigationElements;

public class Pages {

    // логика проверки:
    // - открываем стартовую страницу
    // - закрываем поп-ап
    // - проверяем навигацию
    // - проверяем хедер
    // - проверяем футер

    private WebDriver driver;
    private NavigationElements navigation;
    private HeaderElements headerElements;
    private FooterElements footerElements;

    //элемент для проверки страницы
    @FindBy(css = "h2[class=\"gb-header__title\"]")
    private WebElement namePage;

    //элемент поп-апа
    @FindBy(css ="button>[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement popupClose;

    public Pages(WebDriver driver) {
        this.driver = driver;
        navigation = new NavigationElements(driver);
        headerElements = new HeaderElements(driver);
        footerElements = new FooterElements(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("Закрытие поп-апа на стартовой странице \"Курсы\"")
    public Pages closePopup() {
        popupClose.click();
//        Решили методом деления страниц. Так как мы точно знаем, где будут поп-апы
//
//        try {
//            popupClose.click();
//        }
//        catch (WebDriverException e) {
//            System.out.println("Не был найден необязательный элемент: " + e);
//        }
//        finally {
//
//        }
        return this;
   }

    @Step ("Проверка навигации")
    public NavigationElements getNavigation() {
        return navigation;
    }

    @Step("Проверка загрузки страницы {expectedNamePage}")
    public Pages checkNamePage(String expectedNamePage) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(namePage, expectedNamePage));
        return this;
    }

    @Step("Проверка хедера")
    public HeaderElements getHeaderElements() {
       return headerElements;
    }

    @Step("Проверка футера")
    public FooterElements getFooterElements() {
       return footerElements;
    }

}
