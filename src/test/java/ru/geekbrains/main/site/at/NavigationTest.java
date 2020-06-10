package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrain.main.site.at.pages.Pages;
import ru.geekbrains.main.site.at.base.Base;

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
                "Блог",
                "Курсы",
                "Вебинары",
                "Форум",
                "Тесты",
                "Карьера"
        );
    }

    @DisplayName("Улучшенная проверка с Page Factory для каждой страницы навигации")
    @Description("Проверка навигации")
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





