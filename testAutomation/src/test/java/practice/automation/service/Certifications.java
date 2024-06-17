package practice.automation.service;

import java.util.*;

public class Certifications {
    private final List<Map<String,String>> certifications;

    private final List<String> certificate = Arrays.asList(
            "0001, Test Sample",
            "007, MI6 Agent",
            "911, Dispatcher"
    );

    private final List<String> links = Arrays.asList(
            "www.geekbrains.by",
            "www.sis.gov.uk",
            "www.nena.org"
    );

    private final String toDelete = "Dispatcher";

    public Certifications() {
        certifications = new ArrayList<>();

        for (int i = 0; i < certificate.size(); i++) {
            Map<String, String> project = new LinkedHashMap<>();
            project.put("customer", certificate.get(i));
            project.put("role", links.get(i));

            certifications.add(project);
        }
    }

    public List<Object> education() {
        return Arrays.asList(certifications, toDelete);
    }
}