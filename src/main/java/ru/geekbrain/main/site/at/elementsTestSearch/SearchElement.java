package ru.geekbrain.main.site.at.elementsTestSearch;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrain.main.site.at.pages.SearchPage;

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
    public SearchPage testSearchPage (String[] name) {
        WebDriverWait wait20 = new WebDriverWait(driver,20);
        for (String nameBlock:name) {
            switch (nameBlock) {
                case "Профессии": {
                    wait20.until(ExpectedConditions.textToBePresentInElement(profession, nameBlock));
                    break;
                }
                case "Курсы": {
                    wait20.until(ExpectedConditions.textToBePresentInElement(course, nameBlock));
                    break;
                }
                case "Вебинары": {
                    wait20.until(ExpectedConditions.textToBePresentInElement(event, nameBlock));
                    break;
                }
                case "Блоги": {
                    wait20.until(ExpectedConditions.textToBePresentInElement(blog, nameBlock));
                    break;
                }
                case "Форум": {
                    wait20.until(ExpectedConditions.textToBePresentInElement(forums, nameBlock));
                    break;
                }
                case "Тесты": {
                    wait20.until(ExpectedConditions.textToBePresentInElement(test, nameBlock));
                    break;
                }
                case "Проекты и компании": {
                    wait20.until(ExpectedConditions.textToBePresentInElement(projectAndCompanies, nameBlock));
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
