package com.cse.ju.oop.views.screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class Homescreen extends JFrame {

    private JLabel imageLabel;
    private String[] images = {"/Java Project Pictures/sonsoptok hori.jpg", "/Java Project Pictures/oe.jpg"};
    private int currentImageIndex = 0;

    public Homescreen() {
        // Show splash screen first
        showSplashScreen();

        // After splash screen is shown, set up the main frame
        setupMainFrame();
    }

    private void showSplashScreen() {
        // Create a new JFrame for the splash screen (undecorated)
        JFrame splashFrame = new JFrame();
        splashFrame.setUndecorated(true); // Remove borders and title bar
        splashFrame.setSize(1535, 850);
        splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashFrame.setLocationRelativeTo(null);
        splashFrame.setLayout(new BorderLayout());

        // Load the initial splash image
        ImageIcon originalSplashImage = new ImageIcon(getClass().getResource("/Java Project Pictures/project_home.png"));

        // Resize the image to fit the frame while maintaining the aspect ratio
        Image splashImage = originalSplashImage.getImage();
        Image resizedImage = splashImage.getScaledInstance(1535, 850, Image.SCALE_SMOOTH);

        // Set the resized image to JLabel
        JLabel splashLabel = new JLabel(new ImageIcon(resizedImage));
        splashLabel.setHorizontalAlignment(SwingConstants.CENTER);
        splashFrame.add(splashLabel, BorderLayout.CENTER);

        // Display the splash screen
        splashFrame.setVisible(true);

        // Timer to close the splash screen and show the main screen after 4 seconds
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashFrame.dispose(); // Close splash screen
                setVisible(true); // Show main frame
            }
        });
        timer.setRepeats(false); // Only run once
        timer.start();
    }

    private void setupMainFrame() {
        // Set up the main frame
        setTitle("Home Screen - Jahangirnagar University");
        setSize(1535, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // For absolute positioning

        // Set a light pastel blue background panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(227, 242, 253)); // Soft light blue background
        mainPanel.setBounds(0, 0, 1530, 850);
        mainPanel.setLayout(null);
        add(mainPanel);

        // Top bar for logo, university name, and contact information
        JPanel topBar = new JPanel();
        topBar.setLayout(new BorderLayout());
        topBar.setBounds(10, 0, 1510, 65); // Adjusted to fit above the menu bar
        topBar.setBackground(Color.WHITE);

        // Left side with logo and "Jahangirnagar University"
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0)); // Left-aligned
        logoPanel.setBackground(Color.WHITE);

        // Add JU logo
        JLabel logoLabel = new JLabel(loadAndResizeImage("/Java Project Pictures/ju logo png.png", 40, 65)); // Adjust size
        logoPanel.add(logoLabel);

        // Add university name beside the logo
        JLabel uniNameLabel = new JLabel("Jahangirnagar University");
        uniNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Blue color for university name
        uniNameLabel.setForeground(new Color(74, 144, 226));
        logoPanel.add(uniNameLabel);

        // Right side with contact info and icons
        JPanel contactPanel = new JPanel();
        contactPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5)); // Right-aligned
        contactPanel.setBackground(Color.WHITE);

        // Adding contact info with icons
        JLabel phoneIcon = new JLabel(loadAndResizeImage("/icons/icon phn.png", 20, 20)); // Adjust size
        JLabel phoneLabel = new JLabel("02224491045-51");
        JLabel faxIcon = new JLabel(loadAndResizeImage("/icons/icon fax.png", 20, 20)); // Adjust size
        JLabel faxLabel = new JLabel("Fax: 02224491052");
        JLabel emailIcon = new JLabel(loadAndResizeImage("/icons/icon email.png", 20, 20)); // Adjust size
        JLabel emailLabel = new JLabel("registrar@juniv.edu");

        phoneLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        faxLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        contactPanel.add(phoneIcon);
        contactPanel.add(phoneLabel);
        contactPanel.add(faxIcon);
        contactPanel.add(faxLabel);
        contactPanel.add(emailIcon);
        contactPanel.add(emailLabel);

        topBar.add(logoPanel, BorderLayout.WEST);
        topBar.add(contactPanel, BorderLayout.EAST);

        mainPanel.add(topBar);

        // Welcome message at the very top
        JLabel welcomeMessageLabel = new JLabel("Welcome to Jahangirnagar University!");
        welcomeMessageLabel.setFont(new Font("Georgia", Font.ITALIC, 32)); // Beautiful italic font
        welcomeMessageLabel.setForeground(new Color(74, 144, 226));
        welcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeMessageLabel.setBounds(0, 60, 1535, 40); // Position the welcome message below the top bar
        mainPanel.add(welcomeMessageLabel);

        // Top menu panel setup
        JPanel menuPanel = new JPanel(new GridLayout(1, 8, 20, 0)); // Added gap between buttons for separation
        menuPanel.setBounds(10, 120, 1510, 50); // Positioned at the top of the screen with padding
        menuPanel.setBackground(new Color(227, 242, 253)); // Same background as the main panel

        // Add menu buttons with alternating colors and new fonts
        String[] menuItems = {"Home", "Calendar", "Calculator", "Notebook", "Faculties & Institutes", "Admission", "Manage Admission"};
        Font menuFont = new Font("Segoe UI", Font.BOLD, 16); // Modern sans-serif font
        Color[] buttonColors = {new Color(74, 144, 226), new Color(136, 192, 87)}; // Alternate colors: darker blue and pastel green
        for (int i = 0; i < menuItems.length; i++) {
            JButton button = new JButton(menuItems[i]);
            button.setFont(menuFont);
            button.setForeground(Color.WHITE);
            button.setBackground(buttonColors[i % 2]); // Alternating color for buttons
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Dark border
            button.addActionListener(new MenuButtonListener(menuItems[i]));
            menuPanel.add(button);
        }
        mainPanel.add(menuPanel);

        // Left panel with vertical menu (ABOUT JU, Vision & Mission) - alternating colors
        JPanel leftPanel = new JPanel(new GridLayout(4, 1, 0, 10)); // Added vertical gaps between buttons
        leftPanel.setBounds(10, 180, 150, 600); // Positioned on the left side of the screen
        leftPanel.setBackground(new Color(227, 242, 253)); // Light pastel blue background

        JButton aboutButton = createStyledButton("ABOUT JU", new Color(136, 192, 87));
        JButton visionButton = createStyledButton("VISION & MISSION", new Color(74, 144, 226));
        JButton actButton = createStyledButton("Act & Ordinances", new Color(136, 192, 87));
        JButton galleryButton = createStyledButton("GALLERY", new Color(74, 144, 226));

        leftPanel.add(aboutButton);
        leftPanel.add(visionButton);
        leftPanel.add(actButton);
        leftPanel.add(galleryButton);
        mainPanel.add(leftPanel);

        // Center panel for the image slideshow
        imageLabel = new JLabel();
        imageLabel.setIcon(loadAndResizeImage(images[currentImageIndex], 850, 450));
        imageLabel.setBounds(350, 175, 800, 500); // Adjusted the size and position of the image slideshow
        mainPanel.add(imageLabel);

        // Timer for automatic image switching
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1) % images.length;
                imageLabel.setIcon(loadAndResizeImage(images[currentImageIndex], 850, 450)); // Resize for slideshow
            }
        });
        timer.start();

        // Right panel for welcome text and VC information
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBounds(1250, 195, 350, 500); // Positioned on the right side
        rightPanel.setBackground(new Color(227, 242, 253)); // Light pastel blue background

        // Add VC image and information
        JLabel vcImageLabel = new JLabel(loadAndResizeImage("/Java Project Pictures/vc sir.png", 150, 200)); // Adjust size of VC image
        JLabel vcNameLabel = new JLabel("Dr. Mohammad Kamrul Ahsan");
        JLabel vcTitleLabel = new JLabel("Vice Chancellor");
        vcNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        vcTitleLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));

        rightPanel.add(vcImageLabel);
        rightPanel.add(vcNameLabel);
        rightPanel.add(vcTitleLabel);
        mainPanel.add(rightPanel);
        setVisible(false);
        addScrollingNoticeBar(mainPanel);
        // Initially hidden until splash is done
    }
