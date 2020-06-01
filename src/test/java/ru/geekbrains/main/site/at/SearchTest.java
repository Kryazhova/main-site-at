package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrain.main.site.at.Pages.SearchPage;
import ru.geekbrains.main.site.at.Base.Base;

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

    String[] blockSearch = new String[]{
            "Профессии",
            "Курсы",
            "Вебинары",
            "Блоги",
            "Форум",
            "Тесты",
            "Проекты и компании" };


    @DisplayName("Проверка поиска")
    @Test
     void events(){
       new SearchPage(driver)
               .closePopup()
               .clickIconSearch()
               .inputSearchText();

       for (String block:blockSearch){
           new SearchPage(driver)
                   .getSearchElement().testSearchPage(block)
                   .getCountSearchElement().countSearchElement(block)
                   .getTextSearchTest().textSearchTest(block);
        }
    }
}
