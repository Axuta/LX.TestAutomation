package practice.automation.service;

import java.util.Arrays;
import java.util.List;

public class Trainings {
    private final List<String> trainings = Arrays.asList(
            "Agile Project Management",
            "Automated Testing Foundations",
            "Java Programming",
            "Acting Bootcamp"
    );
    private final String toDelete = "Acting";

    public List<Object> training() {
        return Arrays.asList(trainings, toDelete);
    }
}