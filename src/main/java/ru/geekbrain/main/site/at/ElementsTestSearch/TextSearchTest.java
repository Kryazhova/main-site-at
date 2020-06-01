package ru.geekbrain.main.site.at.ElementsTestSearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.Pages.SearchPage;

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

    public SearchPage textSearchTest (String name) {
        switch (name){
            case "Профессии": {
                System.out.println("Нет проверки на содержание для данного блока: " + name);
            }
            case "Курсы": {
                System.out.println("Нет проверки на содержание для блока: " + name );
                break;
            }
            case "Вебинары": {
                assertThat(event.getText(), containsString("Java Junior. Что нужно знать для успешного собеседования?"));
                break;
            }
            case "Блоги": {
                System.out.println("Нет проверки на содержание для  блока: " + name);
                break;
            }
            case "Форум": {
                System.out.println("Нет проверки на содержание для  блока " + name);
                break;
            }
            case "Тесты": {
                System.out.println("Нет проверки на содержание для блока " + name);
                break;
            }
            case "Проекты и компании": {
                assertThat(project.getText(),containsString("GeekBrains"));
                break;
            }
            default: {
                throw new RuntimeException("Нет блока: " + name);
            }
        }
        return new SearchPage(driver);
    }
}
