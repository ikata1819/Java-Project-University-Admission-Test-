package com.cse.ju.oop.views.screens;

import javax.swing.*;
import java.awt.*;

public class FacultiesAndInstitutes extends JFrame {

    public FacultiesAndInstitutes() {
        setupFrame();
    }
    // Method to open a new page with faculty content
    private void openFacultyPage(String faculty) {
        String content = "";
        switch (faculty) {
            case "Faculty of Arts & Humanities":
                content = "The Faculty of Arts and Humanities at Jahangirnagar University offers a diverse array of programs designed to explore various aspects of human culture and society. With departments such as International Relations, English, History, and Fine Arts, this faculty aims to cultivate critical thinking, creativity, and a deep understanding of the arts and humanities. The faculty also encourages students to engage in research and cultural activities, enhancing their academic experience and preparing them for diverse career paths.";
                break;
            case "Faculty of Mathematical & Physical Sciences":
                content = "The Faculty of Mathematical and Physical Sciences is committed to advancing knowledge in the fields of mathematics, physics, and computer science. It offers programs in Computer Science and Engineering, Mathematics, Physics, and Environmental Sciences, among others. The faculty emphasizes both theoretical and practical aspects of these disciplines, fostering a research-oriented environment that equips students with the skills necessary for scientific innovation and technological advancement.";
                break;
            case "Faculty of Social Sciences":
                content = "The Faculty of Social Sciences at JU provides comprehensive education in various disciplines that analyze human behavior and societal structures. With departments like Economics, Anthropology, and Geography, the faculty focuses on equipping students with analytical skills and a profound understanding of social dynamics. Students are encouraged to engage in research and community outreach, promoting a strong connection between academic learning and real-world applications.";
                break;
            case "Faculty of Biological Sciences":
                content = "The Faculty of Biological Sciences offers programs in diverse fields such as Botany, Zoology, and Biotechnology. This faculty is dedicated to exploring the complexities of living organisms and their interactions with the environment. By providing a strong foundation in biological research, students are prepared for careers in healthcare, research, and environmental conservation. The faculty emphasizes hands-on experience and interdisciplinary collaboration to address pressing biological challenges.";
                break;
            case "Faculty of Business Studies":
                content = "The Faculty of Business Studies at Jahangirnagar University is designed to develop future business leaders and entrepreneurs. With programs in Finance, Marketing, and Management Studies, this faculty focuses on providing students with a solid understanding of business principles and practices. The curriculum is geared towards fostering critical thinking and practical skills, preparing graduates for successful careers in the dynamic world of business.";
                break;
            case "Faculty of Law":
                content = "The Faculty of Law at JU offers a comprehensive education in legal studies, preparing students to become proficient legal professionals. The curriculum covers various aspects of law, including constitutional law, criminal law, and international law. The faculty emphasizes practical training and critical analysis, equipping students with the skills needed to navigate the complexities of the legal system and advocate for justice.";
                break;
        }
        openPage(faculty, content);
    }

