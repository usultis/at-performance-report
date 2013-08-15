package com.usulful.jenkins.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JobConfigurationPage {
    private WebDriver driver;

    public JobConfigurationPage(WebDriver driver) {
        this.driver = driver;
    }

    public JobConfigurationPage scm(String scmName) {
        driver.findElement(By.xpath(String.format("//%s[contains(., '%s')]", "label", scmName))).click();
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
        driver.findElement(By.name("_.targets")).sendKeys(goals);
        return this;
    }

    public JobConfigurationPage buildProperties(String options) {
        driver.findElement(By.name("_.properties")).sendKeys(options);
        return this;
    }

    public JobConfigurationPage addPostBuildStep(String linkText) {
        clickButton("Add post-build action")
                .clickLinkWithText(linkText);
        return this;
    }

    public JobConfigurationPage clickButton(String text) {
        findButton(text).click();
        return this;
    }

    public JobConfigurationPage clickLinkWithText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        return this;
    }

    public JobConfigurationPage clickMavenAdvanced() {
        driver.findElement(By.xpath("//div[@descriptorid='hudson.tasks.Maven']/descendant-or-self::node()/child::button[contains(., 'Advanced...')]")).click();
        return this;
    }

    private WebElement findButton(String text) {
        return driver.findElement(By.xpath("//button[contains(., '" + text + "')]"));
    }

}
