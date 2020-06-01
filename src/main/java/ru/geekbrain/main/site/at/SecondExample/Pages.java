package ru.geekbrain.main.site.at.SecondExample;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class Pages {

// getter используем, только если нужно будет образаться из другого класса
// тут мы вынесли проверку на страницу Pages
//
//    public WebElement getTextNamePage() {
//        return textNamePage;
//    }

    @FindBy(css = "h2[class=\"gb-header__title\"]")
    private WebElement textNamePage;

    public Pages(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void checkNamePage(String expectedNamePage) {
        Assertions.assertEquals(expectedNamePage, textNamePage.getText());
    }
}
