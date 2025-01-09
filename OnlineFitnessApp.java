import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OnlineFitnessApp {

    private int workoutsCompleted = 0;
    private int caloriesConsumed = 0;
    private List<Profile> profiles = new ArrayList<>();  // List to store profiles
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OnlineFitnessApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Online Fitness Training");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        // Main panel with card layout for navigation
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add different feature panels
        mainPanel.add(createHomePanel(), "Home");
        mainPanel.add(createProfilePanel(), "Profile");
        mainPanel.add(createWorkoutPanel(), "Workouts");
        mainPanel.add(createNutritionPanel(), "Nutrition");
        mainPanel.add(createProgressPanel(), "Progress");
        mainPanel.add(createViewProfilesPanel(), "ViewProfiles");

        // Side navigation
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setBackground(new Color(30, 30, 30));  // Darker background for the side panel
        navPanel.setPreferredSize(new Dimension(250, 1080));

        JButton btnHome = createNavButton("Home");
        JButton btnProfile = createNavButton("Profile");
        JButton btnWorkouts = createNavButton("Workouts");
        JButton btnNutrition = createNavButton("Nutrition");
        JButton btnProgress = createNavButton("Progress");
        JButton btnViewProfiles = createNavButton("View Profiles");

        // Add navigation button listeners
        btnHome.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        btnProfile.addActionListener(e -> cardLayout.show(mainPanel, "Profile"));
        btnWorkouts.addActionListener(e -> cardLayout.show(mainPanel, "Workouts"));
        btnNutrition.addActionListener(e -> cardLayout.show(mainPanel, "Nutrition"));
        btnProgress.addActionListener(e -> cardLayout.show(mainPanel, "Progress"));
        btnViewProfiles.addActionListener(e -> cardLayout.show(mainPanel, "ViewProfiles"));

        navPanel.add(btnHome);
        navPanel.add(btnProfile);
        navPanel.add(btnWorkouts);
        navPanel.add(btnNutrition);
        navPanel.add(btnProgress);
        navPanel.add(btnViewProfiles);

        // Combine navigation and main content
        frame.setLayout(new BorderLayout());
        frame.add(navPanel, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Navigation button styling with color change on hover
    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 50));
        button.setMaximumSize(new Dimension(200, 50));
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 130, 180));  // Light Blue Background
        button.setFocusPainted(false);

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(100, 150, 210));  // Lighter Blue on Hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180));  // Revert to original color
            }
        });

        return button;
    }

    // Home panel with background color
    private JPanel createHomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Welcome to Online Fitness Training!", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(new Color(255, 255, 255));  // White text
        panel.add(label, BorderLayout.CENTER);

        panel.setBackground(new Color(70, 130, 180));  // Light blue background
        return panel;
    }

    // Profile panel with background color
