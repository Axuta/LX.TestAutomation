package practice.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.TestData;
import practice.automation.model.User;
import practice.automation.page.LogInPage;
import practice.automation.page.OverviewSection;
import practice.automation.service.TestDataCreator;
import practice.automation.service.UserCreator;

import java.util.List;

public class OverviewTest extends CommonConditions {

    TestData testData;
    private OverviewSection overviewFields;
    private List<String> testedSkillSet;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = TestDataCreator.forOverview();

        overviewFields = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageOverview();
    }

    @Test
    public void testFillInOverviewMainTextArea() {
        String testedOverviewText = testData.getOverview();
        overviewFields
                .fillInOverviewMainTextArea(testedOverviewText);

        String expectedOverviewText = overviewFields
                .getOverviewTextArea();

        Assert.assertEquals(expectedOverviewText, testedOverviewText,
                "Overview contains wrong text.");
    }

    @Test
    void testBeautifyOverviewButton() {
        String notBeautifiedOverview = overviewFields
                .getOverviewTextArea();
        String beautifiedOverview = overviewFields
                .beautifyOverviewMainTextArea();

        Assert.assertNotEquals(beautifiedOverview, notBeautifiedOverview,
                "Overview was not beautified.");
    }

    @Test
    public void testFillInSkills() {
        testedSkillSet = testData.getSkillSet();
        overviewFields
                .fillInSkills(testedSkillSet);

        String expectedSkillNo2 = overviewFields.getSkill(2);

        Assert.assertEquals(testedSkillSet.get(2), expectedSkillNo2,
                "Overview contains wrong skill set");
    }

    @Test
    public void testDeleteSkill() {
        String keys = testData.getSkillToDelete();
        overviewFields
                .deleteSkill(keys);

        String expectedSkillNo2 = overviewFields.getSkill(2);


        Assert.assertNotEquals(testedSkillSet.get(2), expectedSkillNo2, "Required skill was not removed.");
    }
}