package practice.automation.service;

import java.util.*;

public class LanguageSkills {
    private final List<Map<String, String>> languageSkills;
    private final String toDelete = "Ger";

    public LanguageSkills() {
        languageSkills = new ArrayList<>();

        for (int i = 0; i < language.size(); i++) {
            Map<String, String> project = new LinkedHashMap<>();
            project.put("language", language.get(i));
            project.put("level", level.get(i));

            languageSkills.add(project);
        }
    }

    public List<Object> language() {
        return Arrays.asList(languageSkills, toDelete);
    }

    private final List<String> language = Arrays.asList(
            "Eng",
            "Bela",
            "Ru",
            "Ger"
    );
    private final List<String> level = Arrays.asList(
            "Upper",
            "Native",
            "Na",
            "Begin"
    );
}