package com.customer;

import java.io.*;
import java.sql.*;

public class SelectCustomerData {
    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

            // Execute the query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT CustomerId, CustomerName, Address, City, PostalCode, CustomerDOB, CPhoto FROM customers");

            // Iterate over the result set and print the data
            while (rs.next()) {
                int customerId = rs.getInt("CustomerId");
                String customerName = rs.getString("CustomerName");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                String postalCode = rs.getString("PostalCode");
                Date customerDob = rs.getDate("CustomerDOB");
                Blob blob = rs.getBlob("CPhoto");
                byte[] bytes = blob.getBytes(1, (int)blob.length());
                FileOutputStream fos = new FileOutputStream("image_output.jpg");
                fos.write(bytes);
                fos.close();
                System.out.println("CustomerId: " + customerId + ", CustomerName: " + customerName + ", Address: " + address + ", City: " + city + ", PostalCode: " + postalCode + ", CustomerDOB: " + customerDob + ", CPhoto: image saved to file");
            }

            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
