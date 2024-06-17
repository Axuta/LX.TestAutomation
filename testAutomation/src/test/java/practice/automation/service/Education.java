package practice.automation.service;

import java.util.Arrays;
import java.util.List;

public class Education {
    private final List<String> education = Arrays.asList(
            "MIT, Computer Science, Bachelor of Science",
            "NYU, Software Engineering, Master of Science",
            "Hogwarts School for Witchcraft and Wizardry, Ravenclaw, Master of Transfiguration"
    );

    private final String toDelete = "Wizard";

    public List<Object> education() {
        return Arrays.asList(education, toDelete);
    }
}