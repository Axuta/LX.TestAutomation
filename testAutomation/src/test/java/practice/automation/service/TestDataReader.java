package practice.automation.service;

import java.util.*;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(
            System.getProperty("environment"));

    public static Map<String, List<String>> readData(String section) {
        Map<String, List<String>> result = new LinkedHashMap<>();
        String keySection = "testdata." + section + ".";

        for (String key : resourceBundle.keySet()) {
            if (key.startsWith(keySection)) {
                String keyField = key.substring((keySection).length());
                String[] parts = keyField.split("\\.", 2);

                if (parts.length == 2) {
                    String field = parts[0];
                    String value = resourceBundle.getString(key);

                    result.computeIfAbsent(field, k -> new ArrayList<>()).add(value);
                }
            }
        }
        return result;
    }

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}