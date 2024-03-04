package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GeneralInfo;
import page.LogInPage;

import java.util.List;

public class GeneralInfoTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void firstNameIsRightName() {
         String expectedFirstName = new LogInPage(driver)
                .openPage()
                .loginValidUser("test.liavonava@leverx.com","pa$sw0rd")
                        .fillInGeneralInfo("John","Doe","Testing God")
                 .get(0);

        Assert.assertEquals(expectedFirstName, "John", "General info contains wrong name.");
    }

    @Test
    public void lastNameIsRightSurname() {
        String expectedLastName = new LogInPage(driver)
                .openPage()
                .loginValidUser("test.liavonava@leverx.com","pa$sw0rd")
                .fillInGeneralInfo("John","Doe","Testing God")
                .get(1);

        Assert.assertEquals(expectedLastName, "Doe", "General info contains wrong surname.");
    }

    @Test
    public void JobTitleIsRightTitle() {
        String expectedJobTitle = new LogInPage(driver)
                .openPage()
                .loginValidUser("test.liavonava@leverx.com","pa$sw0rd")
                .fillInGeneralInfo("John","Doe","Testing God")
                .get(2);

        Assert.assertEquals(expectedJobTitle, "Testing God", "General info contains wrong job title.");
    }
}