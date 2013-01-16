package com.usulful.jenkins.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerformanceReportPage {
    private WebDriver driver;


    public PerformanceReportPage(WebDriver driver) {
        this.driver = driver;
    }

    public PerformanceReportPage clickLastReport() {
        driver.findElement(By.linkText("Last Report")).click();
        return this;
    }
}
