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

    public void fillInLanguageSkills(Map<String, List<String>> langMap) {
        for (int i = 0; i < langMap.size(); i++) {

            WebElement lastLanguageNameField = languageNameFields.getLast();


        }
    }

    public void deleteLanguage(String text) {
        for (int i = 0; i < languageNameFields.size(); i++) {
            WebElement skillField = languageNameFields.get(i);
            if (skillField.getAttribute("value").contains(text)) {
                deleteLanguageButton.get(i).click();
            }

            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions
                            .invisibilityOfElementWithText(
                                    By.xpath("//input[contains(@placeholder, 'Language')]"),
                                    text));
        }
    }

    public List<String> getLangNames() {
        List<String> langNames = new ArrayList<>();
        for (WebElement lang : languageNameFields) {
            langNames.add(lang.getAttribute("value"));
        }
        return langNames;
    }

    public List<String> getLangLevels() {
        List<String> langLevels = new ArrayList<>();
        for (WebElement level : languageLevelFields) {
            langLevels.add(level.getAttribute("value"));
        }
        return langLevels;
    }

    public boolean isLanguagePresent(String keys) {
        for (WebElement lang : languageNameFields) {
            if (lang.getAttribute("value").equals(keys)) {
                return true;
            }
        }
        return false;
    }
}
