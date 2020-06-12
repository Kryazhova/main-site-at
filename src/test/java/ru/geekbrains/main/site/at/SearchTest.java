package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrain.main.site.at.elementsTestSearch.CountTest;
import ru.geekbrain.main.site.at.pages.SearchPage;
import ru.geekbrains.main.site.at.base.Base;

import static org.hamcrest.Matchers.*;

//    Перейти на сайт https://geekbrains.ru/courses
//            Нажать на кнопку Поиск
//            В поле Поиск ввести текст: java
//            Проверить что отобразились блоки и в них:
//            Профессий не менее чем 2
//            Курсов более 15
//            Вебинаров больше чем 180, но меньше 300
//            В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
//            Блогов более 300
//            Форумов не 350
//            Тестов не 0
//            В Проектах и компаниях отображается GeekBrains

public class SearchTest extends Base {

    String[] nameBlock = new String[]{
            "Профессии","Курсы","Вебинары","Блоги", "Форум", "Тесты", "Проекты и компании"
    };
    String[] nameTextCheck = new String[]{
           "Вебинары","Проекты и компании"
    };

    @DisplayName("Проверка поиска")
    @Description("Проверка поиска по слову \"Java\"")
    @Test
     void events(){
        new SearchPage(driver)
                .closePopup()
                .clickIconSearch()
                .inputSearchText("java")
                .getSearchElement()
                .testSearchPage(nameBlock)
                .getTextSearchTest()
                .textSearchTest(nameTextCheck)
                .getCountTest()
                .checkCount(CountTest.Blocks.Professions, greaterThanOrEqualTo(2))
                .checkCount(CountTest.Blocks.Courses, greaterThan(15))
                .checkCount(CountTest.Blocks.Events, allOf(
                        greaterThan(180),
                        lessThan(300)))
                .checkCount(CountTest.Blocks.Blogs, greaterThan(300))
                .checkCount(CountTest.Blocks.Forum, not(350))
                .checkCount(CountTest.Blocks.Tests, not(0));

    }
}
