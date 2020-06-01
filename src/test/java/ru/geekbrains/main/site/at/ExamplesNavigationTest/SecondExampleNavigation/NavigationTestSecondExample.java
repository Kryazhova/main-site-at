package ru.geekbrains.main.site.at.ExamplesNavigationTest.SecondExampleNavigation;

import org.junit.jupiter.api.Test;
import ru.geekbrain.main.site.at.SecondExample.NavigationElementsTwo;
import ru.geekbrain.main.site.at.SecondExample.Pages;
import ru.geekbrains.main.site.at.Base.Base;

public class NavigationTestSecondExample extends Base {
    // пример теста для кнопки Навигации Вебинары: вынесли Header элемент и эл0ты навигации
    @Test
    void events(){
        NavigationElementsTwo navigation = new NavigationElementsTwo(driver);
        Pages pages = new Pages(driver);
        navigation.getButtonEvents().click();
//        Пример для getter
//        Assertions.assertEquals("Вебинары", pages.getTextNamePage().getText());
        pages.checkNamePage("Вебинары");
    }
}
