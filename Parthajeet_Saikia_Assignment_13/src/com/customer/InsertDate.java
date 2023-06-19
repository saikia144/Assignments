package com.customer;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertDate {
    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

            // Insert record with date
            PreparedStatement pstmt = conn.prepareStatement("ALTER TABLE customers ADD COLUMN CustomerDOB date");
            pstmt.execute();
            pstmt = conn.prepareStatement("INSERT INTO customers (CustomerName, Address, City, PostalCode, Country, CustomerDOB) VALUES (?, ?, ?, ?, ?, ?)");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse("1990-01-01");
            pstmt.setString(1, "John Doe");
            pstmt.setString(2, "Assam");
            pstmt.setString(3, "Guwahati");
            pstmt.setString(4, "7777887");
            pstmt.setString(5, "India");
            pstmt.setDate(6, new java.sql.Date(date.getTime()));
            pstmt.executeUpdate();

            // Close the statement and connection
            pstmt.close();
            conn.close();
            System.out.println("Record inserted successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
