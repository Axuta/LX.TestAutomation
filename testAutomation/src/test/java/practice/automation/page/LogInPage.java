package practice.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import practice.automation.model.User;

import java.time.Duration;

public class LogInPage {
    private static final String LOGINPAGE_URL = "https://dev.cvb.codeprime.dev/cv/";
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id='app']/div/form/div[1]/input")
    private WebElement eMail;

    @FindBy(xpath = "//*[@id='app']/div/form/div[2]/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id='app']/div/form/button")
    private WebElement loginButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LogInPage openPage() {
        driver.navigate().to(LOGINPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        return this;
    }

    public MainPage loginValidUser(User user) {
        eMail.sendKeys(user.getEMail());
        this.password.sendKeys(user.getPassword());
        loginButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='general-info']")));
        return new MainPage(driver);
    }

}
