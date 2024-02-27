package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Auth {
    public static void authDriver(WebDriver driver) {
        driver.get("https://dev.cvb.codeprime.dev/cv/");

        WebElement authMail = driver.findElement(By.xpath("//*[@id='app']/div/form/div[1]/input"));
        authMail.sendKeys("test.liavonava@leverx.com");
        WebElement authPassword = driver.findElement(By.xpath("//*[@id='app']/div/form/div[2]/input"));
        authPassword.sendKeys("pa$sw0rd");

        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='app']/div/form/button"));
        loginBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='rbd-hidden-text-6-hidden-text-18']")));
    }
}
