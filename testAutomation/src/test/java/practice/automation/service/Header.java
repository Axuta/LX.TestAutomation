package practice.automation.service;

import java.util.*;

public class Header {

    public void revision() {
        List<Map<String,String>> revisions = new ArrayList<>();

        List<String> name = Arrays.asList(
                "test",
                "backup test");
        List<String> fromRevision = Arrays.asList(
                "default",
                "test");

        for (int i = 0; i < name.size(); i++) {
            Map<String,String> revision = new LinkedHashMap<>();
            revision.put("name",name.get(i));
            revision.put("fromRevision", fromRevision.get(i));

            revisions.add(revision);
        }
    }

    public void translate() {
        List<Map<String,String>> translations = new ArrayList<>();

        List<String> from = Arrays.asList(
                "EN",
                "RU",
                "EN",
                "DE"
        );
        List<String> to = Arrays.asList(
          "RU",
          "EN",
          "DE",
          "EN"
        );

        for (int i = 0; i < from.size(); i++) {
            Map<String,String> translation = new LinkedHashMap<>();
            translation.put("from",from.get(i));
            translation.put("to", to.get(i));

            translations.add(translation);
        }
    }

    public void template() {
        List<Map<String,String>> templates = new ArrayList<>();

        List<String> name = Arrays.asList(
                "LeverX",
                "Emerline"
        );
        List<String> language = Arrays.asList(
                "RU",
                "EN"
        );

        for (int i = 0; i < name.size(); i++) {
            Map<String,String> template = new LinkedHashMap<>();
            template.put("name",name.get(i));
            template.put("language", language.get(i));

            templates.add(template);
        }
    }

    public void share() {
        template();
        List<String> fileExtension = Arrays.asList(
                "pdf",
                "docx"
        );
        List<String> options = Arrays.asList(
                "Anonymize",
                "Hide employee photo",
                "Remove page break after Overview",
                "Remove all page breaks",
                "Hide project number",
                "Hide Customers",
                "Hide Trainings",
                "Hide Personal Strength",
                "Hide Certifications",
                "Anonymize customers"
        );


    }
}
