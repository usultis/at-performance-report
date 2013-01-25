package com.usulful.jenkins.page;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuildConsolePage {
    private WebDriver driver;
    @FindBy(linkText = "Back to Project")
    private WebElement backToProject;

    public BuildConsolePage(WebDriver driver) {
        this.driver = driver;
    }

    public JobPage backToProject() {
        backToProject.click();
        return PageFactory.initElements(driver, JobPage.class);
    }

    public BuildConsolePage waitForBuildToFinish() {
        new WebDriverWait(driver, 300).until(pageSourceContains("Finished: "));
        return this;
    }

    private Predicate<WebDriver> pageSourceContains(final String text) {
        return new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver webDriver) {
                return webDriver.getPageSource().contains(text);
            }
        };
    }
}
