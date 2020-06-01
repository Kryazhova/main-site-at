package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
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

    static Stream<Arguments> pages() {
        return Stream.of(
                Arguments.of("[id='nav'] [href='/courses']", "Курсы"),
                Arguments.of( "[id='nav'] [href='/events']",  "Вебинары"),
                Arguments.of("[id='nav'] [href='/topics']", "Форум"),
                Arguments.of("[id='nav'] [href='/posts']",  "Блог"),
                Arguments.of("[id='nav'] [href='/tests']", "Тесты"),
                Arguments.of("[id='nav'] [href='/career']",  "Карьера")
        );
    }


    @DisplayName("Проверка страниц")
    @ParameterizedTest
    @MethodSource("pages")
    void check_pages(String nameLocator, String namePage) {
        try {
            driver.findElement(By.cssSelector("button>[class=\"svg-icon icon-popup-close-button \"]")).click();
        }
        catch (WebDriverException e){
            System.out.println("Не был найден необязательный элемент: " + e);

        }

        //для модального окна, так как оно не всегда появлялось

        //прописала finally, так как по другому у меня не получилось продолжить проверку, если
        // ловила WebDriverException. Может быть можно как-то без finally указать, что этот код
        // нам всегда нужен?
        finally {
            WebElement pagesElement = driver.findElement(By.cssSelector(nameLocator));
            pagesElement.click();
            WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
            wait3.until(ExpectedConditions.textToBePresentInElement(textNamePage, namePage));
//        Assertions.assertEquals(namePage, textNamePage.getText());
            test_pages();
        }
    }

}



