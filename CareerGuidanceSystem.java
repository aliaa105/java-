import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CareerGuidanceSystem extends JFrame implements ActionListener {
    private Connection connection;
    private List<JobRole1> jobRoles;
    private JTextArea outputTextArea;
    private JLabel jobInfoLabel;
    private JTextField userInputField;

    public CareerGuidanceSystem() {
        initializeDatabase();
        initializeObjects();
        createGUI();
    }

    private void initializeDatabase() {
        try {
            connection = DriverManager.getConnection("C:\\Users\\fagr\\IdeaProjects\\java project\\.idea\\libraries\\mysql-connector-java-8.0.22.jar ");
            String createTableSQL = "CREATE TABLE IF NOT EXISTS job_roles (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT," +
                    "description TEXT," +
                    "required_skills TEXT," +
                    "average_salary INTEGER," +
                    "coursera_link TEXT)";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeObjects() {
        jobRoles = fetchJobRolesFromDatabase();
    }

    private List<JobRole1> fetchJobRolesFromDatabase() {
        List<JobRole1> jobRoles = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM job_roles")) {
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                List<String> requiredSkills = List.of(resultSet.getString("required_skills").split(","));
                int averageSalary = resultSet.getInt("average_salary");
                String courseraLink = resultSet.getString("coursera_link");
                jobRoles.add(new JobRole1(title, description, requiredSkills, averageSalary, courseraLink));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobRoles;
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Career Guidance System");

        JPanel panel = new JPanel(new GridLayout(4, 1));

        JTextArea introTextArea = new JTextArea("Hello, this is a program for those who can't figure out what job track they want from CSE student to another.\n\n"
                + "Computer Science has such wonderful fields, everyone has different preferences, and we are trying to help.\n\n"
                + "Choose what inspires you the most:\n\n"
                + "1- Life is worthless as long as Problem solving, Data structures and Algorithms, Designing exist.\n\n"
                + "2- Good Data Analysis and Decision Making = bright FUTURE!\n\n"
                + "3- Feeling excited about Monitoring, Troubleshooting, and Maintenance?\n\n"
                + "4- A Natural Strategist, NO WORRIES! Everything is under control.\n\n"
                + "5- The harmony between coding and designing is something to live for!\n\n"
                + "6- An App for everything, Let's make some!\n\n"
                + "7- Animation is a breathtaking, such a piece of ART.\n\n"
                + "8- Creativity is a wonderful concept, A dream come TRUE.\n\n"
                + "9- Because humankind overthinks TOO MUCH, Everything is Descriptive.\n\n"
                + "Press 10 to exit.\n\n");
        introTextArea.setEditable(false);
        JScrollPane introScrollPane = new JScrollPane(introTextArea);
        panel.add(introScrollPane);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        panel.add(scrollPane);

        jobInfoLabel = new JLabel();
        panel.add(jobInfoLabel);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Enter your choice: "));
        userInputField = new JTextField(10);
        inputPanel.add(userInputField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        inputPanel.add(submitButton);

        panel.add(inputPanel);

        add(panel);
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int userChoice = Integer.parseInt(userInputField.getText());

            if (userChoice >= 1 && userChoice <= jobRoles.size()) {
                displayInformation(jobRoles.get(userChoice - 1));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid choice. Please enter a number between 1 and " + jobRoles.size() + ".");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
        }
    }

    private void displayInformation(JobRole1 selectedJobRole) {
        StringBuilder info = new StringBuilder();
        info.append("Job Title: ").append(selectedJobRole.getTitle()).append("\n");
        info.append("Description: ").append(selectedJobRole.getDescription()).append("\n");
        info.append("Required Skills: ").append(selectedJobRole.getRequiredSkills()).append("\n");
        info.append("Average Salary: ").append(selectedJobRole.getAverageSalary()).append("\n");
        info.append("Coursera Link: ").append(selectedJobRole.getCourseraLink()).append("\n");

        outputTextArea.setText(info.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CareerGui());
    }
}
