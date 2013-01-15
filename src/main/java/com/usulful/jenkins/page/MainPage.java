package com.usulful.jenkins.page;

import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.usulful.selenium.WebElementPredicates.withTitle;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(linkText = "New Job")
    private WebElement newJob;

    public NewJobPage clickNewJob() {
        newJob.click();
        return PageFactory.initElements(driver, NewJobPage.class);
    }

    public JobPage openJob(String jobName) {
        driver.findElement(By.linkText(jobName)).click();
        return PageFactory.initElements(driver, JobPage.class);
    }
}
