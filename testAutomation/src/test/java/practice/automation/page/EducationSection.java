package practice.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EducationSection extends MainPage {

    protected WebDriver driver;

    @FindBy(xpath = "//*[@id='education']/header/div[2]/button")
    private WebElement addEducationButton;

    @FindBy(xpath = "//*[@id='education']/div//input")
    private List<WebElement> educationTextFields;

    @FindBy(xpath = "//*[@id='education']/div//button")
    private List<WebElement> deleteEducationButton;

    public EducationSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInEducationSection(List<String> testedEducations) {
        for (String edu : testedEducations) {
            WebElement lastEducationField = educationTextFields.getLast();
            lastEducationField.sendKeys(edu);

            addEducationButton.click();
        }

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(
                                By.xpath("//*[@id='education']/div//input"),
                                testedEducations.size() - 1));

        for (int i = 0; i < educationTextFields.size(); i++) {
            if (educationTextFields.get(i)
                    .getAttribute("value")
                    .isEmpty()) {
                deleteEducationButton.get(i).click();
            }
        }
    }

    public void deleteEducation(String text) {
        for (int i = 0; i < educationTextFields.size(); i++) {
            WebElement skillField = educationTextFields.get(i);
            if (skillField.getAttribute("value").contains(text)) {
                deleteEducationButton.get(i).click();
            }

            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions
                            .invisibilityOfElementWithText(
                                    By.xpath("//*[@id='education']/div//input"),
                                    text));
        }
    }

    public List<String> getEducations() {
        List<String> educations = new ArrayList<>();
        for (WebElement edu : educationTextFields) {
            educations.add(edu.getAttribute("value"));
        }
        return educations;
    }

    public boolean isEducationPresent(String keys) {
        for (WebElement edu : educationTextFields) {
            if (edu.getAttribute("value").equals(keys)) {
                return true;
            }
        }
        return false;
    }
}
