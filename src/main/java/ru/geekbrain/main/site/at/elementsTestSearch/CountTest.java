package ru.geekbrain.main.site.at.elementsTestSearch;

import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;

public class CountTest {
    private WebDriver driver;

    @FindBy (css =  "[class=\"search-page-block__more\"][data-tab=\"professions\"]>span")
    private WebElement professions;

    @FindBy(css = "[class=\"search-page-block__more\"][data-tab=\"courses\"]>span")
    private WebElement courses;

    @FindBy(css="[class=\"search-page-block__more\"][data-tab=\"webinars\"]>span")
    private WebElement events;

    @FindBy(css = "[class=\"search-page-block__more\"][data-tab=\"blogs\"]>span")
    private WebElement blogs;

    @FindBy(css = "[class=\"search-page-block__more\"][data-tab=\"forums\"]>span")
    private WebElement forum;

    @FindBy(css = "[class=\"search-page-block__more\"][data-tab=\"tests\"]>span")
    private WebElement tests;

    @FindBy(css = "[class=\"search-page-block__more\"][data-tab=\"companies\"]>span")
    private WebElement project;

    public CountTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //        Проверка на количество элементов
    @Step("Проверка, что найдено правильное количество элементов для блока {blocks}")
    public CountTest checkCount(String blocks, Matcher<Integer> matcher) {
        String сount = getButton(blocks).getText();
        assertThat(Integer.parseInt(сount), matcher);
        return this;
    }


    private WebElement getButton(String blocks) {
        switch (blocks) {
            case "Профессии":
                return professions;
            case "Курсы":
                return courses;
            case "Вебинары":
                return events;
            case "Блоги":
                return blogs;
            case "Форум":
                return forum;
            case "Тесты":
                return tests;
            case "Проекты и компании":
                return project ;
            default:
                throw new IllegalStateException("Unexpected value: " + blocks);
        }
    }
}
