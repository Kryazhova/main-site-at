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
        option.addArguments("--disable-notifications");
        option.addArguments("--disable-popup-blocking");
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
        finally {

        }
    }

//    static Stream<String> footer() {
//        return Stream.of("[class='site-footer']", "[class='site-footer__icons']",
//                "[class='site-footer__links']", "[class='site-footer__icons site-footer__icons_android']");
//    }
//
//    @DisplayName("передача данны элементов футера")
//    @ParameterizedTest
//    @MethodSource("footer")
//    public void check_footer(String nameFooter) {
//        WebElement footerElement = driver.findElement(By.cssSelector(nameFooter));
//        wait3.until(ExpectedConditions.visibilityOf(footerElement));
//    }
//
//    static Stream<String> headers() {
//        return Stream.of("[id='top-menu']", "h2[class='gb-header__title']",
//                "[class='gb-top-menu__item']>[class='show-search-form']",
//                "[class='gb-top-menu__item']>[href='/login']", "[href='/register']");
//    }
//
//    @DisplayName("передача данных элементов хедера")
//    @ParameterizedTest
//    @MethodSource("headers")
//    void check_headers(String nameHeader){
//        WebElement headerElement = driver.findElement(By.cssSelector(nameHeader));
//        wait3.until(ExpectedConditions.visibilityOf(headerElement));
//        }

    @AfterEach
    void after() {
        driver.close();
    }

    public void test_pages() {
        WebElement hh =  driver.findElement(By.cssSelector("[id='top-menu']"));
        wait3.until(ExpectedConditions.visibilityOf(hh));

        WebElement title = driver.findElement(By.cssSelector("h2[class='gb-header__title']"));
        wait3.until(ExpectedConditions.visibilityOf(title));

        WebElement icon_search = driver.findElement(By.cssSelector("[class='gb-top-menu__item']>[class='show-search-form']"));
        wait3.until(ExpectedConditions.visibilityOf(icon_search));

        WebElement icon_exit = driver.findElement(By.cssSelector("[class='gb-top-menu__item']>[href='/login']"));
        wait3.until(ExpectedConditions.visibilityOf(icon_exit));

        WebElement icon_registry = driver.findElement(By.cssSelector("[href='/register']"));
        wait3.until(ExpectedConditions.visibilityOf(icon_registry));


        WebElement footer = driver.findElement(By.cssSelector("[class='site-footer']"));
        wait3.until(ExpectedConditions.visibilityOf(footer));

        WebElement icons = driver.findElement(By.cssSelector("[class='site-footer__icons']"));
        wait3.until(ExpectedConditions.visibilityOf(icons));


        WebElement links = driver.findElement(By.cssSelector("[class='site-footer__links']"));
        wait3.until(ExpectedConditions.visibilityOf(links));

        WebElement icons_android = driver.findElement(By.cssSelector("[class='site-footer__icons site-footer__icons_android']"));
        wait3.until(ExpectedConditions.visibilityOf(icons_android));

    }

}



