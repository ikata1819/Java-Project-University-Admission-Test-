package com.cse.ju.oop.views.screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registration extends JFrame implements ActionListener {

    JTextField tfName, tfFatherName, tfMotherName, tfSSCBoard, tfSSCResult, tfHSCBoard, tfHSCResult, tfAddress, tfPhone, tfEmail;
    JTextField tfSSCRoll, tfHSCRoll, tfHSCRegNo; // New fields for SSC roll, HSC roll, and HSC registration number
    JPasswordField tfPassword; // Password field
    JButton register, cancel;

    Registration() {

        // Frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Font settings
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font textFont = new Font("Arial", Font.PLAIN, 14);
        Color labelColor = new Color(50, 50, 150); // Dark blue color
        Color bgColor = new Color(230, 230, 250); // Light lavender background
        Color buttonColor = new Color(70, 130, 180); // Steel blue for buttons

        // Name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(40, 20, 120, 30); // Extra space between label and text box
        lblName.setFont(labelFont);
        lblName.setForeground(labelColor);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 20, 200, 30);
        tfName.setFont(textFont);
        tfName.setBackground(bgColor);
        add(tfName);

        // Father's Name
        JLabel lblFatherName = new JLabel("Father's Name");
        lblFatherName.setBounds(40, 70, 150, 30);
        lblFatherName.setFont(labelFont);
        lblFatherName.setForeground(labelColor);
        add(lblFatherName);

        tfFatherName = new JTextField();
        tfFatherName.setBounds(200, 70, 200, 30);
        tfFatherName.setFont(textFont);
        tfFatherName.setBackground(bgColor);
        add(tfFatherName);

        // Mother's Name
        JLabel lblMotherName = new JLabel("Mother's Name");
        lblMotherName.setBounds(40, 120, 150, 30);
        lblMotherName.setFont(labelFont);
        lblMotherName.setForeground(labelColor);
        add(lblMotherName);

        tfMotherName = new JTextField();
        tfMotherName.setBounds(200, 120, 200, 30);
        tfMotherName.setFont(textFont);
        tfMotherName.setBackground(bgColor);
        add(tfMotherName);

        // Password
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 170, 120, 30);
        lblPassword.setFont(labelFont);
        lblPassword.setForeground(labelColor);
        add(lblPassword);

        tfPassword = new JPasswordField(); // Use JPasswordField for password input
        tfPassword.setBounds(200, 170, 200, 30);
        tfPassword.setFont(textFont);
        tfPassword.setBackground(bgColor);
        add(tfPassword);

        // SSC Roll
        JLabel lblSSCRoll = new JLabel("SSC Roll");
        lblSSCRoll.setBounds(40, 220, 150, 30);
        lblSSCRoll.setFont(labelFont);
        lblSSCRoll.setForeground(labelColor);
        add(lblSSCRoll);

        tfSSCRoll = new JTextField();
        tfSSCRoll.setBounds(200, 220, 200, 30);
        tfSSCRoll.setFont(textFont);
        tfSSCRoll.setBackground(bgColor);
        add(tfSSCRoll);

        // SSC Board
        JLabel lblSSCBoard = new JLabel("SSC Board");
        lblSSCBoard.setBounds(40, 270, 150, 30);
        lblSSCBoard.setFont(labelFont);
        lblSSCBoard.setForeground(labelColor);
        add(lblSSCBoard);

        tfSSCBoard = new JTextField();
        tfSSCBoard.setBounds(200, 270, 200, 30);
        tfSSCBoard.setFont(textFont);
        tfSSCBoard.setBackground(bgColor);
        add(tfSSCBoard);

        // SSC Result
        JLabel lblSSCResult = new JLabel("SSC Result");
        lblSSCResult.setBounds(40, 320, 150, 30);
        lblSSCResult.setFont(labelFont);
        lblSSCResult.setForeground(labelColor);
        add(lblSSCResult);

        tfSSCResult = new JTextField();
        tfSSCResult.setBounds(200, 320, 200, 30);
        tfSSCResult.setFont(textFont);
        tfSSCResult.setBackground(bgColor);
        add(tfSSCResult);

        // HSC Roll
        JLabel lblHSCRoll = new JLabel("HSC Roll");
        lblHSCRoll.setBounds(40, 370, 150, 30);
        lblHSCRoll.setFont(labelFont);
        lblHSCRoll.setForeground(labelColor);
        add(lblHSCRoll);

        tfHSCRoll = new JTextField();
        tfHSCRoll.setBounds(200, 370, 200, 30);
        tfHSCRoll.setFont(textFont);
        tfHSCRoll.setBackground(bgColor);
        add(tfHSCRoll);

        // HSC Registration Number
        JLabel lblHSCRegNo = new JLabel("HSC Reg No.");
        lblHSCRegNo.setBounds(40, 420, 150, 30);
        lblHSCRegNo.setFont(labelFont);
        lblHSCRegNo.setForeground(labelColor);
        add(lblHSCRegNo);

        tfHSCRegNo = new JTextField();
        tfHSCRegNo.setBounds(200, 420, 200, 30);
        tfHSCRegNo.setFont(textFont);
        tfHSCRegNo.setBackground(bgColor);
        add(tfHSCRegNo);

        // HSC Board
        JLabel lblHSCBoard = new JLabel("HSC Board");
        lblHSCBoard.setBounds(40, 470, 150, 30);
        lblHSCBoard.setFont(labelFont);
        lblHSCBoard.setForeground(labelColor);
        add(lblHSCBoard);

        tfHSCBoard = new JTextField();
        tfHSCBoard.setBounds(200, 470, 200, 30);
        tfHSCBoard.setFont(textFont);
        tfHSCBoard.setBackground(bgColor);
        add(tfHSCBoard);

        // HSC Result
        JLabel lblHSCResult = new JLabel("HSC Result");
        lblHSCResult.setBounds(40, 520, 150, 30);
        lblHSCResult.setFont(labelFont);
        lblHSCResult.setForeground(labelColor);
        add(lblHSCResult);

        tfHSCResult = new JTextField();
        tfHSCResult.setBounds(200, 520, 200, 30);
        tfHSCResult.setFont(textFont);
        tfHSCResult.setBackground(bgColor);
        add(tfHSCResult);

        // Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(40, 570, 150, 30);
        lblAddress.setFont(labelFont);
        lblAddress.setForeground(labelColor);
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 570, 200, 30);
        tfAddress.setFont(textFont);
        tfAddress.setBackground(bgColor);
        add(tfAddress);

        // Phone Number
        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(40, 620, 150, 30);
        lblPhone.setFont(labelFont);
        lblPhone.setForeground(labelColor);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(200, 620, 200, 30);
        tfPhone.setFont(textFont);
        tfPhone.setBackground(bgColor);
        add(tfPhone);

        // Email
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(40, 670, 150, 30);
        lblEmail.setFont(labelFont);
        lblEmail.setForeground(labelColor);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 670, 200, 30);
        tfEmail.setFont(textFont);
        tfEmail.setBackground(bgColor);
        add(tfEmail);

        // Register button
        register = new JButton("Register");
        register.setBounds(40, 720, 120, 40);
        register.setBackground(buttonColor);
        register.setForeground(Color.WHITE);
        register.setFont(new Font("Tahoma", Font.BOLD, 15));
        register.addActionListener(this);
        add(register);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 720, 120, 40);
        cancel.setBackground(buttonColor);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 50, 200, 200);
        add(image);
        // Frame settings
        setSize(700, 820);
        setLocation(500, 20);
        setVisible(true);
    }

    // Action handling for buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == register) {
            String name = tfName.getText();
            String fatherName = tfFatherName.getText();
            String motherName = tfMotherName.getText();
            String password = new String(tfPassword.getPassword()); // Get password as a string
            String sscRoll = tfSSCRoll.getText();
            String sscBoard = tfSSCBoard.getText();
            String sscResult = tfSSCResult.getText();
            String hscRoll = tfHSCRoll.getText();
            String hscRegNo = tfHSCRegNo.getText();
            String hscBoard = tfHSCBoard.getText();
            String hscResult = tfHSCResult.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();

            try {
                ConnReg conn = new ConnReg();
                String query = "INSERT INTO students (name, father_name, mother_name, password, ssc_roll, ssc_board, ssc_result, hsc_roll, hsc_reg_no, hsc_board, hsc_result, address, phone, email) " +
                        "VALUES ('" + name + "', '" + fatherName + "', '" + motherName + "', '" + password + "', '" + sscRoll + "', '" + sscBoard + "', '" + sscResult + "', '" + hscRoll + "', '" + hscRegNo + "', '" + hscBoard + "', '" + hscResult + "', '" + address + "', '" + phone + "', '" + email + "')";
                conn.s.executeUpdate(query);

                // Display success message after inserting data into the database
                JOptionPane.showMessageDialog(null, "Registration Successful!");

                // Close the frame after the success message is acknowledged
                dispose();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Unable to register. Please try again.");
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Registration();
    }
}