// Add this code to your existing Homescreen class

    private void addScrollingNoticeBar(JPanel mainPanel) {
        // Panel for the notice bar
        JPanel noticePanel = new JPanel();
        noticePanel.setLayout(null); // Absolute positioning
        noticePanel.setBounds(400, 700, 1510, 30); // Positioned at the bottom of the screen as per your original settings
        noticePanel.setBackground(new Color(227, 242, 253)); // Light pastel blue background

        // "NOTICE" button on the left side
        JButton noticeButton = new JButton("NOTICE");
        noticeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        noticeButton.setForeground(Color.WHITE);
        noticeButton.setBackground(new Color(74, 144, 226)); // Blue background
        noticeButton.setFocusPainted(false);
        noticeButton.setBounds(0, 0, 100, 30); // Size and position of the button
        noticePanel.add(noticeButton);

        // Scrolling text label for the notice message
        JLabel scrollingTextLabel = new JLabel("Exam date will be published soon");
        scrollingTextLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        scrollingTextLabel.setForeground(Color.BLACK);
        scrollingTextLabel.setBounds(noticePanel.getWidth(), 0, 1380, 30); // Start position outside the visible area
        noticePanel.add(scrollingTextLabel);

        // Timer for scrolling the text from right to left
        Timer scrollTimer = new Timer(30, new ActionListener() {
            int xPos = scrollingTextLabel.getX();

            @Override
            public void actionPerformed(ActionEvent e) {
                xPos--; // Move text to the left by 1 pixel
                if (xPos + scrollingTextLabel.getWidth() < 0) {
                    xPos = noticePanel.getWidth(); // Reset position to the right edge when out of view
                }
                scrollingTextLabel.setLocation(xPos, scrollingTextLabel.getY());
            }
        });
        scrollTimer.start();

        mainPanel.add(noticePanel); // Add the notice panel to the main panel
    }


    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Dark border
        button.setPreferredSize(new Dimension(150, 30)); // Preferred size
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
        button.addActionListener(new MenuButtonListener(text)); // Link to listener
        return button;
    }

    private ImageIcon loadAndResizeImage(String imagePath, int width, int height) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
            Image img = imageIcon.getImage();
            Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            System.out.println("Error loading image: " + imagePath);
            return null;
        }
    }

    private class MenuButtonListener implements ActionListener {
        private String buttonName;

        public MenuButtonListener(String buttonName) {
            this.buttonName = buttonName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                switch (buttonName) {
                    case "Calculator":
                        // Open calculator
                        Runtime.getRuntime().exec("calc");
                        break;
                    case "Notebook":
                        // Open notepad
                        Runtime.getRuntime().exec("notepad");
                        break;
                    case "Manage Admission":
                        // Open the Manage Admission page
                        new ManageAdmission();
                        //dispose();
                        break;
                    case "Faculties & Institutes":
                        // Open the Faculties and Institutes page
                        new FacultiesAndInstitutes();
                        dispose();
                        break;
                    case "Calendar":
                        // Open the Calendar page
                        new Calendar(); // Ensure Calendar class is properly defined and accessible
                        dispose();
                        break;
                        case "ABOUT JU":
                            showAboutJU(); // Show about JU information
                            break;
                    case "VISION & MISSION":
                        showVisionAndMission(); // Show vision and mission information
                        break;
                    case "Admission":
                        // Open the Calendar page
                        new StudentMenu(); // Ensure Calendar class is properly defined and accessible
                        dispose();
                        break;
                    case "Act & Ordinances":
                        // Open the Act & Ordinances link in the default browser
                        Desktop.getDesktop().browse(new URI("https://juniv.edu/file/11395e"));
                        break;
                    case "GALLERY":
                        JOptionPane.showMessageDialog(null, "Gallery under maintenance");
                           break;
                    default:
                        // For other buttons, show a message
                        JOptionPane.showMessageDialog(null, buttonName + " button clicked!");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Unable to open " + buttonName);
            }
        }
    }

    private void showAboutJU() {
        // Create a new JFrame for "ABOUT JU" information
        JFrame aboutJUFrame = new JFrame("About Jahangirnagar University");
        aboutJUFrame.setSize(1500, 700);
        aboutJUFrame.setLocationRelativeTo(null); // Center the frame
        aboutJUFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close

        // Add content to the frame
        JTextArea textArea = new JTextArea();
        textArea.setText("Jahangirnagar University, accustomed as a fully residential public university established in 1970, has now 36 departments and six faculties along with four institutes, with more than fifteen thousand students, and about five hundred academics dedicated to teaching and research. The sprawling campus is located 30 kilometres from the capital Dhaka, well connected with a national highway.\n\n"
                + "The first assembly of Independent Bangladesh granted the university its Charter in 1973 under which the university is currently being operated.\n\n"
                + "The badge of the university bears the national flower ‘white lily’ (Lilium candidum) with three petals surrounded by strips of a beautiful floral design with the name of the university in Bangla ensconcing in a semi-circle like a band of flowers.\n\n"
                + "Located at Savar near Dhaka, Jahangirnagar University is one of the leading universities in Bangladesh. The University is residential. It was formally launched on 12 January 1971 by its first governor Rear Admiral S.M. Ahsan, Governor of former East Pakistan. After the emergence of Bangladesh, the Government passed the Jahangirnagar University Act, 1973, which repealed the previous charter and renamed the University as Jahangirnagar University.\n\n"
                + "About: Jahangirnagar University (JU)\n"
                + "Name: Jahangirnagar University\n"
                + "Type: Public University\n"
                + "Establishment: 20th August, 1970\n"
                + "Governed By: The Jahangirnagar University Act, 1973\n"
                + "Academic Year: 1st July to 30th June\n"
                + "Postal Address: Savar, Dhaka, Bangladesh, 1342\n"
                + "Land Area: 697.56 Acre\n\n"
                + "Contact:\n"
                + "PABX: 7791045-51\n"
                + "Fax: 880-2-7791052\n"
                + "E-mail: registrar@juniv.edu\n"
                + "Website: https://juniv.edu");
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        aboutJUFrame.add(scrollPane);

        aboutJUFrame.setVisible(true); // Make the frame visible
    }

    private void showVisionAndMission() {
        // Create a new JFrame for "VISION & MISSION" information
        JFrame visionFrame = new JFrame("Vision & Mission of Jahangirnagar University");
        visionFrame.setSize(1500, 700);
        visionFrame.setLocationRelativeTo(null); // Center the frame
        visionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close

        // Add content to the frame
        JTextArea textArea = new JTextArea();
        textArea.setText("Vision\n"
                + "Promoting and advancing world-class higher education in the University.\n\n"
                + "Mission\n"
                + "1. Creating skilled and trained human resources through enhancing the quality of higher education in the University, technology-based education, communication with the outside world, and expanding national and international collaboration and research activities.\n\n"
                + "2. Contributing to Vision 2041 by ensuring education with the spirit of liberation war and playing a functional role in raising the standard of higher education internationally.");
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        visionFrame.add(scrollPane);

        visionFrame.setVisible(true); // Make the frame visible
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Homescreen::new); // Run the GUI on the Event Dispatch Thread
    }
}