package practice.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.User;
import practice.automation.page.LogInPage;
import practice.automation.service.GeneralInfo;
import practice.automation.service.UserCreator;

import java.util.List;

@Test(priority = 1)
public class GeneralInfoTest extends CommonConditions {

    List<String> generalInfoFields;
    private GeneralInfo testData;

    @BeforeClass(alwaysRun = true)
    public void testsSetUp() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = new GeneralInfo();

        generalInfoFields = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageGeneralInfo()
                .fillInGeneralInfo(testData);
    }

    @Test
    public void firstNameIsRightName() {
        String expectedFirstName = testData.getFirstName();
        String actualFirstName = generalInfoFields.get(0);

        Assert.assertEquals(actualFirstName, expectedFirstName, "General info contains wrong name.");
    }

    @Test
    public void lastNameIsRightSurname() {
        String expectedLastName = testData.getLastName();
        String actualLastName = generalInfoFields.get(1);

        Assert.assertEquals(actualLastName, expectedLastName, "General info contains wrong surname.");
    }

    @Test
    public void JobTitleIsRightTitle() {
        String expectedJobTitle = testData.getJobTitle();
        String actualJobTitle = generalInfoFields.get(2);

        Assert.assertEquals(actualJobTitle, expectedJobTitle, "General info contains wrong job title.");
    }
}