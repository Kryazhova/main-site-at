package ru.geekbrain.main.site.at.ThirdExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagesThreeExample {

// getter используем, только если нужно будет образаться из другого класса
// тут мы вынесли проверку на страницу Pages
//
//    public WebElement getTextNamePage() {
//        return textNamePage;
//    }

   @FindBy(css = "h2[class=\"gb-header__title\"]")
   private WebElement textNamePage;
   private WebDriver driver;

   public PagesThreeExample(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver,this);
   }

   public void checkNamePage(String expectedNamePage) {
       new WebDriverWait(driver, 3)
               .until(ExpectedConditions.textToBePresentInElement(textNamePage, expectedNamePage));
   }
//       Assertions.assertEquals(expectedNamePage, textNamePage.getText());
}
