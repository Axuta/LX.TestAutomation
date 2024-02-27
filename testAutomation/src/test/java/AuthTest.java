import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import automation.Auth;

public class AuthTest {

    @Test
    public void authTest() {
        WebDriver chromeDriver = new ChromeDriver();
        Auth.authDriver(chromeDriver);
    }
}
