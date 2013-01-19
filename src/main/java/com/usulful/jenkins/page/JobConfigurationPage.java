package com.usulful.jenkins.page;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.usulful.selenium.WebElementPredicates.withText;

public class JobConfigurationPage {
    private WebDriver driver;

    public JobConfigurationPage(WebDriver driver) {
        this.driver = driver;
    }

    public JobConfigurationPage scm(String scmName) {
        findElementWithText(By.tagName("label"), scmName).click();
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
        driver.findElements(By.xpath("//button[contains(., 'Advanced...')]")).get(6).click();
        //driver.findElements(By.cssSelector("css=button:contains('Advanced...')")).get(1).click();
        return this;
    }

    private WebElement findButton(String text) {
        return findElementWithText(By.tagName("button"), text);
    }

    private WebElement findElementWithText(final By locator, final String text) {
        return new WebDriverWait(driver,5).until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return Iterables.find(driver.findElements(locator), withText(text), null);
            }

            @Override
            public String toString() {
                return "tag with text=" + text + " is present";
            }
        });

    }

}
