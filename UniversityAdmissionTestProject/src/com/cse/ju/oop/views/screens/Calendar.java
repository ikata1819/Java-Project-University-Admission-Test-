package com.cse.ju.oop.views.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calendar extends JFrame {

    public Calendar() {
        setTitle("Academic Calendar");
        setSize(1000, 800); // Increase frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Load Background Image using ClassLoader
        ImageIcon backgroundImageIcon = new ImageIcon(ClassLoader.getSystemResource("Java Project Pictures/ju mh.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setLayout(null);
        backgroundLabel.setBounds(0, 0, 1000, 800);
        add(backgroundLabel);

        // Load Logo using ClassLoader
        ImageIcon logoImageIcon = new ImageIcon(ClassLoader.getSystemResource("Java Project Pictures/ju logo png.png"));
        Image logoImage = logoImageIcon.getImage().getScaledInstance(80, 110, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setBounds(425, 20, 150, 150); // Centered based on the new frame size
        backgroundLabel.add(logoLabel);

        // Heading
        JLabel headingLabel = new JLabel("Jahangirnagar University");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 32));
        headingLabel.setForeground(new Color(255, 255, 204)); // Light yellow color
        headingLabel.setBounds(300, 190, 400, 40);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.add(headingLabel);

        // Menu Buttons
        String[] years = {"2024-25", "2023-24", "2022-23", "2021-22", "2020-21"};
        for (int i = 0; i < years.length; i++) {
            JButton menuButton = new JButton("Academic Calendar " + years[i]);
            menuButton.setBounds(390, 320 + (i * 60), 250, 50); // Adjusted button position for centering
            menuButton.setBackground(new Color(204, 255, 204)); // Pastel green
            menuButton.setForeground(Color.BLACK);
            menuButton.addActionListener(new MenuButtonActionListener(years[i]));
            backgroundLabel.add(menuButton);
        }

        // Home Button
        JButton homeButton = new JButton("Home");
        homeButton.setBounds(440, 250, 130, 35); // Adjusted position
        homeButton.setBackground(new Color(10, 250, 110)); // Pastel green
        homeButton.setForeground(Color.BLACK);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Homescreen(); // Assuming Homescreen is another JFrame
                dispose(); // Close the current frame
            }
        });
        backgroundLabel.add(homeButton);
        setVisible(true);
    }

    private class MenuButtonActionListener implements ActionListener {
        private String year;

        public MenuButtonActionListener(String year) {
            this.year = year;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Path to the calendar image file
            String calendarImagePath = "Java Project Pictures/calendar_" + year + ".png";
            JFrame calendarFrame = new JFrame("Calendar " + year);
            calendarFrame.setSize(800, 600); // Fixed frame size
            calendarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            calendarFrame.setLocationRelativeTo(null); // Center the frame on the screen

            // Load and resize the calendar image to fit the frame
            ImageIcon calendarImageIcon = new ImageIcon(ClassLoader.getSystemResource(calendarImagePath));
            Image calendarImage = calendarImageIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            JLabel calendarLabel = new JLabel(new ImageIcon(calendarImage));

            calendarFrame.add(calendarLabel);
            calendarFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calendar();
        });
    }
}
