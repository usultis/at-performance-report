package com.usulful.jenkins.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class JobPage {

    private WebDriver driver;
    @FindBy(linkText = "Build Now")
    private WebElement buildNow;

    public JobPage(WebDriver driver) {
        this.driver = driver;
    }

    public JobPage buildNow() {
        buildNow.click();
        return this;
    }

    public BuildConsolePage openConsole() {
        driver.findElement(By.className("tip")).click();
        driver.findElement(By.linkText("Console Output")).click();
        return PageFactory.initElements(driver, BuildConsolePage.class);
    }

    public PerformanceReportPage performanceTrend() {
        driver.findElement(By.linkText("Performance Trend")).click();
        return PageFactory.initElements(driver, PerformanceReportPage.class);
    }

    public JobPage assertTitleContains(final String titlePart) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains(titlePart));
        return this;
    }
}
