package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateCustomerTable {
    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

            // Create database
            Statement stmt = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS mydatabase";
            stmt.executeUpdate(sql);

            // Create customer table
            sql = "CREATE TABLE IF NOT EXISTS customers " +
                  "(CustomerId INT(11) NOT NULL AUTO_INCREMENT, " +
                  "CustomerName VARCHAR(255), " +
                  "Address VARCHAR(255), " +
                  "City VARCHAR(20), " +"PostalCode VARCHAR(20),"+"Country VARCHAR(30),"+
                  "PRIMARY KEY (CustomerId     ))";
            stmt.executeUpdate(sql);

            // Close the statement and connection
            stmt.close();
            conn.close();
            System.out.println("Table created successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