    // Method to open a new page with institute content
    private void openInstitutePage(String institute) {
        String content = "";
        switch (institute) {
            case "Institute of Business Administration":
                content = "The Institute of Business Administration (IBA) is one of the leading institutions for business education in Bangladesh. IBA provides an innovative curriculum that integrates theoretical knowledge with practical applications. It aims to develop leadership qualities and entrepreneurial skills among its students, preparing them for high-demand roles in the corporate world. The institute is known for its rigorous academic standards and a vibrant community of scholars.";
                break;
            case "Institute of Information Technology":
                content = "The Institute of Information Technology at Jahangirnagar University focuses on providing quality education in computer science and information technology. It offers programs that cover a range of topics, from software development to data analytics. The institute aims to equip students with the necessary skills to thrive in the fast-evolving tech industry, emphasizing hands-on experience and innovative thinking.";
                break;
            case "Institute of Remote Sensing and GIS":
                content = "The Institute of Remote Sensing and GIS focuses on advanced studies in geospatial technologies and their applications. It offers programs that equip students with the skills to analyze and interpret geographical data using modern tools and techniques. The institute plays a crucial role in research and practical applications related to environmental monitoring, urban planning, and disaster management.";
                break;
            case "Institute of Comparative Literature and Culture":
                content = "This institute is dedicated to the study and promotion of comparative literature and cultural studies. It offers programs that encourage critical analysis of literary works from various cultures, fostering a deeper understanding of global literary traditions. The Bangabandhu Institute aims to create a platform for interdisciplinary research and cultural exchange, enriching the academic landscape of JU.";
                break;
        }
        openPage(institute, content);
    }
    private void setupFrame() {
        // Frame setup
        setTitle("Faculties & Institutes - Jahangirnagar University");
        setSize(1535, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Main panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 1530, 850);
        add(mainPanel);

        // Load the background image
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Java Project Pictures/CSE.jpg"));
        Image i2 = i.getImage().getScaledInstance(1530, 850, Image.SCALE_DEFAULT); // Adjusted to full frame size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel backgroundLabel = new JLabel(i3);
        backgroundLabel.setBounds(0, 0, 1530, 850);
        mainPanel.add(backgroundLabel);
        backgroundLabel.setLayout(null); // Allow adding components directly on the background label

        // Load the logo image
        ImageIcon originalLogoIcon = new ImageIcon(getClass().getResource("/Java Project Pictures/ju logo png.png"));
        Image logoImage = originalLogoIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(resizedLogoIcon);
        logoLabel.setBounds(715, 10, 100, 120); // Adjusted position to be closer to the top
        backgroundLabel.add(logoLabel);

        // Add Jahangirnagar University heading centered below the logo
        JLabel universityLabel = new JLabel("Jahangirnagar University");
        universityLabel.setFont(new Font("Garamond", Font.BOLD, 40));
        universityLabel.setForeground(new Color(105, 10, 105));
        universityLabel.setBounds(465, 110, 600, 50); // Center the heading below the logo
        universityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.add(universityLabel);

        // Home button centered below the heading
        JButton homeButton = createStyledButton("Home", new Color(25, 182, 193)); // Light blue color
        homeButton.setBounds(690, 180, 150, 40); // Position the home button below the heading, centered
        backgroundLabel.add(homeButton);
        homeButton.addActionListener(e -> {
            new Homescreen(); // Ensure you have a Homescreen class implemented
            dispose();
        });

        // Left panel for faculties
        JPanel facultiesPanel = new JPanel();
        facultiesPanel.setLayout(null);
        facultiesPanel.setBounds(50, 250, 600, 600); // Adjusted position
        facultiesPanel.setOpaque(false);
        backgroundLabel.add(facultiesPanel);

        JLabel facultiesLabel = new JLabel("Faculties");
        facultiesLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        facultiesLabel.setForeground(new Color(105, 10, 105));
        facultiesLabel.setBounds(20, 20, 200, 40);
        facultiesPanel.add(facultiesLabel);

        // Faculty buttons setup
        String[] faculties = {
                "Faculty of Arts & Humanities",
                "Faculty of Mathematical & Physical Sciences",
                "Faculty of Social Sciences",
                "Faculty of Biological Sciences",
                "Faculty of Business Studies",
                "Faculty of Law"
        };

        int yPosition = 80;
        for (String faculty : faculties) {
            JButton facultyButton = createStyledButton(faculty, new Color(255, 182, 193)); // Pastel pink
            facultyButton.setBounds(20, yPosition, 550, 40);
            facultiesPanel.add(facultyButton);
            yPosition += 60;
            facultyButton.addActionListener(e -> openFacultyPage(faculty));
        }

        // Right panel for institutes
        JPanel institutesPanel = new JPanel();
        institutesPanel.setLayout(null);
        institutesPanel.setBounds(800, 250, 600, 600); // Adjusted position
        institutesPanel.setOpaque(false);
        backgroundLabel.add(institutesPanel);

        JLabel institutesLabel = new JLabel("Institutes");
        institutesLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        institutesLabel.setForeground(new Color(105, 10, 105));
        institutesLabel.setBounds(20, 20, 200, 40);
        institutesPanel.add(institutesLabel);

        // Institute buttons setup
        String[] institutes = {
                "Institute of Business Administration",
                "Institute of Information Technology",
                "Institute of Remote Sensing and GIS",
                "Institute of Comparative Literature and Culture"
        };

        yPosition = 80;
        for (String institute : institutes) {
            JButton instituteButton = createStyledButton(institute, new Color(255, 182, 193)); // Pastel pink
            instituteButton.setBounds(20, yPosition, 550, 40);
            institutesPanel.add(instituteButton);
            yPosition += 60;
            instituteButton.addActionListener(e -> openInstitutePage(institute));
        }

        setVisible(true);
    }


    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(147, 112, 219), 2));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    // Method to open a new content frame
    private void openPage(String title, String content) {
        JFrame contentFrame = new JFrame(title);
        contentFrame.setSize(600, 400);
        contentFrame.setLocationRelativeTo(null);
        contentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(255, 255, 255));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(147, 112, 219));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(content);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(245, 245, 245));
        contentPanel.add(textArea, BorderLayout.CENTER);

        contentFrame.add(contentPanel);
        contentFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FacultiesAndInstitutes::new);
    }
}
