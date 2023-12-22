import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;


class JobRole {
    private String title;
    private String description;
    private List<String> requiredSkills;
    private int averageSalary;
    private String courseraLink;

    // Constructor
    public JobRole(String title, String description, List<String> requiredSkills, int averageSalary, String courseraLink) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.averageSalary = averageSalary;
        this.courseraLink = courseraLink;
    }

    // Getters
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

public class MainGUI extends JFrame implements ActionListener {
    private JTextArea outputTextArea;
    private JTextField userInputField;
    private JLabel jobInfoLabel;
    private JLabel imageLabel;

    private JobRole1[] jobRoles;

    public MainGUI() {
        initializeObjects();
        createGUI();
    }

    private void initializeObjects() {
        // Initialize job roles
        jobRoles = new JobRole1[]{
                new JobRole1("Software Developer", "Create new software and improve existing software applications.", List.of("Data structures and Algorithms", "Database", "Problem solving", "Programming languages"), 120000, "https://www.coursera.org/career-academy/roles/back-end-developer"),
                new JobRole1("Data Scientist", "Extract and analyze data to make informed decisions using algorithms and tools.", List.of("Matplotlib", "Scikit-learn", "Jupyter", "TensorFlow", "Excel", "Python", "Tableau"), 138000, "https://www.coursera.org/career-academy/roles/data-scientist"),
                new JobRole1("Network Engineer", "Monitor, troubleshoot, and maintain networks in a 24/7 environment for stability and security.", List.of("CCNA", "Network Security", "Network Fundamentals"), 80300, "https://www.coursera.org/career-academy/roles/network-engineer"),
                new JobRole1("Cyber Security Prof", "Develop strategies to protect organizations from cyber-attacks and disruptions.", List.of("OS", "C Programming", "Network Fundamentals"), 119700, "https://www.coursera.org/career-academy/roles/cybersecurity-analyst"),
                new JobRole1("Web developer", "Creating, building, and maintaining websites.", List.of("Front-End technologies", "Back-End technologies"), 81700, "https://www.geeksforgeeks.org/web-development/#courses"),
                new JobRole1("Mobile developer", "Mobile apps development, often written for specific mobile devices.", List.of("Programming languages", "Logical thinking", "Design knowledge"), 12700, "https://www.coursera.org/career-academy/roles/android-developer"),
                new JobRole1("Game developer", "Responsible for bringing a video game from concept to reality, including coding and programming visual elements.", List.of("Coding", "Design", "monitoring"), 87000, "https://www.udemy.com/courses/development/game-development/"),
                new JobRole1("UX designer", "Create products that provide meaningful and relevant experiences to users.", List.of("Network", "Design", "portfolio", "UX course"), 94500, "https://www.coursera.org/career-academy/roles/ux-designer"),
                new JobRole1("Technical Writer", "Create content to provide instructions or explain technical concepts regarding environmental regulations, computer applications, or medical procedures.", List.of("Computer skill", "Learn style guides", "Develop a portfolio"), 81800, "https://www.udemy.com/courses/search/?q=technical+writing&src=sac&kw=techn"),

        };
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
        introTextArea.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size
        JScrollPane introScrollPane = new JScrollPane(introTextArea);
        panel.add(introScrollPane);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font size
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        panel.add(scrollPane);

        jobInfoLabel = new JLabel();
        jobInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size
        panel.add(jobInfoLabel);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Enter your choice: "));
        userInputField = new JTextField(10);
        userInputField.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font size
        inputPanel.add(userInputField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font size
        inputPanel.add(submitButton);

        panel.add(inputPanel);

        add(panel);
        setSize(800, 600); // Set the size of the window
        setLocationRelativeTo(null); // Center the frame
    }

    private void displayInformation(JobRole1 jobRole) {
        String jobInfoText = "Job Title: " + jobRole.getTitle() + "\n"
                + "Description: " + jobRole.getDescription() + "\n"
                + "Required Skills: " + jobRole.getRequiredSkills() + "\n"
                + "Average Salary: $" + jobRole.getAverageSalary() + "\n";

        jobInfoLabel.setText("<html>" + jobInfoText.replace("\n", "<br>") + "</html>");

        try {
            String courseraLink = jobRole.getCourseraLink();
            Desktop.getDesktop().browse(new URL(courseraLink).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int userChoice = Integer.parseInt(userInputField.getText());

            if (userChoice >= 1 && userChoice <= jobRoles.length) {
                displayInformation(jobRoles[userChoice - 1]);
            } else if (userChoice == 10) {
                JOptionPane.showMessageDialog(this, "Exiting. Hope we helped. Best of luck!");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid choice. Please enter a number between 1 and " + jobRoles.length + ".");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}
