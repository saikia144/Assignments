package com.jdbcExample;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Connection con = DbConnect.getConnection();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Employee Management Portal!!!");
		System.out.println("Please login with your credentials:");
		System.out.println("Please enter username");
		String uname = sc.next();
		System.out.println("Please enter password");
		String pwd = sc.next();
		
		boolean exit = false;
		while(!exit) {
			System.out.println("Choose your option!!!");
			System.out.println("1. To insert new employee details");
			System.out.println("2. Show all employee details");
			System.out.println("3. Update employee details");
			System.out.println("4. Delete employee details");
			System.out.println("5. Exit");
			
			int option  = sc.nextInt();
			
			switch(option) {
			case 1: 
				EmployeeCrud.insert(con, sc);
				break;
			case 2:
				EmployeeCrud.show(con);
				break;
			case 3:
				EmployeeCrud.update(con, sc);
				break;
			case 4:
				EmployeeCrud.delete(con, sc);
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Wrong Input!");
				break;
			}
		}
		sc.close();
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
