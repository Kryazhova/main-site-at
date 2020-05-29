package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.Base.Base;

public class SearchTest extends Base {
    @Test
    void events() {
        WebElement buttonSearch = driver.findElement(By.cssSelector("[class=\"show-search-form\"] [class=\"svg-icon icon-search \"]"));
        buttonSearch.click();
        WebElement inputSearch = driver.findElement(By.cssSelector("[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");


        WebElement professions = driver.findElement(By.cssSelector("[id=\"professions\"] h2"));
        WebElement courses = driver.findElement(By.xpath(".//header/h2[text()='Курсы']"));
        WebElement events = driver.findElement(By.xpath(".//header/h2[text()='Вебинары']"));
        WebElement blogs = driver.findElement(By.xpath(".//header/h2[text()='Блоги']"));
        WebElement forum = driver.findElement(By.xpath(".//header/h2[text()='Форум']"));
        WebElement tests = driver.findElement(By.xpath(".//header/h2[text()='Тесты']"));
        WebElement projectAndCompany = driver.findElement(By.xpath(".//header/h2[text()='Проекты и компании']"));

        wait3.until(ExpectedConditions.textToBePresentInElement(professions,"Профессии"));
        wait3.until(ExpectedConditions.textToBePresentInElement(courses,"Курсы"));
        wait3.until(ExpectedConditions.textToBePresentInElement(events,"Вебинары"));
        wait3.until(ExpectedConditions.textToBePresentInElement(blogs,"Блоги"));
        wait3.until(ExpectedConditions.textToBePresentInElement(forum,"Форум"));
        wait3.until(ExpectedConditions.textToBePresentInElement(tests,"Тесты"));
        wait3.until(ExpectedConditions.textToBePresentInElement(projectAndCompany,"Проекты и компании"));
    }
}
