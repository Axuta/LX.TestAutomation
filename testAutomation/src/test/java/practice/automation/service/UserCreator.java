package practice.automation.service;

import practice.automation.model.User;

public class UserCreator {
    public static final String TESTDATA_USER_MAIL = "testdata.login.mail";
    public static final String TESTDATA_USER_PASSWORD = "testdata.login.password";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_MAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyMail() {
        return new User("",
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyPassword() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_MAIL),
                "");
    }
}
