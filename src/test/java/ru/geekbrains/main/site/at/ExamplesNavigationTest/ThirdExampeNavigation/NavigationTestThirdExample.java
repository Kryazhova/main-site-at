package ru.geekbrains.main.site.at.ExamplesNavigationTest.ThirdExampeNavigation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrain.main.site.at.SecondExample.Pages;
import ru.geekbrain.main.site.at.FourtExample.NavigationElementsFour;
import ru.geekbrains.main.site.at.Base.Base;

import java.util.stream.Stream;

public class NavigationTestThirdExample extends Base {
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
    @ParameterizedTest
    @MethodSource("pageNavigation")
    void testPages(String namePage){
        NavigationElementsFour navigation = new NavigationElementsFour(driver);
        Pages pages = new Pages(driver);

        navigation.click(namePage);
        pages.checkNamePage(namePage);
    }
}
