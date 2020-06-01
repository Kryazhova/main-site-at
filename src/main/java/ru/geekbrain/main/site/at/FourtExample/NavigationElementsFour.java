package ru.geekbrain.main.site.at.FourtExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationElementsFour {

    @FindBy(css = "[id='nav'] [href='/courses']")
    private WebElement buttonCourses;

    @FindBy(css = "[id='nav'] [href='/events']")
    private WebElement buttonEvents;

    @FindBy(css = "[id='nav'] [href='/topics']")
    private WebElement buttonTopics;

    @FindBy(css = "[id='nav'] [href='/posts']")
    private WebElement buttonPosts;

    @FindBy(css = "[id='nav'] [href='/tests']")
    private WebElement buttonTests;

    @FindBy(css = "[id='nav'] [href='/career']")
    private WebElement buttonCareer;

    private WebDriver driver;

    public NavigationElementsFour(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //    public CoursesPage click (String name) {
//        switch (name){
//            case "Курсы": {
//                buttonCourses.click();
//                return new CoursesPage();
//            }


    public PagesFourExample click (String name) {
        switch (name){
            case "Курсы": {
                buttonCourses.click();
            }
            case "Вебинары": {
                buttonEvents.click();
                break;
            }
            case "Форум": {
                buttonTopics.click();
                break;
            }
            case "Блог": {
                buttonPosts.click();
                break;
            }
            case "Тесты": {
                buttonTests.click();
                break;
            }
            case "Карьера": {
                buttonCareer.click();
                break;
            }
            default: {
                throw new RuntimeException("Нет кнопки: " + name);
            }
        }
        return new PagesFourExample(driver);
    }

}
