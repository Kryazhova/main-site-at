package ru.geekbrains.main.site.at.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public WebDriverWait wait3;
    public WebDriverWait wait10;

    @BeforeEach
    void before() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications","--disable-popup-blocking");
        option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.get("https://geekbrains.ru/courses");
        wait3 = new WebDriverWait(driver, 3);
        wait10 = new WebDriverWait(driver, 10);

        try {
            driver.findElement(By.cssSelector("button>[class=\"svg-icon icon-popup-close-button \"]")).click();
        }
        catch (WebDriverException e){
            System.out.println("Не был найден необязательный элемент: " + e);
        }
//        finally - чтобы даже есть Exception, то Test будет выполняться
        finally {

        }
    }

    @AfterEach
    void after() {
        driver.close();
    }

    static String[] elements = {
            "[id='top-menu']",
            "h2[class='gb-header__title']",
            "[class='gb-top-menu__item']>[class='show-search-form']",
            "[class='gb-top-menu__item']>[href='/login']",
            "[href='/register']",
            "[class='site-footer']",
            "[class='site-footer__icons']",
            "[class='site-footer__links']",
            "[class='site-footer__icons site-footer__icons_android']"
    };

    public void test_pages() {
        for (String o : elements){
            WebElement testHeaders = driver.findElement(By.cssSelector(o));
            wait3.until(ExpectedConditions.visibilityOf(testHeaders));
        }

    }

}



