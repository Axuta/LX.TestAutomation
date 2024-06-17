package practice.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.TestData;
import practice.automation.model.User;
import practice.automation.page.EducationSection;
import practice.automation.page.LogInPage;
import practice.automation.service.TestDataCreator;
import practice.automation.service.UserCreator;

import java.util.List;

@Test(priority = 4)
public class EducationTest extends CommonConditions {
    TestData testData;
    private EducationSection educationFields;

    @BeforeClass(alwaysRun = true)
    public void testsSetUp() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = TestDataCreator.forEducation();

        educationFields = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageEducation();
    }

    @Test(priority = 1)
    public void testFillInEducationArea() {
        List<String> testedEducations = testData.getEducations();
        educationFields
                .fillInEducationSection(testedEducations);

        List<String> expectedEducations = educationFields.getEducations();

        Assert.assertEquals(
                testedEducations.getLast(),
                expectedEducations.getLast(),
                "Educations contains wrong text.");

    }

    @Test(priority = 2)
    public void testDeleteSkill() {
        String withText = testData.getEducationToDelete();
        educationFields
                .deleteEducation(withText);

        Assert.assertFalse(
                educationFields.isEducationPresent(withText),
                "Required education was not removed.");
    }
}
