package ru.geekbrain.main.site.at.elementsTestNavigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrain.main.site.at.pages.Pages;

public class HeaderElements {
    private WebDriver driver;

    @FindBy(css = "[id='top-menu']")
    private WebElement topMenu;

    @FindBy(css = "h2[class='gb-header__title']")
    private WebElement titleHeader;

    @FindBy(css = "[class='gb-top-menu__item']>[class='show-search-form']")
    private WebElement searchItem;

    @FindBy(css = "[class='gb-top-menu__item']>[href='/login']")
    private WebElement loginItem;

    @FindBy(css = "[href='/register']")
    private WebElement registerHeader;


    public HeaderElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Pages testHeader() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(
                        topMenu,
                        titleHeader,
                        searchItem,
                        loginItem,
                        registerHeader));
        return new Pages(driver);
    }
}


