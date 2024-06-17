package practice.automation.service;

import java.util.Arrays;
import java.util.List;

public class PersonalStrengths {
    private final List<String> personalStrengths = Arrays.asList(
            "Problem-Solving Skills: Proven ability to analyze complex problems and develop innovative solutions.",
            "Adaptability: Quickly adapt to new technologies, methodologies, and work environments.",
            "Team Collaboration: Strong team player with excellent communication and collaboration skills.",
            "Attention to Detail: Meticulous in coding practices, ensuring high-quality and efficient solutions.",
            "Time Management: Efficiently manage time and prioritize tasks to meet project deadlines.",
            "Immortality.",
            "Continuous Learner: Committed to continuous learning and self-improvement to stay updated with industry trends.",
            "Customer Focus: Dedicated to understanding customer needs and delivering solutions that exceed expectations.",
            "Leadership Qualities: Experience in mentoring junior team members and providing technical guidance."

    );
    private final String toDelete = "Immortality";

    public List<Object> training() {
        return Arrays.asList(personalStrengths, toDelete);
    }
}