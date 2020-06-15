package ru.geekbrain.main.site.at.elementsTestSearch;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrain.main.site.at.commonBlocks.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SearchTextElement extends BasePageObject {

    @FindBy(css = "[class=\"profession-title\"]")
    private WebElement profession;

    @FindBy(css = "[class=\"course-item__description__title h3 search_text\"]")
    private WebElement course;

    @FindBy(css = "[class=\"event__title h3 search_text\"]")
    private WebElement event;

    @FindBy(css = "[class=\"blog-item__title h3 search_text\"]")
    private WebElement blog;

    @FindBy(css = "[class=\"forum-item__title h3\"]")
    private WebElement forums;

    @FindBy(css = "[class=\"test-item__level\"]")
    private WebElement test;

    @FindBy(css = "[class=\"company-items\"]")
    private WebElement project;

    public SearchTextElement(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка текста в блоке {name}")
    private WebElement testSearchElement(SearchElement.SearchTab searchTab) {
        switch (searchTab) {
            case Professions: {
                return profession;
            }
            case Courses: {
                return course;
            }
            case Enents: {
                return event;
            }
            case Blogs: {
                return blog;
            }
            case Forums: {
                return forums;
            }
            case Tests: {
                return test;
            }
            case Companies: {
                return project;
            }
            default: {
                throw new IllegalStateException("Нет блока: " + searchTab);
            }
        }
    }

    public SearchTextElement testSearchText(SearchElement.SearchTab searchTab, String text) {
        assertThat(searchTab.getText(), containsString(text));
        return this;
    }
}

