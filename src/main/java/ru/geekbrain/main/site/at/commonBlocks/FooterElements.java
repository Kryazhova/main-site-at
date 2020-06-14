package ru.geekbrain.main.site.at.commonBlocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

//верхнеуровневые проверки футера

public class FooterElements extends BasePageObject {

    @FindBy(css =  "[class='site-footer']")
    private WebElement baseFooterElement;

    @FindBy(css = "[class='site-footer__icons']")
    private WebElement footerIcons;

    @FindBy(css = "[class='site-footer__links']")
    private WebElement footerLinks;

    @FindBy(css = "[class='site-footer__icons site-footer__icons_android']")
    private WebElement footerIconsAndroid;


    public FooterElements(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    ContentBasePage contentBasePage;
    public ContentBasePage testFooter(){
           wait10second.until(ExpectedConditions.visibilityOfAllElements(
                            baseFooterElement,
                            footerIcons,
                            footerLinks,
                            footerIconsAndroid));
            return contentBasePage;
    }

}
