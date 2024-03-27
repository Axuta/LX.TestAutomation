package practice.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OverviewSection extends MainPage {

    protected WebDriver driver;

    @FindBy(xpath = "//section[@id='overview']/div[1]/div/textarea")
    private WebElement overviewTextArea;

    @FindBy(xpath = "//section[@id='overview']/div[1]/header/button")
    private WebElement beautifyButton;

    @FindBy(xpath = "//section[@id='overview']/header[2]/button")
    private WebElement addSkillButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Skill')]")
    private List<WebElement> skills;

    @FindBy(xpath = "//*[@id='overview']/div[2]//button")
    private List<WebElement> deleteSkillButton;

    public OverviewSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOverviewText() {
        return overviewTextArea.getAttribute("value");
    }

    public void fillInOverviewMainTextArea(String withText) {
        clearInputField(overviewTextArea);
        overviewTextArea.sendKeys(withText);
    }

    public String beautifyOverviewMainTextArea() {
        beautifyButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='overview']/div[1]/header/button[2]")));

        return getOverviewText();
    }

    public void fillInSkills(List<String> skillSet) {
        for (String skill : skillSet) {
            WebElement lastSkillField = skills.getLast();
            lastSkillField.sendKeys(skill);

            addSkillButton.click();
        }

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.xpath("//*[@id='overview']/div[2]//input"),
                                skillSet.size() - 1));

        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i)
                    .getAttribute("value")
                    .isEmpty()) {
                deleteSkillButton.get(i).click();
            }
        }
    }

    public void deleteSkill(String keys) {
        for (int i = 0; i < skills.size(); i++) {
            WebElement skillField = skills.get(i);
            if (skillField.getAttribute("value").contains(keys)) {
                deleteSkillButton.get(i).click();
            }

            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions
                            .invisibilityOfElementWithText(By
                                            .xpath("//*[@id='overview']/div[2]//input"),
                                    keys));
        }
    }

    public String getSkill(int skillNumber) {
        if (skillNumber >= 0 && skillNumber < skills.size()) {
            return skills.get(skillNumber).getAttribute("value");
        } else {
            throw new IllegalArgumentException("Invalid skill number");
        }
    }

    public boolean isSkillPresent(String keys) {
        for (WebElement skillField : skills) {
            if (skillField.getAttribute("value").equals(keys)) {
                return true;
            }
        }
        return false;
    }
}
