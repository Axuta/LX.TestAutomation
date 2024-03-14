package practice.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import practice.automation.model.TestData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GeneralInfoSection extends MainPage {

    protected WebDriver driver;

    @FindBy(xpath = "//section[@id='general-info']/div/div[1]/div[1]/div/input")
    private WebElement firstName;

    @FindBy(xpath = "//section[@id='general-info']/div/div[1]/div[2]/div/input")
    private WebElement lastName;

    @FindBy(xpath = "//section[@id='general-info']/div/div[2]/div/div/input")
    private WebElement jobTitle;

    public GeneralInfoSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstName() {
        return firstName.getAttribute("value");
    }

    public String getLastName() {
        return lastName.getAttribute("value");
    }

    public String getJobTitle() {
        return jobTitle.getAttribute("value");
    }

    public List<String> fillInGeneralInfo(TestData testData) {

        clearInputField(firstName);
        firstName.sendKeys(testData.getName());

        clearInputField(lastName);
        lastName.sendKeys(testData.getSurname());

        clearInputField(jobTitle);
        jobTitle.sendKeys(testData.getJobTitle());

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions
                        .attributeToBe(jobTitle, "value", ""));

        ArrayList<String> initialFields = new ArrayList<>();
        initialFields.add(getFirstName());
        initialFields.add(getLastName());
        initialFields.add(getJobTitle());

        return initialFields;
    }

}