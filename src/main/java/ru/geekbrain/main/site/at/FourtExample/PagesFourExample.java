package ru.geekbrain.main.site.at.FourtExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagesFourExample {
    private WebDriver driver;
    private NavigationElementsFour navigation;

   @FindBy(css = "h2[class=\"gb-header__title\"]")
   private WebElement textNamePage;

   public PagesFourExample(WebDriver driver) {
       this.driver = driver;
       navigation = new NavigationElementsFour(driver);
       PageFactory.initElements(driver,this);
   }


   public PagesFourExample checkNamePage(String expectedNamePage) {
       new WebDriverWait(driver, 10)
               .until(ExpectedConditions.textToBePresentInElement(textNamePage, expectedNamePage));
       return this;
   }

    public NavigationElementsFour getNavigation() {
        return navigation;
    }
//       Assertions.assertEquals(expectedNamePage, textNamePage.getText());
}
