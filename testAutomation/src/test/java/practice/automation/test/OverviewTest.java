package practice.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.User;
import practice.automation.page.LogInPage;
import practice.automation.page.OverviewSection;
import practice.automation.service.Overview;
import practice.automation.service.UserCreator;

import java.time.Duration;
import java.util.List;

@Test(priority = 2)
public class OverviewTest extends CommonConditions {

    Overview testData;
    private OverviewSection overviewFields;

    @BeforeClass(alwaysRun = true)
    public void testsSetUp() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = new Overview();

        overviewFields = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageOverview();
    }

    @Test(priority = 1)
    public void testFillInOverviewMainTextArea() {
        String expectedOverviewText = testData.getOverview();
        overviewFields
                .fillInOverviewMainTextArea(expectedOverviewText);

        String actualOverviewText = overviewFields
                .getOverviewText();

        Assert.assertEquals(actualOverviewText, expectedOverviewText,
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
        List<String> expectedSkillSet = testData.getSkillSet();
        overviewFields
                .fillInSkills(expectedSkillSet);

        String actualSkillNo2 = overviewFields.getSkill(2);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);

        wait.until(ExpectedConditions
                .numberOfElementsToBe(
                        By.xpath("//section[@id='overview']//input[contains(@placeholder, 'Skill')]"),
                        expectedSkillSet.size()));

        Assert.assertEquals(actualSkillNo2, expectedSkillSet.get(2),
                "Overview contains wrong skill set");
    }

    @Test(priority = 4)
    public void testDeleteSkill() {
        String withKeys = testData.getSkillToDelete();
        overviewFields
                .deleteSkill(withKeys);

        Assert.assertFalse(overviewFields.isSkillPresent(withKeys), "Required skill was not removed.");
    }
}