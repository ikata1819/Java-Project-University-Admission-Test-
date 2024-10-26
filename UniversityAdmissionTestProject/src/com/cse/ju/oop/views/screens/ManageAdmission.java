package com.cse.ju.oop.views.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManageAdmission extends JFrame implements ActionListener {

    JButton login, cancel, forgetPassword;
    JTextField tfName;
    JPasswordField tfPassword;

    ManageAdmission() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(40, 20, 100, 20);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(150, 20, 150, 20);
        add(tfName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 70, 100, 20);
        add(lblPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(150, 70, 150, 20);
        add(tfPassword);

        login = new JButton("Login");
        login.setBounds(40, 120, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 120, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        forgetPassword = new JButton("Forget Password");
        forgetPassword.setBounds(100, 170, 160, 30);
        forgetPassword.setBackground(Color.BLACK);
        forgetPassword.setForeground(Color.WHITE);
        forgetPassword.addActionListener(this);
        forgetPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(forgetPassword);

        setSize(400, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String name = tfName.getText();
            String password = new String(tfPassword.getPassword());

            // Check if fields are empty
            if (name.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
            } else if (password.equals("juadmission")) { // Check if password matches
                JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + name);
                setVisible(false);
                new AdminMenu(); // Call the existing AdminMenu class
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password. Please try again.");
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false); // Close the window
        } else if (ae.getSource() == forgetPassword) {
            JOptionPane.showMessageDialog(null, "Please contact admin to reset your password.");
        }
    }

    public static void main(String[] args) {
        new ManageAdmission();
    }
}