//    private JPanel createProfilePanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setBackground(new Color(245, 245, 245));  // Light gray background
//
//        JLabel label = new JLabel("User Profile");
//        label.setFont(new Font("Arial", Font.BOLD, 28));
//        label.setAlignmentX(Component.CENTER_ALIGNMENT);
//        label.setForeground(new Color(50, 50, 50));  // Darker text for contrast
//
//        JTextField nameField = new JTextField(20);
//        nameField.setMaximumSize(new Dimension(400, 30));
//        JTextField ageField = new JTextField(20);
//        ageField.setMaximumSize(new Dimension(400, 30));
//        JTextField genderField = new JTextField(20);
//        genderField.setMaximumSize(new Dimension(400, 30));
//        JTextField weightField = new JTextField(20);
//        weightField.setMaximumSize(new Dimension(400, 30));
//
//        JButton saveButton = new JButton("Save Profile");
//        saveButton.setFont(new Font("Arial", Font.BOLD, 18));
//        saveButton.setBackground(new Color(70, 130, 180));  // Light Blue Button
//        saveButton.setForeground(Color.WHITE);
//
//        saveButton.addActionListener(e -> {
//            String name = nameField.getText();
//            String age = ageField.getText();
//            String gender = genderField.getText();
//            String weight = weightField.getText();
//
//            if (!name.isEmpty() && !age.isEmpty() && !gender.isEmpty() && !weight.isEmpty()) {
//                profiles.add(new Profile(name, Integer.parseInt(age), gender, Double.parseDouble(weight)));  // Save profile
//                JOptionPane.showMessageDialog(panel, "Profile saved!");
//                // Refresh the View Profiles panel
//                refreshViewProfilesPanel();
//            } else {
//                JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
//            }
//        });
//
//        panel.add(Box.createRigidArea(new Dimension(0, 20)));
//        panel.add(label);
//        panel.add(Box.createRigidArea(new Dimension(0, 20)));
//        panel.add(new JLabel("Name:"));
//        panel.add(nameField);
//        panel.add(Box.createRigidArea(new Dimension(0, 10)));
//        panel.add(new JLabel("Age:"));
//        panel.add(ageField);
//        panel.add(Box.createRigidArea(new Dimension(0, 10)));
//        panel.add(new JLabel("Gender:"));
//        panel.add(genderField);
//        panel.add(Box.createRigidArea(new Dimension(0, 10)));
//        panel.add(new JLabel("Weight:"));
//        panel.add(weightField);
//        panel.add(Box.createRigidArea(new Dimension(0, 20)));
//        panel.add(saveButton);
//
//        return panel;
//    }

    // Nutrition panel with background color
    private JPanel createNutritionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));  // Light gray background

        JLabel label = new JLabel("Nutrition Plans", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setForeground(new Color(50, 50, 50));  // Darker text for contrast
        panel.add(label, BorderLayout.NORTH);

        JTextArea nutritionArea = new JTextArea(20, 40);
        nutritionArea.setEditable(false);
        nutritionArea.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(nutritionArea);

        // Nutrition plan based on age
        if (!profiles.isEmpty()) {
            Profile profile = profiles.get(profiles.size() - 1); // Get the most recent profile
            int age = profile.getAge();
            if (age >= 18 && age <= 30) {
                nutritionArea.setText("Lean Muscle-Building Nutrition Plan:\n- Breakfast: Oatmeal & Eggs\n- Lunch: Grilled Chicken & Quinoa\n- Dinner: Salmon & Vegetables");
            } else if (age >= 31 && age <= 50) {
                nutritionArea.setText("Balanced Nutrition Plan:\n- Breakfast: Whole Grain Toast & Avocado\n- Lunch: Chicken Salad\n- Dinner: Brown Rice & Stir-Fried Veggies");
            } else {
                nutritionArea.setText("Healthy Aging Nutrition Plan:\n- Breakfast: Oatmeal with Berries\n- Lunch: Fish with Leafy Greens\n- Dinner: Soup with Whole Grains");
            }
        } else {
            nutritionArea.setText("Please add a profile to view the nutrition plan.");
        }

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Progress Tracking panel with background color
    private JPanel createProgressPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 245));  // Light gray background

        JLabel label = new JLabel("Progress Tracking");
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(new Color(50, 50, 50));  // Darker text for contrast
        panel.add(label);

        JLabel workoutProgressLabel = new JLabel("Workouts Completed: " + workoutsCompleted);
        workoutProgressLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(workoutProgressLabel);

        JLabel nutritionProgressLabel = new JLabel("Calories Consumed: " + caloriesConsumed);
        nutritionProgressLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(nutritionProgressLabel);

        return panel;
    }

    // Profile panel with background color and nutrition plan
    private JPanel createProfilePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 245));  // Light gray background

        JLabel label = new JLabel("User Profile");
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(new Color(50, 50, 50));  // Darker text for contrast

        JTextField nameField = new JTextField(20);
        nameField.setMaximumSize(new Dimension(400, 30));
        JTextField ageField = new JTextField(20);
        ageField.setMaximumSize(new Dimension(400, 30));
        JTextField genderField = new JTextField(20);
        genderField.setMaximumSize(new Dimension(400, 30));
        JTextField weightField = new JTextField(20);
        weightField.setMaximumSize(new Dimension(400, 30));

        JButton saveButton = new JButton("Save Profile");
        saveButton.setFont(new Font("Arial", Font.BOLD, 18));
        saveButton.setBackground(new Color(70, 130, 180));  // Light Blue Button
        saveButton.setForeground(Color.WHITE);

        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String age = ageField.getText();
            String gender = genderField.getText();
            String weight = weightField.getText();

            if (!name.isEmpty() && !age.isEmpty() && !gender.isEmpty() && !weight.isEmpty()) {
                Profile profile = new Profile(name, Integer.parseInt(age), gender, Double.parseDouble(weight));  // Save profile
                profiles.add(profile);
                JOptionPane.showMessageDialog(panel, "Profile saved!");

                // Display the nutrition plan based on the age
                displayNutritionPlan(profile.getAge());

                // Refresh the View Profiles panel
                refreshViewProfilesPanel();
            } else {
                JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JLabel("Gender:"));
        panel.add(genderField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JLabel("Weight:"));
        panel.add(weightField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(saveButton);

        return panel;
    }

    // Nutrition plan display based on age
    private void displayNutritionPlan(int age) {
        String nutritionPlan = "";

        if (age >= 18 && age <= 30) {
            nutritionPlan = "Nutrition Plan for Age 18-30:\n- Breakfast: Oatmeal, Banana\n- Lunch: Chicken Salad\n- Dinner: Grilled Salmon, Veggies";
        } else if (age >= 31 && age <= 50) {
            nutritionPlan = "Nutrition Plan for Age 31-50:\n- Breakfast: Scrambled Eggs, Whole Wheat Toast\n- Lunch: Grilled Chicken, Quinoa Salad\n- Dinner: Baked Chicken, Steamed Vegetables";
        } else if (age > 50) {
            nutritionPlan = "Nutrition Plan for Age 51+:\n- Breakfast: Smoothie with Spinach, Berries\n- Lunch: Salmon with Roasted Veggies\n- Dinner: Turkey with Mashed Cauliflower";
        }

        // Display the nutrition plan in the nutrition panel
        JPanel nutritionPanel = new JPanel();
        nutritionPanel.setLayout(new BorderLayout());
        nutritionPanel.setBackground(new Color(245, 245, 245));

        JTextArea nutritionArea = new JTextArea(10, 40);
        nutritionArea.setText(nutritionPlan);
        nutritionArea.setEditable(false);
        nutritionArea.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(nutritionArea);

        nutritionPanel.add(scrollPane, BorderLayout.CENTER);

        // Update the nutrition plan display
        mainPanel.add(nutritionPanel, "Nutrition");
        cardLayout.show(mainPanel, "Nutrition");
        mainPanel.revalidate();
        mainPanel.repaint();
    }


    // Add this method to create the workout panel
    private JPanel createWorkoutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 245));  // Light gray background

        JLabel label = new JLabel("Workout Plans");
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(new Color(50, 50, 50));  // Darker text for contrast
        panel.add(label);

        JTextArea workoutArea = new JTextArea(20, 40);
        workoutArea.setEditable(false);
        workoutArea.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(workoutArea);

        // Sample workout plans
        workoutArea.setText("Workout Plan for the Day:\n- Warm-up: 5-10 minutes\n- Push-ups: 3 sets of 10\n- Squats: 3 sets of 15\n- Cardio: 20 minutes of running");

        panel.add(scrollPane);

        return panel;
    }


    // View Profiles panel with table
    private JPanel createViewProfilesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));  // Light gray background

        JLabel label = new JLabel("Added Profiles");
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label, BorderLayout.NORTH);

        if (profiles.isEmpty()) {
            JLabel noProfilesLabel = new JLabel("No profiles added yet.");
            panel.add(noProfilesLabel, BorderLayout.CENTER);
        } else {
            String[] columnNames = {"Name", "Age", "Gender", "Weight"};
            Object[][] rowData = new Object[profiles.size()][4];

            for (int i = 0; i < profiles.size(); i++) {
                Profile profile = profiles.get(i);
                rowData[i][0] = profile.getName();
                rowData[i][1] = profile.getAge();
                rowData[i][2] = profile.getGender();
                rowData[i][3] = profile.getWeight();
            }

            JTable profileTable = new JTable(rowData, columnNames);
            JScrollPane scrollPane = new JScrollPane(profileTable);
            panel.add(scrollPane, BorderLayout.CENTER);
        }

        return panel;
    }

    // Profile class to store user profile data
    private static class Profile {
        private String name;
        private int age;
        private String gender;
        private double weight;

        public Profile(String name, int age, String gender, double weight) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        public double getWeight() {
            return weight;
        }
    }

    // Refresh the Progress Panel
    private void refreshProgressPanel() {
        JPanel progressPanel = createProgressPanel();
        mainPanel.add(progressPanel, "Progress");
        cardLayout.show(mainPanel, "Progress");
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Refresh the View Profiles Panel
    private void refreshViewProfilesPanel() {
        JPanel viewProfilesPanel = createViewProfilesPanel();
        mainPanel.add(viewProfilesPanel, "ViewProfiles");
        cardLayout.show(mainPanel, "ViewProfiles");
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
