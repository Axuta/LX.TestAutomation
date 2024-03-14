package practice.automation.model;

import java.util.List;
import java.util.Map;

public class TestData {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String customer;
    private String role;
    private List<String> date;
    private String projectDescription;
    private List<String> responsibilities;
    private String tools;
    private String overview;
    private List<String> skillSet;
    private String skillToDelete;
    private Map<String, List<String>> dataMap;

    public TestData(Map<String, List<String>> dataMap) {
        this.dataMap = dataMap;
    }

    public TestData(String firstName, String lastName, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
    }

    public TestData(String overview, List<String> skillSet, String skillToDelete) {
        this.overview = overview;
        this.skillSet = skillSet;
        this.skillToDelete = skillToDelete;
    }

    public TestData(String customer, String role, List<String> date, String projectDescription, List<String> responsibilities, String tools) {
        this.customer = customer;
        this.role = role;
        this.date = date;
        this.projectDescription = projectDescription;
        this.responsibilities = responsibilities;
        this.tools = tools;
    }


    public TestData(List<String> educations) {

    }
}
