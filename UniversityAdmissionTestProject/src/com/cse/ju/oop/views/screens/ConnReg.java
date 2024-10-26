package com.cse.ju.oop.views.screens;

import java.sql.*;

public class ConnReg {

    Connection c;
    Statement s;

    ConnReg () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///my_project_db", "root", "tasnimsql");
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}