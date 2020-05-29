package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    @Test
    void courses(){
//        driver.findElement(By.cssSelector("button>[class=\"svg-icon icon-popup-close-button \"]")).click();
        WebElement buttonCourses = driver.findElement(By.cssSelector("[id='nav'] [href='/courses']"));
        buttonCourses.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Курсы", textNamePage.getText());
    }

    @Test
    void events(){
        WebElement buttonEvents = driver.findElement(By.cssSelector("[id='nav'] [href='/events']"));
        buttonEvents.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Вебинары", textNamePage.getText());
    }
    @Test
    void topics() {
        WebElement buttonTopics = driver.findElement(By.cssSelector("[id='nav'] [href='/topics']"));
        buttonTopics.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Форум", textNamePage.getText());
    }
    @Test
    void posts() {
        WebElement buttonPosts = driver.findElement(By.cssSelector("[id='nav'] [href='/posts']"));
        buttonPosts.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Блог",textNamePage.getText());
    }
    @Test
    void tests() {
        WebElement buttonTests = driver.findElement(By.cssSelector("[id='nav'] [href='/tests']"));
        buttonTests.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Тесты",textNamePage.getText());
    }
    @Test
    void career() {
        WebElement buttonCareer = driver.findElement(By.cssSelector("[id='nav'] [href='/career']"));
        buttonCareer.click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Карьера",textNamePage.getText());
    }
}
