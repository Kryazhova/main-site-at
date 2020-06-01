package ru.geekbrains.main.site.at.ExamplesNavigationTest.FirstExampleNavigation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.FirstExample.NavigationElements;
import ru.geekbrains.main.site.at.Base.Base;

public class NavigationTestFirstExample extends Base {
    // пример теста для кнопки Навигации Вебинары
    @Test
    void events(){
        NavigationElements navigation = PageFactory.initElements(driver, NavigationElements.class);
        navigation.getButtonEvents().click();
        WebElement textNamePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Вебинары", textNamePage.getText());
    }
}
