package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.Base.Base;

public class NavigationTest extends Base {

//    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Курсы
//    Вебинары
//    Форум
//    Блог
//    Тесты
//    Карьера



    void test_pages() {
        WebElement hh =  driver.findElement(By.cssSelector("[id='top-menu']"));
        wait3.until(ExpectedConditions.visibilityOf(hh));

        WebElement title = driver.findElement(By.cssSelector("h2[class='gb-header__title']"));
        wait3.until(ExpectedConditions.visibilityOf(title));

        WebElement icon_search = driver.findElement(By.cssSelector("[class='gb-top-menu__item']>[class='show-search-form']"));
        wait3.until(ExpectedConditions.visibilityOf(icon_search));

        WebElement icon_exit = driver.findElement(By.cssSelector("[class='gb-top-menu__item']>[href='/login']"));
        wait3.until(ExpectedConditions.visibilityOf(icon_exit));

        WebElement icon_registry = driver.findElement(By.cssSelector("[href='/register']"));
        wait3.until(ExpectedConditions.visibilityOf(icon_registry));


        WebElement footer = driver.findElement(By.cssSelector("[class='site-footer']"));
        wait3.until(ExpectedConditions.visibilityOf(footer));

        WebElement icons = driver.findElement(By.cssSelector("[class='site-footer__icons']"));
        wait3.until(ExpectedConditions.visibilityOf(icons));


        WebElement links = driver.findElement(By.cssSelector("[class='site-footer__links']"));
        wait3.until(ExpectedConditions.visibilityOf(links));

        WebElement icons_android = driver.findElement(By.cssSelector("[class='site-footer__icons site-footer__icons_android']"));
        wait3.until(ExpectedConditions.visibilityOf(icons_android));

    }
    @Test
    void courses(){
//        driver.findElement(By.cssSelector("button>[class=\"svg-icon icon-popup-close-button \"]")).click();
        WebElement buttonCourses = driver.findElement(By.cssSelector("[id='nav'] [href='/courses']"));
        buttonCourses.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Курсы", textNamePage.getText());
        test_pages();
    }

    @Test
    void events(){
        WebElement buttonEvents = driver.findElement(By.cssSelector("[id='nav'] [href='/events']"));
        buttonEvents.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Вебинары", textNamePage.getText());
        test_pages();
    }
    @Test
    void topics() {
        WebElement buttonTopics = driver.findElement(By.cssSelector("[id='nav'] [href='/topics']"));
        buttonTopics.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Форум", textNamePage.getText());
        test_pages();
    }
    @Test
    void posts() {
        WebElement buttonPosts = driver.findElement(By.cssSelector("[id='nav'] [href='/posts']"));
        buttonPosts.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Блог",textNamePage.getText());
        test_pages();
    }
    @Test
    void tests() {
        WebElement buttonTests = driver.findElement(By.cssSelector("[id='nav'] [href='/tests']"));
        buttonTests.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Тесты",textNamePage.getText());
        test_pages();
    }
    @Test
    void career() {
        WebElement buttonCareer = driver.findElement(By.cssSelector("[id='nav'] [href='/career']"));
        buttonCareer.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Карьера",textNamePage.getText());
        test_pages();
    }
}
