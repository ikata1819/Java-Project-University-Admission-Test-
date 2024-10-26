package com.cse.ju.oop.views.screens;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;

public class StudentMenu extends JFrame {
    ConnReg connReg; // Database connection object
    private String studentName; // Store the logged-in student's name

    StudentMenu() {
        connReg = new ConnReg(); // Initialize the database connection

        // Initialize the frame
        setTitle("Student Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1200, 650);
        setLocationRelativeTo(null);

        // Set background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/a.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        add(background, BorderLayout.CENTER);

        // Create a panel for university label and logo
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Center the content
        titlePanel.setOpaque(false); // Make the panel transparent

        // Load and add logo
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("Java Project Pictures/ju logo png.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); // Adjust size as needed
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        titlePanel.add(logoLabel); // Add logo to the panel

        // Create a label for the university name
        JLabel universityLabel = new JLabel("Jahangirnagar University");
        universityLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font for the university name
        universityLabel.setForeground(Color.WHITE); // Set text color
        titlePanel.add(universityLabel); // Add university label to the panel

        // Add title panel to the background
        background.setLayout(new BorderLayout()); // Set layout to the background
        background.add(titlePanel, BorderLayout.NORTH); // Add title panel at the top

        // Create a panel for buttons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 3, 20, 20)); // 4x3 grid with spacing
        mainPanel.setOpaque(false); // Make the panel background transparent to show the image

        // Button styles
        Font buttonFont = new Font("Arial", Font.PLAIN, 24);
        Color buttonColor = new Color(100, 180, 240); // Light blue color for buttons

        // Create buttons
        JButton registrationButton = createButton("Registration", buttonFont, buttonColor);
        JButton loginButton = createButton("Login", buttonFont, buttonColor);
        JButton applicationButton = createButton("Application", buttonFont, buttonColor);
        JButton admitCardButton = createButton("Get Admit Card", buttonFont, buttonColor);
        JButton examScheduleVenueButton = createButton("Exam Schedule and Venue", buttonFont, buttonColor);
        JButton finalResultButton = createButton("Final Result", buttonFont, buttonColor);
        JButton logoutButton = createButton("Logout", buttonFont, buttonColor);
        JButton exitButton = createButton("Exit", buttonFont, buttonColor);
        JButton emptyButton = new JButton(); // Empty button for layout alignment
        emptyButton.setVisible(false); // Make it invisible

        // Add buttons to the panel
        mainPanel.add(registrationButton);
        mainPanel.add(loginButton);
        mainPanel.add(applicationButton);
        mainPanel.add(admitCardButton);
        mainPanel.add(examScheduleVenueButton);
        mainPanel.add(finalResultButton);
        mainPanel.add(logoutButton);
        mainPanel.add(exitButton);
        mainPanel.add(emptyButton); // Empty button for alignment

        // Add button panel to the frame below the university label
        background.add(mainPanel, BorderLayout.CENTER); // Add panel below the title panel

        // Button actions
        registrationButton.addActionListener(e -> openRegistrationForm());
        loginButton.addActionListener(e -> openLoginForm());
        applicationButton.addActionListener(e -> openApplicationForm());
        admitCardButton.addActionListener(e -> generateAdmitCard());
        // Exam Schedule and Venue action
        examScheduleVenueButton.addActionListener(e -> showExamScheduleAndVenue());

        finalResultButton.addActionListener(e -> showMessage("Final Result clicked!"));
        logoutButton.addActionListener(e -> {
            new Homescreen(); // Open HomeScreen class
            this.dispose(); // Close the current StudentMenu window
        });

        exitButton.addActionListener(e -> System.exit(0));

        // Make the frame visible
        setVisible(true);
    }

    private void openRegistrationForm() {
        new Registration(); // Assuming Registration is the name of the class you want to open
    }

    private void openLoginForm() {
        JFrame loginFrame = new JFrame("Student Login");
        loginFrame.setSize(400, 450);
        loginFrame.setLocation(500, 250);
        loginFrame.getContentPane().setBackground(Color.WHITE);
        loginFrame.setLayout(null);

        // Create labels and text fields
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(40, 20, 100, 20);
        loginFrame.add(lblName);

        JTextField tfName = new JTextField();
        tfName.setBounds(170, 20, 150, 20);
        loginFrame.add(tfName);

        JLabel lblAdmissionRoll = new JLabel("HSC Roll");
        lblAdmissionRoll.setBounds(40, 70, 100, 20);
        loginFrame.add(lblAdmissionRoll);

        JTextField tfAdmissionRoll = new JTextField();
        tfAdmissionRoll.setBounds(170, 70, 150, 20);
        loginFrame.add(tfAdmissionRoll);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 120, 100, 20);
        loginFrame.add(lblPassword);

        JPasswordField tfPassword = new JPasswordField();
        tfPassword.setBounds(170, 120, 150, 20);
        loginFrame.add(tfPassword);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(60, 180, 120, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(e -> {
            // Handle login logic here
            String name = tfName.getText();
            String admissionRoll = tfAdmissionRoll.getText();
            String password = new String(tfPassword.getPassword());

            if (checkLogin(name, admissionRoll, password)) {
                studentName = name; // Store the student's name on successful login
                JOptionPane.showMessageDialog(null, "Login successful! Welcome back, " + name);
                loginFrame.dispose(); // Close the login form after successful login
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials! Please try again.");
            }
        });
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginFrame.add(loginButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(205, 180, 120, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(e -> loginFrame.dispose()); // Close the login form
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginFrame.add(cancelButton);

        loginFrame.setVisible(true); // Show the login window
    }

    private boolean checkLogin(String name, String hsc_roll, String password) {
        try {
            String query = "SELECT * FROM students WHERE name = ? AND hsc_roll = ? AND password = ?";
            PreparedStatement pst = connReg.c.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, hsc_roll);
            pst.setString(3, password);

            ResultSet rs = pst.executeQuery();
            boolean isValid = rs.next(); // If there's a result, login is valid

            // Close resources
            rs.close();
            pst.close();
            return isValid;
        } catch (SQLException ex) {
            ex.printStackTrace();
            showMessage("Error during login: " + ex.getMessage());
            return false;
        }
    }

    private void showExamScheduleAndVenue() {
        JFrame venueFrame = new JFrame("Exam Schedule and Venue");
        venueFrame.setSize(600, 400);
        venueFrame.setLocationRelativeTo(null);
        venueFrame.setLayout(new BorderLayout());

        String[] columnNames = {"Name", "Father's Name", "Building", "Room", "Shift", "Admission Roll"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable venueTable = new JTable(model);

        try {
            String admissionRoll = ""; // Retrieve from user input or session if needed

            // Use the stored studentName instead of retrieving again
            String query = "SELECT name, father_name, building, room, shift, admission_roll " +
                    "FROM a_unit_venue WHERE name = ? " +
                    "UNION " +
                    "SELECT name, father_name, building, room, shift, admission_roll " +
                    "FROM b_unit_venue WHERE name = ? " +
                    "UNION " +
                    "SELECT name, father_name, building, room, shift, admission_roll " +
                    "FROM c_unit_venue WHERE name = ? " +
                    "UNION " +
                    "SELECT name, father_name, building, room, shift, admission_roll " +
                    "FROM d_unit_venue WHERE name = ? " +
                    "UNION " +
                    "SELECT name, father_name, building, room, shift, admission_roll " +
                    "FROM e_unit_venue WHERE name = ?";

            PreparedStatement pst = connReg.c.prepareStatement(query);
            pst.setString(1, studentName);
            pst.setString(2, studentName);
            pst.setString(3, studentName);
            pst.setString(4, studentName);
            pst.setString(5, studentName);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String studentName = rs.getString("name");
                String fatherName = rs.getString("father_name");
                String building = rs.getString("building");
                String room = rs.getString("room");
                String shift = rs.getString("shift");
                String admRoll = rs.getString("admission_roll");

                model.addRow(new Object[]{studentName, fatherName, building, room, shift, admRoll});
            }

            // Close resources
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            showMessage("Error retrieving exam schedule and venue: " + ex.getMessage());
        }

        venueFrame.add(new JScrollPane(venueTable), BorderLayout.CENTER);
        venueFrame.setVisible(true); // Show the exam schedule and venue frame
    }

    private void generateAdmitCard() {
        try {
            // Fetch data from the database
            String unit = JOptionPane.showInputDialog(null, "Enter unit:");


            String query = "SELECT name, father_name, hsc_roll, admission_roll, building, room, shift " +
                    "FROM "+unit+"_unit_venue WHERE name = ?";
            PreparedStatement pst = connReg.c.prepareStatement(query);
            pst.setString(1, studentName);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String fatherName = rs.getString("father_name");
                String hscRoll = rs.getString("hsc_roll");
                String admissionRoll = rs.getString("admission_roll");
                String venue = rs.getString("building") + ", Room: " + rs.getString("room");
                String shift = rs.getString("shift");

                // Create the admit card as an image
                BufferedImage admitCardImage = createAdmitCardImage(name, fatherName, hscRoll, admissionRoll, venue, shift);

                // Prompt user to download the image
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save Admit Card");
                int userSelection = fileChooser.showSaveDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    ImageIO.write(admitCardImage, "png", new File(fileToSave.getAbsolutePath() + ".png"));
                    JOptionPane.showMessageDialog(this, "Admit Card downloaded successfully!");
                }
            } else {
                showMessage("No data found for the admit card.");
            }

            rs.close();
            pst.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessage("Error generating admit card: " + ex.getMessage());
        }
    }

    // Function to create the admit card image
    private BufferedImage createAdmitCardImage(String name, String fatherName, String hscRoll, String admissionRoll, String venue, String shift) {
        int width = 400;
        int height = 300;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height); // White background
        g2d.setColor(Color.BLACK);

        // Add title
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Admit Card", 150, 30);

        // Add student details
        g2d.setFont(new Font("Arial", Font.PLAIN, 16));
        g2d.drawString("Name: " + name, 50, 70);
        g2d.drawString("Father's Name: " + fatherName, 50, 100);
        g2d.drawString("HSC Roll: " + hscRoll, 50, 130);
        g2d.drawString("Admission Roll: " + admissionRoll, 50, 160);
        g2d.drawString("Venue: " + venue, 50, 190);
        g2d.drawString("Shift: " + shift, 50, 220);

        g2d.dispose(); // Clean up

        return image;
    }

    private JButton createButton(String text, Font font, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false); // Remove focus border
        return button;
    }

    private void openApplicationForm() {
       new Application();
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        new StudentMenu(); // Launch the application
    }
}
