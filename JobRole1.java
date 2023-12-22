import java.util.List;

public class JobRole1 {
    private String title;
    private String description;
    private List<String> requiredSkills;
    private int averageSalary;
    private String courseraLink;

    public JobRole1(String title, String description, List<String> requiredSkills, int averageSalary, String courseraLink) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.averageSalary = averageSalary;
        this.courseraLink = courseraLink;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public int getAverageSalary() {
        return averageSalary;
    }

    public String getCourseraLink() {
        return courseraLink;
    }
}
