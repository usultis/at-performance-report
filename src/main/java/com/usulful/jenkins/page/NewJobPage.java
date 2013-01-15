package com.usulful.jenkins.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewJobPage {
    private WebDriver driver;

    @FindBy(id = "name")
    private WebElement jobNameField;

    @FindBy(id = "ok-button")
    private WebElement ok;

    public NewJobPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewJobPage enterJobName(String jobName) {
        jobNameField.sendKeys(jobName);
        return this;
    }

    public JobConfigurationPage clickOK() {
        ok.click();
        return PageFactory.initElements(driver, JobConfigurationPage.class);
    }

    public NewJobPage freestyleBuild() {
        freestyle().click();
        return this;
    }

    private WebElement freestyle() {
        return driver.findElements(By.name("mode")).get(0);
    }
}
