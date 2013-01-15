package com.usulful.jenkins.test;

import com.usulful.jenkins.page.MainPage;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PerformanceIntegrationTest {

    public static final String MAIN_URL = "http://localhost:9080/";
    private WebDriver driver;

    @Test
    public void shouldShowPerformanceOfJenkinsAts() {
        openMainPage()
                .clickNewJob()
                .enterJobName("Jenkins_Acceptance_Tests")
                .freestyleBuild()
                .clickOK()
                        //job configuration
                .scm("Git")
                .enter("git.repo.url", "https://github.com/usultis/at-performance-report.git")
                .addBuildStep("Invoke top-level Maven targets")
                .goals("verify")
                .save()
                        //main page
                .openJob("Jenkins_Acceptance_Tests")
                .buildNow()
                .openConsole()
                .waitForBuildToFinish()
                .backToProject()
                .performanceReport();
    }

    private MainPage openMainPage() {
        return mainPage();
    }

    private MainPage mainPage() {
        driver.get(MAIN_URL);
        return PageFactory.initElements(driver, MainPage.class);
    }

    @Before
    public void before() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void after() throws IOException {
        HttpPost delete = new HttpPost(MAIN_URL + "job/Jenkins_Acceptance_Tests/doDelete");
        new DefaultHttpClient().execute(delete);
        driver.close();
    }
}
