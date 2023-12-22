import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class CareerGui extends JFrame implements ActionListener {
    private JTextField userInputField;
    private JLabel imageLabel;

    public CareerGui() {
        createGUI();
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

        userInputField = new JTextField(10);
        panel.add(userInputField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        imageLabel = new JLabel();
        panel.add(imageLabel);

        add(panel);
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int userChoice = Integer.parseInt(userInputField.getText());

            if (userChoice >= 1 && userChoice <= 9) {
                displayImageFromInternet();
            } else if (userChoice == 10) {
                JOptionPane.showMessageDialog(this, "Exiting. Hope we helped. Best of luck!");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid choice. Please enter a number between 1 and 10.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
        }
    }

    private void displayImageFromInternet() {
        String imageUrl = "https://www.shutterstock.com/image-illustration/programming-code-abstract-technology-background-260nw-1887170134.jpg"; // Replace with the actual image URL
        try {
            URL url = new URL(imageUrl);
            ImageIcon imageIcon = new ImageIcon(url);
            Image image = imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(this, "Error loading image. Check the URL.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CareerGui());
    }
}
