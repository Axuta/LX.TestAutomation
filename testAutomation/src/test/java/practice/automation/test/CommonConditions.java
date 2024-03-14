package practice.automation.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import practice.automation.driver.DriverSingleton;

public class CommonConditions {
    protected WebDriver driver;
//    protected static final String USER_MAIL = "test.liavonava@leverx.com";
//    protected static final String USER_PASSWORD = "pa$sw0rd";
//    private static final String RESOURCES_PATH = "src\\test\\resources\\";

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
        driver = null;
    }
}
