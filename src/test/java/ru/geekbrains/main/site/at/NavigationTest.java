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

    static Stream<String> pageNavigation() {
        return Stream.of(
                "Вебинары",
                "Форум",
                "Блог",
                "Тесты",
                "Карьера",
                "Курсы"
        );
    }
    @DisplayName("Улучшенная проверка с Page Factory для каждой страницы навигации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("pageNavigation")
    void testPages(String namePage){
        new Pages(driver)
                .closePopup()
                .getNavigation().click(namePage)
                .checkNamePage(namePage)
                .getHeaderElements().testHeader()
                .getFooterElements().testFooter();
//        new FooterElements(driver)
//                .testFooter();
    }

}



