import java.util.List;

public class JobTrack {
    private String title;
    private String description;
    private List<String> requiredSkills;
    private double averageSalary;

    public JobTrack() {
        this.setTitle(title);
        this.setDescription(description);
        this.setRequiredSkills(requiredSkills);
        this.setAverageSalary(averageSalary);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }
}