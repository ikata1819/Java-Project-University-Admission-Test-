package com.cse.ju.oop.views.screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentTableViewer extends JFrame {
    private ConnReg connection;
    private String unit;

    public StudentTableViewer(String unit) {
        this.unit = unit;
        connection = new ConnReg();
        displayTable();
    }

    private void displayTable() {
        try {
            // Determine the table name based on the unit selected
            String tableName = unit.toLowerCase().charAt(0) + "_unit_apply"; // a_unit_apply, b_unit_apply, etc.
            String query = "SELECT * FROM " + tableName;
            ResultSet rs = connection.s.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // Create a JFrame to display the results
            setTitle("Database Table for " + unit);
            setSize(800, 600); // Increased frame size
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null); // Center the frame

            // Create a JTable to display the data
            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = rsmd.getColumnName(i + 1);
            }

            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

            JTable table = new JTable(model) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Make cells non-editable
                }
            };

            // Set table cell size
            table.setRowHeight(40); // Set row height
            table.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font size for the table

            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane);
            setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (connection.s != null) connection.s.close();
                if (connection.c != null) connection.c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
