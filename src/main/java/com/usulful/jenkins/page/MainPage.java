package com.usulful.jenkins.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(linkText = "New Job")
    private WebElement newJob;

    public NewJobPage clickNewJob() {
        newJob.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("New Job"));
        return PageFactory.initElements(driver, NewJobPage.class);
    }
}
