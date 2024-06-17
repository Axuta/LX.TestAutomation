package practice.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice.automation.model.User;
import practice.automation.page.LogInPage;
import practice.automation.service.UserCreator;

public class LoginTest extends CommonConditions {
    @Test
    public void authorizationIsWorking() {
        User testUser = UserCreator.withCredentialsFromProperty();

        String expectedResults = new LogInPage(driver)
                .openPage()
                .loginValidUser(testUser)
                .manageGeneralInfo()
                .getFirstName();

        Assert.assertEquals(expectedResults,
                "Test",
                "Authorization is not working.");
    }

}
