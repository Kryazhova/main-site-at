package ru.geekbrains.main.site.at.ExamplesNavigationTest.FourthExampleNavigation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrain.main.site.at.FourtExample.PagesFourExample;
import ru.geekbrains.main.site.at.Base.Base;

import java.util.stream.Stream;

public class NavigationTestFourthExample extends Base {
    // теперь нажатие и проверка кнопки проверяется в классе NavigationElementsThree
    //таким образом тут можно только указать, что мы будет проверять

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
        new PagesFourExample(driver)
                .getNavigation().click(namePage)
                .checkNamePage(namePage);
    }
}
