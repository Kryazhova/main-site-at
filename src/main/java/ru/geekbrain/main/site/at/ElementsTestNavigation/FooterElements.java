package ru.geekbrain.main.site.at.ElementsTestNavigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrain.main.site.at.Pages.Pages;

//верхнеуровневые проверки футера

public class FooterElements {
    private WebDriver driver;

    @FindBy(css =  "[class='site-footer']")
    private WebElement baseFooterElement;

    @FindBy(css = "[class='site-footer__icons']")
    private WebElement footerIcons;

    @FindBy(css = "[class='site-footer__links']")
    private WebElement footerLinks;

    @FindBy(css = "[class='site-footer__icons site-footer__icons_android']")
    private WebElement footerIconsAndroid;


    public FooterElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Pages testFooter(){
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfAllElements(
                            baseFooterElement,
                            footerIcons,
                            footerLinks,
                            footerIconsAndroid));
            return new Pages(driver);
    }

}
