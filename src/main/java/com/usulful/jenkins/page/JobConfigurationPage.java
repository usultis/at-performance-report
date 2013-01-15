package com.usulful.jenkins.page;

import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.usulful.selenium.WebElementPredicates.withText;

public class JobConfigurationPage {
    private WebDriver driver;


    public JobConfigurationPage(WebDriver driver) {
        this.driver = driver;
    }

    public JobConfigurationPage scm(String scmName) {
        Iterables.find(driver.findElements(By.tagName("label")), withText(scmName)).click();
        return this;
    }


    public JobConfigurationPage enter(String name, String value) {
        driver.findElement(By.name(name)).sendKeys(value);
        return this;
    }

    public JobConfigurationPage addBuildStep(String linkText) {
        findButton("Add build step").click();
        driver.findElement(By.linkText(linkText)).click();
        return this;
    }

    public MainPage save() {
        findButton("Save").click();
        return PageFactory.initElements(driver, MainPage.class);
    }

    public JobConfigurationPage goals(String goals) {
        driver.findElement(goalsLocator()).sendKeys(goals);
        return this;
    }

    private By goalsLocator() {
        return By.name("_.targets");
    }

    private WebElement findButton(String text) {
        return Iterables.find(driver.findElements(By.tagName("button")), withText(text));
    }
}
