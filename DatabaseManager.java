import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/job_tracks";
    private static final String USER = "Aliaa";
    private static final String PASSWORD = "123";

    // Establish the database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    // Retrieve job tracks from the database
    @SuppressWarnings("CallToPrintStackTrace")
    public static List<JobTrack> getJobTracks(JobTrack jobTrack) {
        List<JobTrack> jobTracks = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM job_tracks")) {

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                // Add other fields based on your database schema


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobTracks;
    }
}
