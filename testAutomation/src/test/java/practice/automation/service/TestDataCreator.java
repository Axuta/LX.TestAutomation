package practice.automation.service;

import practice.automation.model.TestData;

import java.util.*;

public class TestDataCreator {

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
        Map<String, List<String>> dataMap = map("overview");

        String overview = dataMap.get("overview").getFirst();
        List<String> skillSet = new ArrayList<>(Arrays.asList(
                dataMap.get("skill")
                        .getFirst().split(";;")));
        String skillToDelete = dataMap.get("skill").get(1);

        return new TestData(overview, skillSet, skillToDelete);
    }

    public static TestData forProfessionalExperience() {
        Map<String, List<String>> dataMap = map("experience");

        String customer = "";
        String role = "";
        List<String> date = new ArrayList<>();
        String projectDescription = "";
        List<String> responsibilities = new ArrayList<>();
        String tools = "";

        return new TestData(customer, role, date, projectDescription, responsibilities, tools);
    }

    public static TestData forEducation() {
        Map<String, List<String>> dataMap = map("education");

        List<String> educationsList = new ArrayList<>(Arrays.asList(
                dataMap.get("skill")
                        .getFirst().split(";;")));
        String educationToDelete = dataMap.get("education").getFirst();

        return new TestData(educationsList, educationToDelete);
    }

    public static TestData forLanguageSkills() {
        Map<String, List<String>> dataMap = map("language-skills");
        String languageToDelete = dataMap.get("language").getFirst();

        dataMap.remove("language");
        return new TestData(dataMap, languageToDelete);
    }

    public static TestData forCertifications() {
        Map<String, List<String>> dataMap = map("certifications");

        List<String> certificationsList = new ArrayList<>(Arrays.asList(
                dataMap.get("certifications")
                        .getFirst().split(";;")));
        String certificationToDelete = dataMap.get("certification").getFirst();

        return new TestData(certificationsList, certificationToDelete);
    }

    public static TestData forTrainings() {
        Map<String, List<String>> dataMap = map("trainings");

        List<String> trainingsList = new ArrayList<>(Arrays.asList(
                dataMap.get("trainings")
                        .getFirst().split(";;")));
        String educationToDelete = dataMap.get("training").getFirst();

        return new TestData(trainingsList, educationToDelete);
    }

    public static TestData forPersonalStrengths() {
        Map<String, List<String>> dataMap = map("personal-strengths");

        List<String> educationsList = new ArrayList<>(Arrays.asList(
                dataMap.get("strengths")
                        .getFirst().split(";;")));
        String educationToDelete = dataMap.get("strength").getFirst();

        return new TestData(educationsList, educationToDelete);
    }

}