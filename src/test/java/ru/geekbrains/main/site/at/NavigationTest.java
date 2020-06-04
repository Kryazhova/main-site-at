package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrain.main.site.at.Pages.Pages;
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

//    Мое решение отличается, так как стартовая страница отличается от примера на уроке
//    У меня оставлена та проверка, которая была указана со стартовой стр. как
//    в ДЗ №3 https://geekbrains.ru/lessons/68986/homework
//    Поп-ап показывается 1 раз, в моем случае на стартовой странице "Курсы".
//    Но в решении разобралась и сохранила его себе ниже
    static Stream<String> pageNavigation() {
        return Stream.of(
                "Блог",
                "Курсы",
                "Вебинары",
                "Форум",
                "Тесты",
                "Карьера"
        );
    }

    @DisplayName("Улучшенная проверка с Page Factory для каждой страницы навигации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("pageNavigation")
    void testPagesWithPopUp(String namePage){
        new Pages(driver)
                .closePopup()
                .getNavigation().click(namePage)
                .checkNamePage(namePage)
                .getHeaderElements().testHeader()
                .getFooterElements().testFooter();
    }
}
//    Вариант решения на уроке - вход со страницы
//    driver.get("https://geekbrains.ru/career");
//    В таком случае поп-ап возникал не на всех страницах, а только для 1-го появления поп-ап
//    на страницах "Блоки" и "Курсы". У меня оставлена та проверка, которая была указана
//    в ДЗ №3 https://geekbrains.ru/lessons/68986/homework
//
//    static Stream<String> pageNavigation1() {
//        return Stream.of(
//                "Блог",
//                "Курсы"
//        );
//    }
//    static Stream<String> pageNavigation2() {
//        return Stream.of(
//                "Вебинары",
//                "Форум",
//                "Тесты",
//                "Карьера"
//        );
//    }
//    @DisplayName("Улучшенная проверка с Page Factory для каждой страницы навигации")
//    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
//    @MethodSource("pageNavigation1")
//    void testPagesWithPopUp(String namePage){
//        new Pages(driver)
//                .getNavigation().click(namePage)
//                .closePopup()
//                .checkNamePage(namePage)
//                .getHeaderElements().testHeader()
//                .getFooterElements().testFooter();
//    }
//
//    @DisplayName("Улучшенная проверка с Page Factory для каждой страницы навигации")
//    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
//    @MethodSource("pageNavigation2")
//    void testPages(String namePage){
//        new Pages(driver)
//                .getNavigation().click(namePage)
//                .checkNamePage(namePage)
//                .getHeaderElements().testHeader()
//                .getFooterElements().testFooter();
//    }




