package practice.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfessionalExperienceSection extends MainPage {

    protected WebDriver driver;

    public ProfessionalExperienceSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
