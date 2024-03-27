package practice.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.TestData;
import practice.automation.model.User;
import practice.automation.page.LogInPage;
import practice.automation.page.OverviewSection;
import practice.automation.service.TestDataCreator;
import practice.automation.service.UserCreator;

import java.time.Duration;
import java.util.List;

public class OverviewTest extends CommonConditions {

    TestData testData;
    private OverviewSection overviewFields;

    @BeforeClass(alwaysRun = true)
    public void setUpMethod() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = TestDataCreator.forOverview();

        overviewFields = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageOverview();
    }

    @Test(priority = 1)
    public void testFillInOverviewMainTextArea() {
        String testedOverviewText = testData.getOverview();
        overviewFields
                .fillInOverviewMainTextArea(testedOverviewText);

        String expectedOverviewText = overviewFields
                .getOverviewText();

        Assert.assertEquals(expectedOverviewText, testedOverviewText,
                "Overview contains wrong text.");
    }

    @Test(priority = 2)
    void testBeautifyOverviewButton() {
        String notBeautifiedOverview = overviewFields
                .getOverviewText();
        String beautifiedOverview = overviewFields
                .beautifyOverviewMainTextArea();

        Assert.assertNotEquals(beautifiedOverview, notBeautifiedOverview,
                "Overview was not beautified.");
    }

    @Test(priority = 3)
    public void testFillInSkills() {
        List<String> testedSkillSet = testData.getSkillSet();
        overviewFields
                .fillInSkills(testedSkillSet);

        String expectedSkillNo2 = overviewFields.getSkill(2);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//*[@id='overview']/div[2]//input"),
                        testedSkillSet.size()));

        Assert.assertEquals(testedSkillSet.get(2), expectedSkillNo2,
                "Overview contains wrong skill set");
    }

    @Test(priority = 4)
    public void testDeleteSkill() {
        String keys = testData.getSkillToDelete();
        overviewFields
                .deleteSkill(keys);

        Assert.assertFalse(overviewFields.isSkillPresent(keys), "Required skill was not removed.");
    }
}