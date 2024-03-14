package practice.automation.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.TestData;
import practice.automation.model.User;
import practice.automation.page.LogInPage;
import practice.automation.page.OverviewSection;
import practice.automation.service.TestDataCreator;
import practice.automation.service.UserCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverviewTest extends CommonConditions {

    TestData testData;
    private OverviewSection overviewFields;
    private String testedOverviewText;
    private String expectedOverviewText;
    private List<WebElement> testedSkillSet;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = TestDataCreator.forGeneralInfo();

        overviewFields = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageOverview();
    }

    @Test
    public void testFillInOverviewMainTextArea() {
        testedOverviewText = overviewFields
                .fillInOverviewMainTextArea(testData.getOverview());

        expectedOverviewText = overviewFields.getOverviewTextArea();

        Assert.assertEquals(testedOverviewText, expectedOverviewText, "Overview contains wrong text.");
    }

    @Test
    void testBeautifyOverviewButton() {

        String notBeautifiedOverview = overviewFields.getOverviewTextArea();
        String beautifiedOverview = overviewFields.beautifyOverviewMainTextArea(expectedOverviewText);

        Assert.assertNotEquals(beautifiedOverview, notBeautifiedOverview, "Overview was not beautified.");
    }


    @Test
    public void testFillInSkills() {
        List<String> testedSkillSet = new ArrayList<>(Arrays.asList(testData.getSkillSet().split(";;")));

        String expectedSkillNo2 = overviewFields.getSkill(2);

        Assert.assertEquals(testedSkillSet.get(2), expectedSkillNo2, "Overview contains wrong skill set");
    }

    @Test
    public void testDeleteSkill() {
        String keys = testData.getWrongSkill();
        List<WebElement> redactedSkillSet = overviewFields
                .deleteSkill(testedSkillSet, keys);

        Assert.assertNotEquals(testedSkillSet.get(2), redactedSkillSet.get(2).getAttribute("value"), "Required skill was not removed.");
    }
}