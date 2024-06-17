package practice.automation.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import practice.automation.driver.DriverSingleton;

public class CommonConditions {
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
