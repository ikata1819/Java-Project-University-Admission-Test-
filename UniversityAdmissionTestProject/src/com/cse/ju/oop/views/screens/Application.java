package com.cse.ju.oop.views.screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Application extends JFrame implements ActionListener {

    // UI Components
    JTextField tfName, tfFatherName, tfSSCRoll, tfHSCRoll, tfTransactionID;
    JComboBox<String> cbUnit;
    JButton checkEligibility, cancel, payment;
    JTextArea resultArea;
    JLabel lblTransactionID;

    Application() {
        // Frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Font settings
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font textFont = new Font("Arial", Font.PLAIN, 14);
        Color labelColor = new Color(50, 50, 150);
        Color bgColor = new Color(230, 230, 250);
        Color buttonColor = new Color(70, 130, 180);

        // Name
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(40, 20, 120, 30);
        lblName.setFont(labelFont);
        lblName.setForeground(labelColor);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 20, 200, 30);
        tfName.setFont(textFont);
        tfName.setBackground(bgColor);
        add(tfName);

        // Father's Name
        JLabel lblFatherName = new JLabel("Father's Name:");
        lblFatherName.setBounds(40, 60, 120, 30);
        lblFatherName.setFont(labelFont);
        lblFatherName.setForeground(labelColor);
        add(lblFatherName);

        tfFatherName = new JTextField();
        tfFatherName.setBounds(200, 60, 200, 30);
        tfFatherName.setFont(textFont);
        tfFatherName.setBackground(bgColor);
        add(tfFatherName);

        // Unit Selection
        JLabel lblUnit = new JLabel("Select a Unit (A, B, C, D, E):");
        lblUnit.setBounds(40, 100, 250, 30);
        lblUnit.setFont(labelFont);
        lblUnit.setForeground(labelColor);
        add(lblUnit);

        cbUnit = new JComboBox<>(new String[]{"A", "B", "C", "D", "E"});
        cbUnit.setBounds(300, 100, 100, 30);
        cbUnit.setFont(textFont);
        add(cbUnit);

        // SSC Roll
        JLabel lblSSCRoll = new JLabel("SSC Roll:");
        lblSSCRoll.setBounds(40, 140, 120, 30);
        lblSSCRoll.setFont(labelFont);
        lblSSCRoll.setForeground(labelColor);
        add(lblSSCRoll);

        tfSSCRoll = new JTextField();
        tfSSCRoll.setBounds(200, 140, 200, 30);
        tfSSCRoll.setFont(textFont);
        tfSSCRoll.setBackground(bgColor);
        add(tfSSCRoll);

        // HSC Roll
        JLabel lblHSCRoll = new JLabel("HSC Roll:");
        lblHSCRoll.setBounds(40, 180, 120, 30);
        lblHSCRoll.setFont(labelFont);
        lblHSCRoll.setForeground(labelColor);
        add(lblHSCRoll);

        tfHSCRoll = new JTextField();
        tfHSCRoll.setBounds(200, 180, 200, 30);
        tfHSCRoll.setFont(textFont);
        tfHSCRoll.setBackground(bgColor);
        add(tfHSCRoll);

        // Check Eligibility button
        checkEligibility = new JButton("Check Eligibility");
        checkEligibility.setBounds(40, 220, 200, 40);
        checkEligibility.setBackground(buttonColor);
        checkEligibility.setForeground(Color.WHITE);
        checkEligibility.setFont(new Font("Tahoma", Font.BOLD, 15));
        checkEligibility.addActionListener(this);
        add(checkEligibility);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 220, 200, 40);
        cancel.setBackground(buttonColor);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        // Result area
        resultArea = new JTextArea();
        resultArea.setBounds(40, 280, 400, 100);
        resultArea.setFont(textFont);
        resultArea.setEditable(false);
        resultArea.setBackground(bgColor);
        add(resultArea);

        // Payment button
        payment = new JButton("Proceed to Payment");
        payment.setBounds(40, 390, 200, 40);
        payment.setBackground(buttonColor);
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Tahoma", Font.BOLD, 15));
        payment.addActionListener(this);
        payment.setVisible(false); // Initially hidden
        add(payment);

        // Transaction ID label and text field
        lblTransactionID = new JLabel("Transaction ID:");
        lblTransactionID.setBounds(40, 440, 150, 30);
        lblTransactionID.setFont(labelFont);
        lblTransactionID.setForeground(labelColor);
        lblTransactionID.setVisible(false); // Initially hidden
        add(lblTransactionID);

        tfTransactionID = new JTextField();
        tfTransactionID.setBounds(200, 440, 200, 30);
        tfTransactionID.setFont(textFont);
        tfTransactionID.setBackground(bgColor);
        tfTransactionID.setVisible(false); // Initially hidden
        add(tfTransactionID);

        // Frame settings
        setSize(500, 550);
        setLocation(500, 20);
        setVisible(true);
    }

    // Action handling for buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkEligibility) {
            String name = tfName.getText();
            String fatherName = tfFatherName.getText();
            String sscRoll = tfSSCRoll.getText();
            String hscRoll = tfHSCRoll.getText();
            String unit = (String) cbUnit.getSelectedItem();

            double sscRequirement = 0.0, hscRequirement = 0.0;

            switch (unit) {
                case "A":
                    sscRequirement = 4.5;
                    hscRequirement = 4.0;
                    break;
                case "B":
                    sscRequirement = 4.0;
                    hscRequirement = 4.0;
                    break;
                case "C":
                    sscRequirement = 3.5;
                    hscRequirement = 3.5;
                    break;
                case "D":
                    sscRequirement = 4.5;
                    hscRequirement = 4.0;
                    break;
                case "E":
                    sscRequirement = 4.0;
                    hscRequirement = 3.5;
                    break;
            }

            try {
                ConnReg conn = new ConnReg();
                String query = "SELECT ssc_result, hsc_result FROM students WHERE ssc_roll = ? AND hsc_roll = ?";
                PreparedStatement statement = conn.c.prepareStatement(query);
                statement.setString(1, sscRoll);
                statement.setString(2, hscRoll);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    double sscGPA = Double.parseDouble(resultSet.getString("ssc_result"));
                    double hscGPA = Double.parseDouble(resultSet.getString("hsc_result"));

                    if (sscGPA >= sscRequirement && hscGPA >= hscRequirement) {
                        resultArea.setText("You are eligible for Unit " + unit + ".\nProceed to payment.");
                        payment.setVisible(true);
                        tfTransactionID.setVisible(true);
                        lblTransactionID.setVisible(true);

                        String insertQuery = "INSERT INTO " + unit.toLowerCase() + "_unit_apply (name, father_name, ssc_roll, hsc_roll, ssc_result, hsc_result, unit) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement insertStatement = conn.c.prepareStatement(insertQuery);
                        insertStatement.setString(1, name);
                        insertStatement.setString(2, fatherName);
                        insertStatement.setString(3, sscRoll);
                        insertStatement.setString(4, hscRoll);
                        insertStatement.setDouble(5, sscGPA);
                        insertStatement.setDouble(6, hscGPA);
                        insertStatement.setString(7, unit);

                        insertStatement.executeUpdate();
                    } else {
                        resultArea.setText("You are not eligible for Unit " + unit + ".");
                        payment.setVisible(false);
                        tfTransactionID.setVisible(false);
                        lblTransactionID.setVisible(false);
                    }
                } else {
                    resultArea.setText("No records found for the provided SSC and HSC rolls.");
                    payment.setVisible(false);
                    tfTransactionID.setVisible(false);
                    lblTransactionID.setVisible(false);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                resultArea.setText("Database error occurred.");
            } catch (NumberFormatException e) {
                resultArea.setText("Invalid result format.");
            }
        } else if (ae.getSource() == payment) {
            String transactionID = tfTransactionID.getText();
            if (transactionID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid transaction ID.");
            } else {
                try {
                    ConnReg conn = new ConnReg();
                    // Update the unit_apply table with the transaction ID
                    String updateQuery = "UPDATE " + cbUnit.getSelectedItem().toString().toLowerCase() + "_unit_apply SET transaction_id = ? WHERE ssc_roll = ? AND hsc_roll = ?";
                    PreparedStatement updateStatement = conn.c.prepareStatement(updateQuery);
                    updateStatement.setString(1, transactionID);
                    updateStatement.setString(2, tfSSCRoll.getText());
                    updateStatement.setString(3, tfHSCRoll.getText());

                    int rowsUpdated = updateStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(this, "Payment successful with Transaction ID: " + transactionID);
                    } else {
                        JOptionPane.showMessageDialog(this, "Payment successful, but transaction ID could not be recorded.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Database error occurred while updating transaction ID.");
                }
                setVisible(false);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Application();
    }
}
