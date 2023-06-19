package com.jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	public static Connection getConnection() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			//System.out.println("Connected to MYSql Successfully!!!");
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
