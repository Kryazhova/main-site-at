package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.Base.Base;

import java.util.stream.Stream;

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

//    static Stream<String> pages() {
//        return Stream.of(
//                "Курсы",
//                "Вебинары",
//                "Форум",
//                "Блог",
//                "Тесты",
//                "Карьера"
//              );
//    }


    static Stream<String> pages() {
        return Stream.of(
                "[id='nav'] [href='/courses']",
                "[id='nav'] [href='/events']",
                "[id='nav'] [href='/topics']",
                "[id='nav'] [href='/posts']",
                "[id='nav'] [href='/tests']",
                "[id='nav'] [href='/career']"
        );
    }

    // не получилось указать данные и по навигации и по названию поля в ParameterizedTest

    @DisplayName("Проверка страниц")
    @ParameterizedTest
    @MethodSource("pages")
    void check_pages(String nameLocator) {
        driver.findElement(By.cssSelector("button>[class=\"svg-icon icon-popup-close-button \"]")).click();
        //только пока есть модальное окно

        WebElement pagesElement = driver.findElement(By.cssSelector(nameLocator));
        pagesElement.click();
        WebElement testTextPages = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        wait3.until(ExpectedConditions.visibilityOf(testTextPages));
        test_pages();
    }
}



//    @DisplayName("Проверка страницы Курсы")
//    @Test
//    void courses(){
////        driver.findElement(By.cssSelector("button>[class=\"svg-icon icon-popup-close-button \"]")).click();
//        WebElement buttonCourses = driver.findElement(By.cssSelector("[id='nav'] [href='/courses']"));
//        buttonCourses.click();
//        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
//        Assertions.assertEquals("Курсы", textNamePage.getText());
//    }
//
//    @DisplayName("Проверка страницы Вебинары")
//    @Test
//    void events(){
//        WebElement buttonEvents = driver.findElement(By.cssSelector("[id='nav'] [href='/events']"));
//        buttonEvents.click();
//        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
//        Assertions.assertEquals("Вебинары", textNamePage.getText());
//    }
//
//    @DisplayName("Проверка страницы Форум")
//    @Test
//    void topics() {
//        WebElement buttonTopics = driver.findElement(By.cssSelector("[id='nav'] [href='/topics']"));
//        buttonTopics.click();
//        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
//        Assertions.assertEquals("Форум", textNamePage.getText());
//    }
//    @DisplayName("Проверка страницы Блог")
//    @Test
//    void posts() {
//        WebElement buttonPosts = driver.findElement(By.cssSelector("[id='nav'] [href='/posts']"));
//        buttonPosts.click();
//        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
//        Assertions.assertEquals("Блог",textNamePage.getText());
//    }
//    @DisplayName("Проверка страницы Тесты")
//    @Test
//    void tests() {
//        WebElement buttonTests = driver.findElement(By.cssSelector("[id='nav'] [href='/tests']"));
//        buttonTests.click();
//        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
//        Assertions.assertEquals("Тесты",textNamePage.getText());
//    }
//    @DisplayName("Проверка страницы Карьера")
//    @Test
//    void career() {
//        WebElement buttonCareer = driver.findElement(By.cssSelector("[id='nav'] [href='/career']"));
//        buttonCareer.click();
//        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
//        Assertions.assertEquals("Карьера",textNamePage.getText());
//    }

