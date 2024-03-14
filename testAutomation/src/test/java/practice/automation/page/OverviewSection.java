package practice.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverviewSection extends MainPage {

    protected WebDriver driver;

    private int skillNumber;
    private String skillInputLocator = "//*[@id='overview']/div[2]/div[" + skillNumber + "]/div/div[2]/div/input";
    private String skillDeleteButtonLocator = "//*[@id='overview']/div[2]/div[" + skillNumber + "]/div/button";

    @FindBy(xpath = "//section[@id='overview']/div[1]/div/textarea")
    private WebElement overviewTextArea;

    @FindBy(xpath = "//section[@id='overview']/div[1]/header/button")
    private WebElement beautifyButton;

    @FindBy(xpath = "//section[@id='overview']/header[2]/button")
    private WebElement addSkillButton;

    private By skillsBy = By.xpath(skillInputLocator);
    private By deleteSkillButtonBy = By.xpath(skillDeleteButtonLocator);
    private List<WebElement> skills;

    public OverviewSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOverviewTextArea() {
        return overviewTextArea.getAttribute("value");
    }

    public String getSkill(int skillNumber) {
        return skills.get(skillNumber-1).
                getAttribute("value");
    }

    public WebElement deleteSkillButton(int skillNumber) {
        return driver.findElement(deleteSkillButtonBy);
    }

    public String fillInOverviewMainTextArea(String withText) {
        clearInputField(overviewTextArea);
        overviewTextArea.sendKeys(withText);

        return getOverviewTextArea();
    }

    public String beautifyOverviewMainTextArea(String withText) {
        beautifyButton.click();

        return getOverviewTextArea();
    }

    public List<WebElement> fillInSkills(String listOfSkills) {
        List<String> skillSet = new ArrayList<>(Arrays.asList(listOfSkills.split(",")));
        List<WebElement> updatedSkills = new ArrayList<>();

        int i = 0;
        int numberOfSkills = skillSet.size()-1;

        while (i <= numberOfSkills) {
            clearInputField(updatedSkills.get(i));
            updatedSkills.get(i).
                    sendKeys(skillSet.get(i));
            addSkillButton.click();
            i++;
        }

        return updatedSkills;
    }

    public List<WebElement> deleteSkill(List<WebElement> skills , String keys) {
        List<WebElement> redactedSkills = new ArrayList<>();

        int i = 1;
        for (WebElement skill : skills) {
            String skillText = skill.getAttribute("value");
            if (skillText.contains(keys)) {

                deleteSkillButton(i).click();
            } else {
                redactedSkills.add(skill);
            }
            i++;
        }
        return redactedSkills;
    }

    public int getSkillNumber() {
        return skillNumber;
    }

}
