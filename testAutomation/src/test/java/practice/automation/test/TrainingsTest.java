package practice.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.TestData;
import practice.automation.model.User;
import practice.automation.page.LogInPage;
import practice.automation.page.TrainingsSection;
import practice.automation.service.TestDataCreator;
import practice.automation.service.UserCreator;

import java.util.List;

@Test(priority = 7)
public class TrainingsTest extends CommonConditions {

    private TestData testData;
    private TrainingsSection trainingsFields;

    @BeforeClass(alwaysRun = true)
    public void testsSetUp() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = TestDataCreator.forEducation();

        trainingsFields = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageTrainings();
    }

    @Test(priority = 1)
    public void testHideTrainings() {
        trainingsFields.hideTrainings();

        Assert.assertFalse(trainingsFields.getAddTrainingButton().isEnabled(),
                "Trainings were not hidden.\n");
    }

    @Test(priority = 2)
    public void testShowTrainings() {
        trainingsFields.showTrainings();

        Assert.assertTrue(trainingsFields.getAddTrainingButton().isEnabled(),
                "Trainings were not shown.\n");
    }

    @Test(priority = 3)
    public void testFillInTrainingsSection() {
        List<String> testedTrainings = testData.getTrainings();
        trainingsFields
                .fillInTrainingsSection(testedTrainings);

        List<String> expectedTrainings = trainingsFields.getTrainings();

        Assert.assertEquals(
                testedTrainings.getLast(),
                expectedTrainings.getLast(),
                "Trainings contains wrong text.");
    }

    @Test(priority = 4)
    public void testDeleteTraining() {
        String withText = testData.getTrainingToDelete();
        trainingsFields
                .deleteTraining(withText);

        Assert.assertFalse(
                trainingsFields.isTrainingPresent(withText),
                "Required education was not removed.");
    }

}