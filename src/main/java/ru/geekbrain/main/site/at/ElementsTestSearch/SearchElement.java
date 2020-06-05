package ru.geekbrain.main.site.at.ElementsTestSearch;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrain.main.site.at.Pages.SearchPage;

public class SearchElement {
    private WebDriver driver;

    @FindBy(xpath = ".//header/h2[text()='Профессии']")
    private WebElement profession;

    @FindBy(xpath = ".//header/h2[text()='Курсы']")
    private WebElement course;

    @FindBy(xpath = ".//header/h2[text()='Вебинары']")
    private WebElement event;

    @FindBy(xpath = ".//header/h2[text()='Блоги']")
    private WebElement blog;

    @FindBy(xpath = ".//header/h2[text()='Форум']")
    private WebElement forums;

    @FindBy(xpath = ".//header/h2[text()='Тесты']")
    private WebElement test;

    @FindBy(xpath = ".//header/h2[text()='Проекты и компании']")
    private WebElement projectAndCompanies;

    public SearchElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Проверка блока {name}")
    public SearchPage testSearchPage (String name) {
        switch (name){
            case "Профессии": {
                new WebDriverWait(driver,20)
                        .until(ExpectedConditions.textToBePresentInElement(profession, name));
                break;
            }
            case "Курсы": {
                new WebDriverWait(driver,20)
                        .until(ExpectedConditions.textToBePresentInElement(course, name));
                break;
            }
            case "Вебинары": {
                new WebDriverWait(driver,20)
                        .until(ExpectedConditions.textToBePresentInElement(event, name));
                break;
            }
            case "Блоги": {
                new WebDriverWait(driver,20)
                        .until(ExpectedConditions.textToBePresentInElement(blog, name));
                break;
            }
            case "Форум": {
                new WebDriverWait(driver,20)
                        .until(ExpectedConditions.textToBePresentInElement(forums, name));
                break;
            }
            case "Тесты": {
                new WebDriverWait(driver,20)
                        .until(ExpectedConditions.textToBePresentInElement(test, name));
                break;
            }
            case "Проекты и компании": {
                new WebDriverWait(driver,20)
                        .until(ExpectedConditions.textToBePresentInElement(projectAndCompanies, name));
                break;
            }
            default: {
                throw new RuntimeException("Нет блока: " + name);
            }
        }
        return new SearchPage(driver);
    }
}
