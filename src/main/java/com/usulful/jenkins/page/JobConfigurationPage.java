package com.usulful.jenkins.page;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.usulful.selenium.WebElementPredicates.withText;

public class JobConfigurationPage {
    private WebDriver driver;


    public JobConfigurationPage(WebDriver driver) {
        this.driver = driver;
    }

    public JobConfigurationPage scm(String scmName) {
        Iterables.find(driver.findElements(By.name("scm")), withText(scmName)).click();
        return this;
    }


    public JobConfigurationPage enter(String name, String value) {
        driver.findElement(By.name(name)).sendKeys(value);
        return this;
    }
}
