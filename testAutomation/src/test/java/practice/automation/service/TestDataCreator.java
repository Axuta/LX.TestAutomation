package practice.automation.service;

import practice.automation.model.TestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestDataCreator {
    private Map<String, List<String>> dataMap;

    public static Map<String, List<String>> map(String sectionName) {
        return switch (sectionName) {
            case "general-info" -> TestDataReader.readData("general");
            case "overview" -> TestDataReader.readData("overview");
            case "professional-experience" -> TestDataReader.readData("experience");
            case "education" -> TestDataReader.readData("education");
            case "language-skills" -> TestDataReader.readData("languages");
            case "certifications" -> TestDataReader.readData("certification");
            case "trainings" -> TestDataReader.readData("trainings");
            case "personal-strengths" -> TestDataReader.readData("strengths");
            default -> throw new IllegalArgumentException("Invalid section: " + sectionName);
        };
    }

    public static TestData forGeneralInfo() {
        Map<String, List<String>> dataMap = map("general-info");

        System.out.println(dataMap);

        dataMap.get("name");
        String firstName = dataMap.get("name").get(0);
        String lastName = dataMap.get("name").get(1);
        String jobTitle = dataMap.get("name").get(2);

        return new TestData(firstName, lastName, jobTitle);
    }

    public static TestData forOverview() {
        Map<String, List<String>> dataMap = TestDataReader.readData("overview");

        String overview = dataMap.get("overview").get(0);
        List<String> skillSet = new ArrayList<>(Arrays.asList(dataMap.get("skill").get(0).split(";;")));
        String skillToDelete = dataMap.get("skill").get(1);

        return new TestData(overview, skillSet, skillToDelete);
    }

    public static TestData forProfessionalExperience() {
        Map<String, List<String>> dataMap = TestDataReader.readData("experience");

        String customer = "";
        String role = "";
        List<String> date = new ArrayList<>();
        String projectDescription = "";
        List<String> responsibilities = new ArrayList<>();
        String tools = "";

        return new TestData(customer, role, date, projectDescription, responsibilities, tools);
    }

    public static TestData forEducation() {
        Map<String, List<String>> dataMap = TestDataReader.readData("education");
        List<String> educations = dataMap.get("1");
        return new TestData(educations);
    }




}