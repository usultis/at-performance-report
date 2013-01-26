package com.usulful.jenkins.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.usulful.selenium.WebDriverPredicates.pageSourceContains;

public class PerformanceReportPage {
    private WebDriver driver;


    public PerformanceReportPage(WebDriver driver) {
        this.driver = driver;
    }

    public PerformanceReportPage clickLastReport() {
        driver.findElement(By.linkText("Last Report")).click();
        return this;
    }

    public PerformanceReportPage assertHasEntry(final String text) {
        new WebDriverWait(driver,5).until(pageSourceContains(text));
        return this;
    }

    /**
     * just for the end user to see the results, that they are there
     */
    public PerformanceReportPage wait5Seconds() throws InterruptedException {
        Thread.sleep(5000);
        return this;
    }
}
