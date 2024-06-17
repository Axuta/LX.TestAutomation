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

public class TrainingsSection extends MainPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[@id='trainings']/header/div[2]/button[2]")
    private WebElement hideOrShowTrainingsButton;

    @FindBy(xpath = "//*[@id='trainings']/header/div[2]/button[1]")
    private WebElement addTrainingButton;

    @FindBy(xpath = "//*[@id='trainings']/div//input")
    private List<WebElement> trainingsTextFields;

    @FindBy(xpath = "//*[@id='trainings']/div//button")
    private List<WebElement> deleteTrainingButton;

    public TrainingsSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hideTrainings() {
        hideOrShowTrainingsButton.click();
    }

    public void showTrainings(){
        hideOrShowTrainingsButton.click();
    }

    public WebElement getAddTrainingButton() {
        return addTrainingButton;
    }

    public void fillInTrainingsSection(List<String> testedTrainings) {
        for (String training : testedTrainings) {
            WebElement lastTrainingField = trainingsTextFields.getLast();
            lastTrainingField.sendKeys(training);

            addTrainingButton.click();
        }

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(
                                By.xpath("//*[@id='trainings']/div//input"),
                                testedTrainings.size() - 1));

        for (int i = 0; i < trainingsTextFields.size(); i++) {
            if (trainingsTextFields.get(i)
                    .getAttribute("value")
                    .isEmpty()) {
                deleteTrainingButton.get(i).click();
            }
        }
    }

    public void deleteTraining(String text) {
        for (int i = 0; i < trainingsTextFields.size(); i++) {
            WebElement trainingField = trainingsTextFields.get(i);
            if (trainingField.getAttribute("value").contains(text)) {
                deleteTrainingButton.get(i).click();
            }

            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions
                            .invisibilityOfElementWithText(
                                    By.xpath("//*[@id='trainings']/div//input"),
                                    text));
        }
    }

    public List<String> getTrainings() {
        List<String> trainings = new ArrayList<>();
        for (WebElement training : trainingsTextFields) {
            trainings.add(training.getAttribute("value"));
        }
        return trainings;
    }

    public boolean isTrainingPresent(String keys) {
        for (WebElement training : trainingsTextFields) {
            if (training.getAttribute("value").equals(keys)) {
                return true;
            }
        }
        return false;
    }
}
