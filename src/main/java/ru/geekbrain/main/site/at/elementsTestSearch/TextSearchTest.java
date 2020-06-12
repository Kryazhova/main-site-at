package ru.geekbrain.main.site.at.elementsTestSearch;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.pages.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TextSearchTest {
    private WebDriver driver;

    @FindBy(css = "[class=\"event__title h3 search_text\"]")
    private WebElement event;

    @FindBy(css = "[class=\"company-items\"]")
    private WebElement project;

    public TextSearchTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка, что найдены нужные элементы в блоке {name}")
    public SearchPage textSearchTest (String[] name) {
        for (String nameBlock:name) {
            switch (nameBlock) {
                case "Вебинары": {
                    assertThat(event.getText(), containsString("Java Junior. Что нужно знать для успешного собеседования?"));
                    break;
                }
                case "Проекты и компании": {
                    assertThat(project.getText(), containsString("GeekBrains"));
                    break;
                }
                default: {
                    throw new RuntimeException("Нет блока: " + nameBlock);
                }
            }
        }
        return new SearchPage(driver);
    }
}
