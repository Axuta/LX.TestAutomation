package practice.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practice.automation.model.TestData;
import practice.automation.model.User;
import practice.automation.page.LanguageSkillsSection;
import practice.automation.page.LogInPage;
import practice.automation.service.TestDataCreator;
import practice.automation.service.UserCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Test(priority = 5)
public class LanguageSkillsTest extends CommonConditions {
    TestData testData;
    private LanguageSkillsSection languageSkills;

    @BeforeClass(alwaysRun = true)
    public void testsSetUp() {
        User testUser = UserCreator.withCredentialsFromProperty();
        testData = TestDataCreator.forLanguageSkills();

        languageSkills = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageLanguageSkills();
    }

    @Test(priority = 1)
    public void testFillInLanguageSkills() {
        Map<String, List<String>> testedLanguageSkills = testData.getLanguageSkills();
        languageSkills
                .fillInLanguageSkills(testedLanguageSkills);

        List<List<String>> testedLanguages = new ArrayList<>(testedLanguageSkills.values());
        testedLanguages.get(0).get(0);

        List<String> expectedLanguages = languageSkills.getLanguageNames();
        List<String> expectedLanguageLevels = languageSkills.getLanguageLevels();

        Assert.assertEquals(testedLanguageSkills.values(),
                expectedLanguages,
                "Wrong list of languages.");
        Assert.assertEquals(testedLanguageSkills.values(),
                expectedLanguageLevels,
                "Wrong list of language levels.");
    }

    @Test(priority = 2)
    public void testDeleteLanguage() {
        String withText = testData.getLanguageToDelete();
        languageSkills
                .deleteLanguage(withText);

        Assert.assertFalse(languageSkills.isLanguagePresent(withText),
                "Required language was not removed.");
    }
}
