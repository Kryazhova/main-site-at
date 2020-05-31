package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.Base.Base;

import java.util.regex.Pattern;


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
    @Test
    void events() {
        WebElement buttonSearch = driver.findElement(By.cssSelector("[class=\"show-search-form\"] [class=\"svg-icon icon-search \"]"));
        buttonSearch.click();
        WebElement inputSearch = driver.findElement(By.cssSelector("[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");


        WebElement professions = driver.findElement(By.cssSelector("[id=\"professions\"] h2"));
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
        int c_courses = Integer.parseInt(counts_courses.getText());
        Assertions.assertTrue(c_courses>15);

        wait3.until(ExpectedConditions.textToBePresentInElement(events,"Вебинары"));
        WebElement counts_events = driver.findElement(By.cssSelector("[class=\"search-page-block__more\"][data-tab=\"webinars\"]>span"));
        Assertions.assertTrue(Integer.parseInt(counts_events.getText())>180);
        Assertions.assertTrue(Integer.parseInt(counts_events.getText())<300);

        WebElement first_events = driver.findElement(By.cssSelector("[class=\"event__title h3 search_text\"]"));
        wait3.until(ExpectedConditions.textToBePresentInElement(first_events,"Java Junior. Что нужно знать для успешного собеседования?"));

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
