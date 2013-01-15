package com.usulful.jenkins.page;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.usulful.selenium.WebElementPredicates.withText;

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

    public PerformanceReportPage performanceReport() {
        driver.findElement(By.linkText("Performance report")).click();
        return PageFactory.initElements(driver, PerformanceReportPage.class);
    }
}
