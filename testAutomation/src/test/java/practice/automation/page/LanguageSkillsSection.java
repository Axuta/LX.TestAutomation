package practice.automation.page;

import org.openqa.selenium.By;
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
import java.util.Map;

public class LanguageSkillsSection extends MainPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[@id='language-skills']/header/div[2]/button")
    private WebElement addLanguageButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Language')]")
    private List<WebElement> languageNameFields;

    @FindBy(xpath = "//input[contains(@placeholder, 'Level')]")
    private List<WebElement> languageLevelFields;

    @FindBy(xpath = "//*[@id='language-skills']/div/div//button")
    private List<WebElement> deleteLanguageButton;

    public LanguageSkillsSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInLanguageSkills(Map<String, List<String>> testedLanguageMap) {

        for (List<String> languageInfo : testedLanguageMap.values()) {
            WebElement lastLanguageNameField = languageNameFields.getLast();
            lastLanguageNameField.sendKeys(languageInfo.get(1));
            lastLanguageNameField.sendKeys(Keys.ENTER);

            WebElement lastLanguageLevelField = languageLevelFields.getLast();
            lastLanguageLevelField.sendKeys(languageInfo.get(0));
            lastLanguageLevelField.sendKeys(Keys.ENTER);

            addLanguageButton.click();
        }

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(
                                By.xpath("//*[@id='education']/div//input"),
                                testedLanguageMap.size() - 1));

        for (int i = 0; i < languageNameFields.size(); i++) {
            if (languageNameFields.get(i)
                    .getAttribute("value")
                    .isEmpty()) {
                deleteLanguageButton.get(i).click();
            }
        }
    }


    public void deleteLanguage(String text) {
        for (int i = 0; i < languageNameFields.size(); i++) {
            WebElement languageField = languageNameFields.get(i);
            if (languageField.getAttribute("value").contains(text)) {
                deleteLanguageButton.get(i).click();
            }

            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions
                            .invisibilityOfElementWithText(
                                    By.xpath("//input[contains(@placeholder, 'Language')]"),
                                    text));
        }
    }

    public List<String> getLanguageNames() {
        List<String> languageNames = new ArrayList<>();
        for (WebElement language : languageNameFields) {
            languageNames.add(language.getAttribute("value"));
        }
        return languageNames;
    }

    public List<String> getLanguageLevels() {
        List<String> languageLevels = new ArrayList<>();
        for (WebElement level : languageLevelFields) {
            languageLevels.add(level.getAttribute("value"));
        }
        return languageLevels;
    }

    public boolean isLanguagePresent(String keys) {
        for (WebElement language : languageNameFields) {
            if (language.getAttribute("value").equals(keys)) {
                return true;
            }
        }
        return false;
    }
}
