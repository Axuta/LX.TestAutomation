package practice.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.TestData;
import practice.automation.model.User;
import practice.automation.page.LogInPage;
import practice.automation.service.TestDataCreator;
import practice.automation.service.UserCreator;

import java.util.List;

public class GeneralInfoTest extends CommonConditions {

    TestData testData;
    List<String> expectedResults;

    @BeforeClass
    public void setUpMethod() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = TestDataCreator.forGeneralInfo();

        expectedResults = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageGeneralInfo()
                .fillInGeneralInfo(testData);
    }

    @Test
    public void firstNameIsRightName() {
        String expectedFirstName = expectedResults.get(0);
        String testedFirstName = testData.getFirstName();

        Assert.assertEquals(expectedFirstName, testedFirstName, "General info contains wrong name.");
    }

    @Test
    public void lastNameIsRightSurname() {
        String expectedLastName = expectedResults.get(1);
        String testedLastName = testData.getLastName();

        Assert.assertEquals(expectedLastName, testedLastName, "General info contains wrong surname.");
    }

    @Test
    public void JobTitleIsRightTitle() {
        String expectedJobTitle = expectedResults.get(2);
        String testedJobTitle = testData.getJobTitle();

        Assert.assertEquals(expectedJobTitle, testedJobTitle, "General info contains wrong job title.");
    }
}