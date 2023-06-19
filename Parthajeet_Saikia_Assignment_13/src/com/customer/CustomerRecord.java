package com.customer;

import java.sql.*;

public class CustomerRecord {
    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

            // Insert record
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO customers (CustomerName, Address, City, PostalCode, Country) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, "John Doe");
            pstmt.setString(2, "Assam");
            pstmt.setString(3, "Guwahati");
            pstmt.setString(4, "7777887");
            pstmt.setString(5, "India");
            pstmt.executeUpdate();

            // Update record
            pstmt = conn.prepareStatement("UPDATE customers SET city = ? WHERE CustomerName = ?");
            pstmt.setString(1, "Delhi");
            pstmt.setString(2, "John Doe");
            pstmt.executeUpdate();

            // Delete record
            pstmt = conn.prepareStatement("DELETE FROM customers WHERE CustomerName = ?");
            pstmt.setString(1, "John Doe");
            pstmt.executeUpdate();

            // Close the statement and connection
            pstmt.close();
            conn.close();
            System.out.println("Record inserted, updated, and deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
