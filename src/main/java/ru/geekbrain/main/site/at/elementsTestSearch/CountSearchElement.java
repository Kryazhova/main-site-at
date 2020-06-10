package ru.geekbrain.main.site.at.elementsTestSearch;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.pages.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountSearchElement {
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

    public CountSearchElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Проверка на количество найденных элементов для блока {name}")
    public SearchPage countSearchElement(String name){
        switch (name){
            case "Профессии": {
                assertThat(Integer.parseInt(professions.getText()), greaterThanOrEqualTo(2));
            }
            case "Курсы": {
                assertThat(Integer.parseInt(courses.getText()), greaterThan(15));
                break;
            }
            case "Вебинары": {
                assertThat(Integer.parseInt(events.getText()),allOf(
                        greaterThan(180),
                        lessThan(300)
                ));
                break;
            }
            case "Блоги": {
                assertThat(Integer.parseInt(blogs.getText()),greaterThan(300));
                break;
            }
            case "Форум": {
                assertThat(Integer.parseInt(forum.getText()),not(350));
                break;
            }
            case "Тесты": {
                assertThat(Integer.parseInt(tests.getText()),not(0));
                break;
            }
            case "Проекты и компании": {
                System.out.println("Нет проверки на количество элементов для блока: " + name);
                break;
            }
            default: {
                throw new RuntimeException("Нет блока: " + name);
            }
        }
        return new SearchPage(driver);
    }

}
