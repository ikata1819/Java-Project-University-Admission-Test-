package com.cse.ju.oop.views.screens;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SplashScreen extends JFrame {

    SplashScreen() {
        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Java Project Pictures/project_home.png"));
        Image i2 = i1.getImage().getScaledInstance(1500, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);

        // Set the layout manager
        setLayout(new BorderLayout());
        add(image, BorderLayout.CENTER); // Use BorderLayout to add the label

        // Initial frame settings
        setUndecorated(true);  // To remove window borders

        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Initial position and size of the frame
        int startWidth = 300;
        int startHeight = 200;

        // Center the window with the starting dimensions
        AtomicInteger x = new AtomicInteger((screenWidth - startWidth) / 2);
        AtomicInteger y = new AtomicInteger((screenHeight - startHeight) / 2);
        setBounds(x.get(), y.get(), startWidth, startHeight);

        // Create a timer to automatically close the window after 7 seconds
        Timer closeTimer = new Timer(7000, e -> dispose());
        closeTimer.setRepeats(false); // Only run once
        closeTimer.start();

        // Animate the window growth
        new Thread(() -> { // Use a new thread for the animation
            for (int z = 2; z <= 1000; z += 4) {
                int newWidth = startWidth + z;
                int newHeight = startHeight + z / 2;

                // Recalculate position to keep the frame centered
                x.set((screenWidth - newWidth) / 2);
                y.set((screenHeight - newHeight) / 2);

                // Update frame position and size
                setBounds(x.get(), y.get(), newWidth, newHeight);

                // Slow down the animation for visibility
                try {
                    Thread.sleep(10);  // Adjust to control speed of growth
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Finally, make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new SplashScreen();
    }
}
