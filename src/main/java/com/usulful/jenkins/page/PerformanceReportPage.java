package com.usulful.jenkins.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertTrue;

public class PerformanceReportPage {
    private WebDriver driver;


    public PerformanceReportPage(WebDriver driver) {
        this.driver = driver;
    }

    public PerformanceReportPage clickLastReport() {
        driver.findElement(By.linkText("Last Report")).click();
        return this;
    }

    public PerformanceReportPage assertHasEntry(final String entry) {
        assertTrue("Page does not contain entry: " + entry, driver.getPageSource().contains(entry));
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
