import java.util.List;

public class MobileDeveloper extends JobTrack {
    private String platform ; // (e.g., Android, iOS)
    private List<String> developmentFrameworks ;

    public MobileDeveloper() {
        super();
    }

    public List<String> getDevelopmentFrameworks() {
        return developmentFrameworks;
    }

    public void setDevelopmentFrameworks(List<String> developmentFrameworks) {
        this.developmentFrameworks = developmentFrameworks;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    // Getters and setters
}