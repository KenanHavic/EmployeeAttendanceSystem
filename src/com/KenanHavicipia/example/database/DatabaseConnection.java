package com.KenanHavicipia.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeAttendance";  // Moje ime baze
    private static final String USER = "root";  // Korisničko ime
    private static final String PASSWORD = "admin";  // Lozinka

    // Metoda za povezivanje na bazu
    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}