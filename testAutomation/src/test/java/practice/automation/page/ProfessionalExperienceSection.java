package practice.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProfessionalExperienceSection extends MainPage {

    protected WebDriver driver;

    @FindBy(xpath = "//section[@id='professional-experience']//input[contains(@placeholder, 'Customer')]")
    private List<WebElement> customer;

    @FindBy(xpath = "//section[@id='professional-experience']//input[contains(@placeholder, 'Role')]")
    private List<WebElement> role;

    @FindBy(xpath = "//section[@id='professional-experience']/div/section[2]//input")
    private List<WebElement> dateSection;
//
//    @FindBy(xpath = "")
//    private List<WebElement> startDate;
//
//    @FindBy(xpath = "")
//    private List<WebElement> endDate;

    @FindBy(xpath = "//section[@id='professional-experience']/div/section[2]/span/label/input")
    private List<WebElement> endDateSwitchButton;

    @FindBy(xpath = "//section[@id='professional-experience']//input[contains(@placeholder, 'Project description')]")
    private List<WebElement> description;

    @FindBy(xpath = "//section[@id='professional-experience']//input[contains(@placeholder, 'Responsibility')]")
    private List<WebElement> responsibilities;
    //section[@id='professional-experience']/div[1]/section[4]/div//input
    //section[@id='professional-experience']/div[2]/section[4]/div//input

    @FindBy(xpath = "//section[@id='professional-experience']//input[contains(@placeholder, 'Tools and technologies')]")
    private List<WebElement> tools;

    public ProfessionalExperienceSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInProjectsFields(List<Map<String, String>> ofProjects) {

    }

    public List<Map<String, String>> getProject() {
        List<Map<String, String>> projectMap = new ArrayList<>();

        for (int i = 0; i < customer.size(); i++) {
            Map<String, String> project = new LinkedHashMap<>();
            project.put("customer", customer.get(i).getText());
            project.put("role", role.get(i).getText());
//            project.put("startDate", startDate.get(i).getText());
//            project.put("endDate", endDate.get(i).getText());
            project.put("description", description.get(i).getText());
            project.put("responsibility", responsibilities.get(i).getText());
            project.put("tools", tools.get(i).getText());

            projectMap.add(project);

        }
        return projectMap;
    }
}
