package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerDatabaseConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/test";
		String username = "root";
		String password = "root";
		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			//System.out.println("Connection Successfull!!");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("Connection closed.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
