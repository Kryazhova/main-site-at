package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


    @DisplayName("Проверка страниц")
    @ParameterizedTest
    @MethodSource("pages")
    void check_pages(String nameLocator, String namePage) {
//        try {
//            driver.findElement(By.cssSelector("button>[class=\"svg-icon icon-popup-close-button \"]")).click();
//        }
//        catch (WebDriverException e){
//            System.out.println("Не был найден необязательный элемент: " + e);
//
//        }
//        для модального окна, так как оно не всегда появлялось - Перенесла проверку в Base,
//        так как для SearchTest тоже иногда появляется модальное окно

            WebElement pagesElement = driver.findElement(By.cssSelector(nameLocator));
            pagesElement.click();
            WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
            wait3.until(ExpectedConditions.textToBePresentInElement(textNamePage, namePage));
//        Assertions.assertEquals(namePage, textNamePage.getText());
            test_pages();
    }

}



