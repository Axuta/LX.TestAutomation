package practice.automation.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public GeneralInfoSection manageGeneralInfo() {
        return new GeneralInfoSection(driver);
    }

    public OverviewSection manageOverview() {
        return new OverviewSection(driver);
    }

    public ProfessionalExperienceSection manageProfessionalExperience() {
        return new ProfessionalExperienceSection(driver);
    }

    public EducationSection manageEducation() {
        return new EducationSection(driver);
    }

    public LanguageSkillsSection manageLanguageSkills() {
        return new LanguageSkillsSection(driver);
    }

    public CertificationsSection manageCertifications(){
        return new CertificationsSection(driver);
    };

    public TrainingsSection manageTrainings() {
        return new TrainingsSection(driver);
    };

    public PersonalStrengthsSection managePersonalStrengths() {
        return new PersonalStrengthsSection(driver);
    }

    public void clearInputField(WebElement field) {
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
    }
}
