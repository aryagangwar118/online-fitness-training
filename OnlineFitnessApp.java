import java.awt.*;
import javax.swing.*;

public class OnlineFitnessApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public OnlineFitnessApp() {
        // Frame setup
        setTitle("Online Fitness Training");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // CardLayout for navigation
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add screens
        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createDashboardPanel(), "Dashboard");
        mainPanel.add(createWorkoutPlansPanel(), "WorkoutPlans");

        add(mainPanel);
        setVisible(true);
    }

    // Login Panel
    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(230, 240, 250)); // Light blue background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Login to Fitness App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;

        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(userLabel, gbc);

        JTextField userField = new JTextField(15);
        gbc.gridx = 1;
        loginPanel.add(userField, gbc);

        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(15);
        gbc.gridx = 1;
        loginPanel.add(passField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(50, 150, 250));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        // Action Listener for Login Button
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            char[] password = passField.getPassword();

            if (username.equals("user") && String.valueOf(password).equals("password")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                cardLayout.show(mainPanel, "Dashboard");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials. Try again.");
            }
        });

        return loginPanel;
    }

    // Dashboard Panel
    private JPanel createDashboardPanel() {
        JPanel dashboardPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        dashboardPanel.setBackground(new Color(240, 250, 230)); // Light green background

        JLabel welcomeLabel = new JLabel("Welcome to Online Fitness Training!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 48));

        JButton workoutButton = new JButton("View Workout Plans");
        workoutButton.setFont(new Font("Arial", Font.BOLD, 34));
        workoutButton.setBackground(new Color(50, 150, 250));
        workoutButton.setForeground(Color.white);
        workoutButton.setFocusPainted(false);

        JButton scheduleButton = new JButton("Schedule Session");
        scheduleButton.setFont(new Font("Arial", Font.BOLD, 34));
        scheduleButton.setBackground(new Color(50, 150, 250));
        scheduleButton.setForeground(Color.red);
        scheduleButton.setFocusPainted(false);

        dashboardPanel.add(welcomeLabel);
        dashboardPanel.add(workoutButton);
        dashboardPanel.add(scheduleButton);

        // Navigation to Workout Plans
        workoutButton.addActionListener(e -> cardLayout.show(mainPanel, "WorkoutPlans"));

        // Placeholder for Schedule Session
        scheduleButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Scheduling feature coming soon!"));

        return dashboardPanel;
    }

    // Workout Plans Panel
    private JPanel createWorkoutPlansPanel() {
        JPanel workoutPanel = new JPanel(new BorderLayout());
        workoutPanel.setBackground(new Color(250, 240, 230)); // Light peach background

        JLabel titleLabel = new JLabel("Workout Plans", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 45));

        // Sample Workout List
        String[] workouts = {"1. Yoga - 30 mins", "2. HIIT - 20 mins", "3. Strength Training - 45 mins","___________________________________","  TOTAL - 95 mins"};
        JList<String> workoutList = new JList<>(workouts);
        workoutList.setFont(new Font("Arial", Font.PLAIN, 35));
        workoutList.setBackground(new Color(245, 245, 245));

        JButton backButton = new JButton("Back to Dashboard");
        backButton.setBackground(new Color(50, 150, 250));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Dashboard"));

        workoutPanel.add(titleLabel, BorderLayout.NORTH);
        workoutPanel.add(new JScrollPane(workoutList), BorderLayout.CENTER);
        workoutPanel.add(backButton, BorderLayout.SOUTH);

        return workoutPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OnlineFitnessApp::new);
    }
}
