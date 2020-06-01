package ru.geekbrain.main.site.at.FirstExample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationElements {
    public WebElement getButtonCourses() {
        return buttonCourses;
    }

    public WebElement getButtonEvents() {
        return buttonEvents;
    }

    public WebElement getButtonTopics() {
        return buttonTopics;
    }

    public WebElement getButtonPosts() {
        return buttonPosts;
    }

    public WebElement getButtonTests() {
        return buttonTests;
    }

    public WebElement getButtonCareer() {
        return buttonCareer;
    }

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
}
