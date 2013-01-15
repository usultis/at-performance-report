package com.usulful.jenkins.test;

import com.usulful.jenkins.page.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class PerformanceIntegrationTest {

    private WebDriver driver;
    @Test
    public void shouldShowPerformanceOfJenkinsAts() {
        openMainPage()
                .clickNewJob()
                .enterJobName("Jenkins Acceptance Tests")
                .freestyleBuild()
                .clickOK()

                .scm("Git")
                .enter("git.repo.url","");
    }
    private MainPage openMainPage() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:9080/");
        return PageFactory.initElements(driver, MainPage.class);
    }

    @Before
    public void before() {
        driver = new FirefoxDriver();
    }

    @After
    public void after() {
        driver.close();
    }
}
