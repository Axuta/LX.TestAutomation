package practice.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public String getOverviewTextArea() {
        return overviewTextArea.getAttribute("value");
    }

    public void fillInOverviewMainTextArea(String withText) {
        clearInputField(overviewTextArea);
        overviewTextArea.sendKeys(withText);

        getOverviewTextArea();
    }

    public String beautifyOverviewMainTextArea() {
        beautifyButton.click();

        return getOverviewTextArea();
    }

    public void fillInSkills(List<String> skillSet) {
        for (String skill : skillSet) {
            WebElement lastSkillField = skills.getLast();
            lastSkillField.sendKeys(skill);

            addSkillButton.click();
        }
    }

    public void deleteSkill(String keys) {
        int i = 0;
        do {
            WebElement skillField = skills.get(i);
            if (skillField
                    .getAttribute("value")
                    .contains(keys)) {
                deleteSkillButton.get(i).click();
            }
            i++;
        } while (i < skills.size());

    }

    public String getSkill(int skillNumber) {
        if (skillNumber >= 0 && skillNumber < skills.size()) {
            return skills.get(skillNumber).getAttribute("value");
        } else {
            throw new IllegalArgumentException("Invalid skill number");
        }
    }
}
