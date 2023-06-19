package com.customer;

import java.sql.*;

public class BatchExecution {
    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

            // Create statement
            Statement stmt = conn.createStatement();

            // Add SQL statements to batch
            stmt.addBatch("INSERT INTO customers (CustomerName, Address, City, PostalCode, Country) VALUES ('Jane Smith', 'Assam', 'Guwahati', '2323222', 'India')");
            stmt.addBatch("INSERT INTO customers (CustomerName, Address, City, PostalCode, Country) VALUES ('John Doe', '123 Main St', 'Florida', '122112', 'USA')");
            stmt.addBatch("UPDATE customers SET city = 'New York' WHERE CustomerName = 'John Doe'");
           // stmt.addBatch("DELETE FROM customers WHERE Customername = 'Jane Smith'");
            //stmt.addBatch("DELETE FROM customers WHERE Customername = 'John Doe'");

            // Execute batch and get the results
            int[] updateCounts = stmt.executeBatch();

            // Print the results
            for (int i = 0; i < updateCounts.length; i++) {
                if (updateCounts[i] == Statement.SUCCESS_NO_INFO) {
                    System.out.println("Query " + (i + 1) + " successfully executed but no update count was returned.");
                } else if (updateCounts[i] == Statement.EXECUTE_FAILED) {
                    System.out.println("Query " + (i + 1) + " failed to execute.");
                } else {
                    System.out.println("Query " + (i + 1) + " executed successfully. " + updateCounts[i] + " rows affected.");
                }
            }

            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
