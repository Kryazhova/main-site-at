package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.Base.Base;

import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


//    Перейти на сайт https://geekbrains.ru/courses
//            Нажать на кнопку Поиск
//            В поле Поиск ввести текст: java
//            Проверить что отобразились блоки и в них:
//            Профессий не менее чем 2
//            Курсов более 15
//            Вебинаров больше чем 180, но меньше 300
//            В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
//            Блогов более 300
//            Форумов не 350
//            Тестов не 0
//            В Проектах и компаниях отображается GeekBrains

// Изменить во втором тесте проверки на hamcrest
public class SearchTest extends Base {
    @DisplayName("Проверка поиска")
    @Test
    void events() {
        WebElement buttonSearch = driver.findElement(By.cssSelector("[class=\"show-search-form\"] [class=\"svg-icon icon-search \"]"));
        buttonSearch.click();
        WebElement inputSearch = driver.findElement(By.cssSelector("[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");


        WebElement professions = driver.findElement(By.xpath(".//header/h2[text()='Профессии']"));
        WebElement courses = driver.findElement(By.xpath(".//header/h2[text()='Курсы']"));
        WebElement events = driver.findElement(By.xpath(".//header/h2[text()='Вебинары']"));
        WebElement blogs = driver.findElement(By.xpath(".//header/h2[text()='Блоги']"));
        WebElement forum = driver.findElement(By.xpath(".//header/h2[text()='Форум']"));
        WebElement tests = driver.findElement(By.xpath(".//header/h2[text()='Тесты']"));
        WebElement projectAndCompany = driver.findElement(By.xpath(".//header/h2[text()='Проекты и компании']"));


        wait10.until(ExpectedConditions.textToBePresentInElement(professions,"Профессии"));
        wait10.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("[class='profession-item-wrapper search_row col-md-6 col-xs-12 col-lg-4']"),2));

        wait3.until(ExpectedConditions.textToBePresentInElement(courses,"Курсы"));
        WebElement counts_courses = driver.findElement(By.cssSelector("[class=\"search-page-block__more\"][data-tab=\"courses\"]>span"));
        assertThat(Integer.parseInt(counts_courses.getText()), anyOf (
                greaterThan(15)));


        wait3.until(ExpectedConditions.textToBePresentInElement(events,"Вебинары"));
        WebElement counts_events = driver.findElement(By.cssSelector("[class=\"search-page-block__more\"][data-tab=\"webinars\"]>span"));
        assertThat(Integer.parseInt(counts_events.getText()),anyOf(
                greaterThan(180),
                lessThan(300)
        ));

        WebElement first_events = driver.findElement(By.cssSelector("[class=\"event__title h3 search_text\"]"));
//        wait3.until(ExpectedConditions.textToBePresentInElement(first_events,"Java Junior. Что нужно знать для успешного собеседования?"));
        assertThat(first_events.getText(), containsString("Java Junior. Что нужно знать для успешного собеседования?"));

        wait3.until(ExpectedConditions.textToBePresentInElement(blogs,"Блоги"));
        WebElement counts_blog = driver.findElement(By.cssSelector("[class=\"search-page-block__more\"][data-tab=\"blogs\"]>span"));
        Assertions.assertTrue(Integer.parseInt(counts_blog.getText())>300);

        wait3.until(ExpectedConditions.textToBePresentInElement(forum,"Форум"));
        WebElement counts_forums = driver.findElement(By.cssSelector("[class=\"search-page-block__more\"][data-tab=\"forums\"]>span"));
        Assertions.assertNotEquals(300,Integer.parseInt(counts_forums.getText()));

        wait3.until(ExpectedConditions.textToBePresentInElement(tests,"Тесты"));
        WebElement counts_tests = driver.findElement(By.cssSelector("[class=\"search-page-block__more\"][data-tab=\"tests\"]>span"));
        Assertions.assertNotNull(counts_tests);

        wait3.until(ExpectedConditions.textToBePresentInElement(projectAndCompany,"Проекты и компании"));
        WebElement counts_project = driver.findElement(By.cssSelector("[class=\"company-items\"]"));
        wait3.until(ExpectedConditions.textMatches(By.cssSelector("[class=\"company-items\"]"), Pattern.compile("GeekBrains")));
    }
}
