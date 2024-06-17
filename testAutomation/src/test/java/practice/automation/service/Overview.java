package practice.automation.service;

import java.util.Arrays;
import java.util.List;

public class Overview {
    private final String overview = "Detail-oriented and results-driven Java Software Engineer with centuries of experience in designing, developing, and maintaining enterprise-level applications. Proficient in Java programming language and related frameworks, with a strong emphasis on delivering high-quality code within tight deadlines. Skilled in collaborating with cross-functional teams to analyze requirements and implement innovative solutions that meet business objectives. Proven ability to adapt to new technologies and methodologies while maintaining a commitment to continuous learning and professional growth.";

    private final List<String> skill = Arrays.asList(
            "Programming Languages: Java, SQL",
            "Frameworks/Libraries: Spring Framework, Hibernate, Apache Kafka",
            "Web Technologies: HTML, CSS, JavaScript, Angular",
            "Database Systems: MySQL, PostgreSQL, Oracle",
            "Tools/IDEs: Eclipse, IntelliJ IDEA, Git, Maven",
            "Testing: JUnit, Mockito, Selenium",
            "Agile Methodologies: Scrum, Kanban",
            "Problem-Solving and Analytical Skills"
    );

    private final String toDelete = "Analytical";

    public String getOverview() {
        return overview;
    }

    public List<String> getSkillSet() {
        return skill;
    }

    public String getSkillToDelete() {
        return toDelete;
    }
}