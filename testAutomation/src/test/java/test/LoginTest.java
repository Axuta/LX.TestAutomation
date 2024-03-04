package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.LogInPage;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void authorizationIsWorking() {
         String expectedResults = new LogInPage(driver)
                .openPage()
                .loginValidUser("test.liavonava@leverx.com","pa$sw0rd")
                 .getFirstName();
        Assert.assertEquals(expectedResults,
                "Test",
                "Authorization is not working.");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
