package com.cse.ju.oop.views.screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VenueAndSchedule {
    private ConnReg connection;

    public VenueAndSchedule() {
        connection = new ConnReg();
    }

    public void createVenue(String unit) {
        String[] buildings = {"Social Science", "CSE", "New Arts", "Business Faculty", "Biology Faculty"};
        String[][] rooms = {{"101", "102", "103", "104", "105"},
                {"101", "102", "103", "104", "105"},
                {"101", "102", "103", "104", "105"},
                {"101", "102", "103", "104", "105"},
                {"101", "102", "103", "104", "105"}};

        List<String> studentData = getStudentData(unit);
        String tableName = unit.toLowerCase().replace(" unit", "") + "_unit_venue";

        // Create the venue table if it doesn't exist
        createVenueTable(tableName);

        // Insert data into venue table
        insertVenueData(tableName, studentData, buildings, rooms);

        // Show the venue table for the specific unit clicked
        showVenueTable(tableName);
    }

    private List<String> getStudentData(String unit) {
        List<String> students = new ArrayList<>();
        String query = "SELECT name, fathers_name FROM " + unit + "_unit_apply"; // Assuming students are in _unit_apply

        try {
            ResultSet rs = connection.s.executeQuery(query);
            while (rs.next()) {
                String student = rs.getString("name") + "," + rs.getString("fathers_name");
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    private void createVenueTable(String tableName) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "fathers_name VARCHAR(255), " +
                "building VARCHAR(255), " +
                "room VARCHAR(10), " +
                "shift INT)";

        try {
            connection.s.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertVenueData(String tableName, List<String> students, String[] buildings, String[][] rooms) {
        Random random = new Random();

        for (String student : students) {
            String[] studentInfo = student.split(",");
            String name = studentInfo[0];
            String fathersName = studentInfo[1];
            String building = buildings[random.nextInt(buildings.length)];
            String room = rooms[random.nextInt(rooms.length)][random.nextInt(rooms[0].length)];
            int shift = random.nextInt(5) + 1; // Random shift between 1 and 5

            String insertSQL = "INSERT INTO " + tableName + " (name, fathers_name, building, room, shift) VALUES ('"
                    + name + "', '" + fathersName + "', '" + building + "', '" + room + "', " + shift + ")";

            try {
                connection.s.executeUpdate(insertSQL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void showVenueTable(String tableName) {
        try {
            String query = "SELECT * FROM " + tableName;
            ResultSet rs = connection.s.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // Create a JFrame to display the results
            JFrame tableFrame = new JFrame("Venue Table - " + tableName);
            tableFrame.setSize(800, 600);
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tableFrame.setLocationRelativeTo(null); // Center the frame

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
            tableFrame.add(scrollPane);
            tableFrame.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
