package com.cse.ju.oop.views.screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame {

    AdminMenu() {
        setSize(1535, 850);
        setLayout(null); // Set layout to null for absolute positioning

        // Load and set background image
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Java Project Pictures/halls.png"));
        Image i2 = i.getImage().getScaledInstance(1530, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1540, 750); // Set bounds for the background image
        add(image);

        // Add "Jahangirnagar University" in the middle of the image
        JLabel universityLabel = new JLabel("J a h a n g i r n a g a r   U n i v e r s i t y", JLabel.CENTER);
        universityLabel.setFont(new Font("Garamond", Font.ITALIC | Font.BOLD, 55));
        universityLabel.setForeground(Color.WHITE); // Set text color to white
        universityLabel.setBounds(0, 300, 1530, 100); // Position it in the middle of the image
        image.add(universityLabel);

        // JMenuBar setup
        JMenuBar mb = new JMenuBar();
        Font menuFont = new Font("Arial", Font.PLAIN, 24);  // Font size set to 24

        // List of Students Menu
        JMenu students = new JMenu("List of Students");
        students.setForeground(Color.BLUE);
        students.setFont(menuFont);
        mb.add(students);

        // Registered Students Menu with Submenus A-E
        JMenu registered = new JMenu("List of registered students");
        registered.setFont(menuFont);
        students.add(registered);

        // Create submenu items for each unit
        registered.add(createUnitMenuItem("A Unit"));
        registered.add(createUnitMenuItem("B Unit"));
        registered.add(createUnitMenuItem("C Unit"));
        registered.add(createUnitMenuItem("D Unit"));
        registered.add(createUnitMenuItem("E Unit"));

        // Set Venue and Schedule Menu
        JMenu venueAndSchedule = new JMenu("Set Venue and Schedule");
        venueAndSchedule.setForeground(Color.BLACK);
        venueAndSchedule.setFont(menuFont);
        mb.add(venueAndSchedule);

        // Create an instance of VenueAndSchedule for later use
        VenueAndSchedule venueAndScheduleObj = new VenueAndSchedule();

        // Venue and Schedule items for A-E units
        for (String unit : new String[]{"A Unit", "B Unit", "C Unit", "D Unit", "E Unit"}) {
            JMenuItem venueItem = new JMenuItem("Set venue and schedule for " + unit);
            venueItem.setFont(menuFont);
            venueAndSchedule.add(venueItem);

            // Add action listener
            venueItem.addActionListener(e -> {
                venueAndScheduleObj.createVenue(unit); // Pass the unit to the createVenue method
            });
        }

        // See Result Menu with Submenus for Male and Female for Units A-E
        JMenu seeResult = new JMenu("See Result");
        seeResult.setForeground(Color.BLUE);
        seeResult.setFont(menuFont);
        mb.add(seeResult);

        JMenu resultUnitA = new JMenu("See result for A Unit");
        JMenuItem maleResultA = new JMenuItem("Male");
        JMenuItem femaleResultA = new JMenuItem("Female");
        resultUnitA.setFont(menuFont);
        maleResultA.setFont(menuFont);
        femaleResultA.setFont(menuFont);
        resultUnitA.add(maleResultA);
        resultUnitA.add(femaleResultA);

        JMenu resultUnitB = new JMenu("See result for B Unit");
        JMenuItem maleResultB = new JMenuItem("Male");
        JMenuItem femaleResultB = new JMenuItem("Female");
        resultUnitB.setFont(menuFont);
        maleResultB.setFont(menuFont);
        femaleResultB.setFont(menuFont);
        resultUnitB.add(maleResultB);
        resultUnitB.add(femaleResultB);

        JMenu resultUnitC = new JMenu("See result for C Unit");
        JMenuItem maleResultC = new JMenuItem("Male");
        JMenuItem femaleResultC = new JMenuItem("Female");
        resultUnitC.setFont(menuFont);
        maleResultC.setFont(menuFont);
        femaleResultC.setFont(menuFont);
        resultUnitC.add(maleResultC);
        resultUnitC.add(femaleResultC);

        JMenu resultUnitD = new JMenu("See result for D Unit");
        JMenuItem maleResultD = new JMenuItem("Male");
        JMenuItem femaleResultD = new JMenuItem("Female");
        resultUnitD.setFont(menuFont);
        maleResultD.setFont(menuFont);
        femaleResultD.setFont(menuFont);
        resultUnitD.add(maleResultD);
        resultUnitD.add(femaleResultD);

        JMenu resultUnitE = new JMenu("See result for E Unit");
        JMenuItem maleResultE = new JMenuItem("Male");
        JMenuItem femaleResultE = new JMenuItem("Female");
        resultUnitE.setFont(menuFont);
        maleResultE.setFont(menuFont);
        femaleResultE.setFont(menuFont);
        resultUnitE.add(maleResultE);
        resultUnitE.add(femaleResultE);

        seeResult.add(resultUnitA);
        seeResult.add(resultUnitB);
        seeResult.add(resultUnitC);
        seeResult.add(resultUnitD);
        seeResult.add(resultUnitE);

        // Logout Menu
        JMenu logout = new JMenu("Logout");
        logout.setForeground(Color.BLACK);
        logout.setFont(menuFont);
        mb.add(logout);

        JMenuItem lout = new JMenuItem("Logout");
        JMenuItem exit = new JMenuItem("Exit Page");
        lout.setFont(menuFont);
        exit.setFont(menuFont);
        logout.add(lout);
        logout.add(exit);
        setJMenuBar(mb);

// Set Action Listeners for the logout options
        exit.addActionListener(e -> System.exit(0));

        lout.addActionListener(e -> {
            // Display a confirmation dialog before logging out
            int response = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to log out?",
                    "Logout Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            // If the user confirms logout, navigate to HomeScreen
            if (response == JOptionPane.YES_OPTION) {
                // Assuming HomeScreen has a constructor that accepts no parameters
//                Homescreen homeScreen = new Homescreen();
//                homeScreen.setVisible(true); // Make the HomeScreen visible

                // Close the current frame
                this.dispose(); // Closes the current window/frame
            }
        });




        setVisible(true); // Set the JFrame visible
        setLocationRelativeTo(null); // Center the JFrame on the screen
    }

    private JMenuItem createUnitMenuItem(String unit) {
        JMenuItem menuItem = new JMenuItem(unit);
        menuItem.setFont(new Font("Arial", Font.PLAIN, 24));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action when a unit is clicked
                String tableName = unit.toLowerCase().replace(" unit", "") + "_unit_apply";
                new StudentTableViewer(tableName);
            }
        });
        return menuItem;
    }

    public static void main(String[] args) {
        new AdminMenu();
    }
}
