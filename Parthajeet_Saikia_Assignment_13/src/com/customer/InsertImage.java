package com.customer;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertImage {
    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

            // Read the image file
            File file = new File("C:\\Users\\Firehouse\\Pictures\\Saved Pictures\\IMG_20201130_190851_633.jpg");
            FileInputStream fis = new FileInputStream(file);
            
            PreparedStatement pstmt = conn.prepareStatement("ALTER TABLE customers ADD COLUMN CPhoto blob");
            pstmt.execute();
            // Insert the image into the database
            pstmt = conn.prepareStatement("INSERT INTO customers (CustomerName, Address, City, PostalCode, Country, CustomerDOB, CPhoto) VALUES (?, ?, ?, ?, ?, ?, ?)");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse("1990-01-01");
            pstmt.setString(1, "John Doe");
            pstmt.setString(2, "Assam");
            pstmt.setString(3, "Guwahati");
            pstmt.setString(4, "7777887");
            pstmt.setString(5, "India");
            pstmt.setDate(6, new java.sql.Date(date.getTime()));
            pstmt.setBinaryStream(7, fis, file.length());
            pstmt.executeUpdate();

            // Close the statement and connection
            pstmt.close();
            conn.close();
            System.out.println("Image inserted successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
