package ru.geekbrains.main.site.at.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.get("https://geekbrains.ru/courses");
        wait3 = new WebDriverWait(driver, 3);
        wait10 = new WebDriverWait(driver, 10);

    }

    @AfterEach
    void after() {
        driver.close();
    }

}



