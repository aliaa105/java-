import java.util.List;

public class UserExperienceDesigner extends JobTrack {
    private List<String> designPrinciples;
    private List<String> userResearchMethodologies;
    public UserExperienceDesigner() {
        super();
        this.designPrinciples = designPrinciples;
    }

    public UserExperienceDesigner(String title, String description, List<String> requiredSkills, double averageSalary) {
        super();
    }

    public List<String> getDesignPrinciples() {
        return designPrinciples;
    }

    public void setDesignPrinciples(List<String> designPrinciples) {
        this.designPrinciples = designPrinciples;
    }

    public List<String> getUserResearchMethodologies() {
        return userResearchMethodologies;
    }

    public void setUserResearchMethodologies(List<String> userResearchMethodologies) {
        this.userResearchMethodologies = userResearchMethodologies;
    }

    // Getters and setters
}