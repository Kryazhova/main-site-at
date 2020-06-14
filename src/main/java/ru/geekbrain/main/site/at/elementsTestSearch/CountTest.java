package ru.geekbrain.main.site.at.elementsTestSearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
//    @Step("Проверка, что найдено правильное количество элементов для блока {blocks}")
//    public CountTest checkCount(Blocks blocks, Matcher<Integer> matcher) {
//        String сount = getButton(blocks).getText();
//        assertThat(Integer.parseInt(сount), matcher);
//        return this;
//    }

    // Enum —  специальный класс для создания списка значений.
    public enum Blocks {
        Professions("Профессии"),
        Courses("Курсы"),
        Events("Вебинары"),
        Blogs("Блоги"),
        Forum("Форум"),
        Tests("Тесты"),
        Companies("Проекты и компании");

        private String text;

        Blocks(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}

