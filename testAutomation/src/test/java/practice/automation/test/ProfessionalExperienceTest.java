package practice.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.User;
import practice.automation.page.LogInPage;
import practice.automation.page.ProfessionalExperienceSection;
import practice.automation.service.ProfessionalExperience;
import practice.automation.service.UserCreator;

import java.util.List;
import java.util.Map;

@Test(priority = 3)
public class ProfessionalExperienceTest extends CommonConditions {

    ProfessionalExperience testData;
    private ProfessionalExperienceSection projectsFields;

    @BeforeClass(alwaysRun = true)
    public void testsSetUp() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = new ProfessionalExperience();

        projectsFields = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageProfessionalExperience();
    }

    @Test
    public void testFillInProjectsFields() {
        List<Map<String, String>> testedProjectsFields = testData.getProjectsInformation();
        projectsFields
                .fillInProjectsFields(testedProjectsFields);

        String expectedCustomer = testData.getCustomer().get(0);
        String expectedRole = testData.getRole().get(1);
        String expectedStartDate = testData.getStartDate().get(0);
        String expectedEndDate = testData.getEndDate().get(1);
        String expectedDescription = testData.getDescription().get(0);
        String expectedResponsibilities = testData.getResponsibility().get(1);
        String expectedTools = testData.getTools().get(0);

        String actualCustomer = projectsFields.getProject().get(0).get("customer");
        String actualRole = projectsFields.getProject().get(1).get("role");
        String actualStartDate = projectsFields.getProject().get(0).get("startDate");
        String actualEndDate = projectsFields.getProject().get(1).get("endDate");
        String actualDescription = projectsFields.getProject().get(0).get("description");
        String actualResponsibilities = projectsFields.getProject().get(1).get("responsibility");
        String actualTools = projectsFields.getProject().get(0).get("tools");

        Assert.assertEquals(actualCustomer, expectedCustomer,
                "W R O N G");
        Assert.assertEquals(actualRole, expectedRole,
                "W R O N G");
        Assert.assertEquals(actualStartDate, expectedStartDate,
                "W R O N G");
        Assert.assertEquals(actualEndDate, expectedEndDate,
                "W R O N G");
        Assert.assertEquals(actualDescription, expectedDescription,
                "W R O N G");
        Assert.assertEquals(actualResponsibilities, expectedResponsibilities,
                "W R O N G");
        Assert.assertEquals(actualTools, expectedTools,
                "W R O N G");
    }
}