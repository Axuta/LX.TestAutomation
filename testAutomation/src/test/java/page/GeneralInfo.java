package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GeneralInfo {
    protected WebDriver driver;

    @FindBy(xpath = "//section[@id='general-info']/div/div[1]/div[1]/div/input")
    private WebElement firstName;

    @FindBy(xpath = "//section[@id='general-info']/div/div[1]/div[2]/div/input")
    private WebElement lastName;

    @FindBy(xpath = "//section[@id='general-info']/div/div[2]/div/div/input")
    private WebElement jobTitle;

    public GeneralInfo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstName() {
        return firstName.getAttribute("value");
    }

    public void setFirstName(WebElement firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName.getAttribute("value");
    }

    public String getJobTitle() {
        return jobTitle.getAttribute("value");
    }

    public List<String> fillInGeneralInfo(String name, String surname, String job) {

        clearInputField(firstName);
        firstName.sendKeys(name);

        clearInputField(lastName);
        lastName.sendKeys(surname);

        clearInputField(jobTitle);
        jobTitle.sendKeys(job);

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions
                        .attributeToBe(jobTitle,"value","Testing God"));

        ArrayList<String> initialFields = new ArrayList<>();
        initialFields.add(getFirstName());
        initialFields.add(getLastName());
        initialFields.add(getJobTitle());

        return initialFields;
    }

    public void clearInputField(WebElement field) {
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
    }
}