package practice.automation.service;

import java.util.*;

public class ProfessionalExperience {
    private final List<Map<String, String>> professionalExperience;

    public ProfessionalExperience() {
        professionalExperience = new ArrayList<>();

        for (int i = 0; i < customer.size(); i++) {
            Map<String, String> project = new LinkedHashMap<>();
            project.put("customer", customer.get(i));
            project.put("role", role.get(i));
            project.put("startDate", startDate.get(i));
            project.put("endDate", endDate.get(i));
            project.put("description", description.get(i));
            project.put("responsibility", responsibility.get(i));
            project.put("tools", tools.get(i));

            professionalExperience.add(project);
        }
    }

    private final List<String> customer = Arrays.asList(
            "First Company Name",
            "Second Company Name");
    private final List<String> role = Arrays.asList(
            "Senior Java Software Engineer",
            "Java Software Engineer");
    private final List<String> startDate = Arrays.asList(
            "01.2011",
            "01.2021");
    private final List<String> endDate = Arrays.asList(
            "12.2020",
            "Present");
    private final List<String> description = Arrays.asList(
            "Brief description of the project #1.",
            "Brief description of the project #2.");
    private final List<String> responsibility = Arrays.asList(
            "Developed and maintained Java-based applications for [specific projects/products];;" +
                    "Collaborated with cross-functional teams to gather requirements and design scalable solutions;;" +
                    "Implemented RESTful web services using Spring Framework, facilitating seamless integration between frontend and backend systems;;" +
                    "Designed and optimized database schemas and queries, resulting in improved application performance;;" +
                    "Participated in code reviews and provided constructive feedback to team members, ensuring adherence to coding standards and best practices;;" +
                    "Contributed to the adoption of Agile methodologies, leading to increased efficiency and productivity within the development team"
            ,
            "Played a key role in the development of [specific modules/features] for enterprise software solutions;;" +
                    "Utilized Hibernate ORM framework to map Java objects to relational database tables, ensuring data integrity and consistency;;" +
                    "Integrated third-party APIs and services into existing applications, enhancing functionality and user experience;;" +
                    "Implemented unit tests using JUnit and Mockito to verify the correctness of code and identify potential defects early in the development lifecycle;;" +
                    "Assisted in troubleshooting and resolving technical issues, providing timely support to internal stakeholders and clients");
    private final List<String> tools = Arrays.asList(
            "Java, Spring Framework, Hibernate, RESTful APIs, MySQL, Git, Maven, Agile methodologies",
            "Java, Hibernate, RESTful APIs, JUnit, Mockito, Git");

    public List<Map<String, String>> getProjectsInformation() {
        return professionalExperience;
    }

    public List<String> getCustomer() {
        return customer;
    }

    public List<String> getRole() {
        return role;
    }

    public List<String> getStartDate() {
        return startDate;
    }

    public List<String> getEndDate() {
        return endDate;
    }

    public List<String> getDescription() {
        return description;
    }

    public List<String> getResponsibility() {
        return responsibility;
    }

    public List<String> getTools() {
        return tools;
    }
}