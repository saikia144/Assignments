package com.jdbcExample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeCrud {

	//Insert
	static void insert(Connection con, Scanner sc)  {
		PreparedStatement ps = null;
		try {
			System.out.println("Please enter new employee details:");
			System.out.println("Please enter employee id:");
			int eid = sc.nextInt();
			System.out.println("Please enter employee name");
			String name = sc.next();
			System.out.println("Please enter mobile number");
			int phone = sc.nextInt();
			System.out.println("Please enter Department");
			String dept = sc.next();
			System.out.println("Please enter Location");
			String loc = sc.next();

			String query = "insert into employee values(?,?,?,?,?)";


			ps = con.prepareStatement(query);
			ps.setInt(1, eid);
			ps.setString(2, name);
			ps.setInt(3, phone);
			ps.setString(4, dept);
			ps.setString(5, loc);

			int i = ps.executeUpdate();

			if(i == 1) {
				System.out.println("Thank you… employee details are inserted!!!");
			}else {
				System.out.println("Employee registration failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ps != null ) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static void show(Connection con){
		int eid,phone;
		String name,dept,loc;

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			System.out.println("╔═════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║                       EMPLOYEE DETAILS                        			  ║");
			System.out.println("╟────────────────┬───────────────┬────────────────┬─────────────┬─────────────╫");
			System.out.println("║       ID       │      NAME     │     PHONE      │     DEPT    │     LOC     ║");
			System.out.println("╟────────────────┼───────────────┼────────────────┼─────────────┼─────────────╫");
			while (rs.next()) {
				eid = rs.getInt(1);
				name = rs.getString(2);
				phone = rs.getInt(3);
				dept = rs.getString(4);
				loc = rs.getString(5);
				System.out.printf("║ %14d │ %13s │ %14d │ %11s │ %11s ║\n", eid, name, phone, dept, loc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//Update
	static void update(Connection con, Scanner sc){
		int eid,rowsAffected;
		PreparedStatement ps=null;
		ResultSet rs = null;

		//Scanner sc  =new Scanner(System.in);
		try {
			System.out.println("Enter the EID of the employee that you want to update...");
			eid = sc.nextInt();

			ps= con.prepareStatement("select * from employee where eid=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, eid);

			rs = ps.executeQuery();
			if(!rs.next()) {
				System.out.println("EID: "+eid+" does not exist!!!");
				return;
			}

			while(rs.next()) {
				System.out.println(rs.getInt("eid")+" "+rs.getString("name")+" "+" "+rs.getInt("phone")+" "+rs.getString("department")+" "+rs.getString("location"));
			}

			System.out.println("Select the field that you want to update:");
			System.out.println("1.Name 2.Phone 3.Location");
			int option = sc.nextInt();

			switch(option) {
			case 1: 
				System.out.println("Enter name");
				String name = sc.next();
				ps = con.prepareStatement("update employee set name = ? where eid=?");
				ps.setString(1, name);
				ps.setInt(2, eid);
				rowsAffected =ps.executeUpdate();
				if(rowsAffected > 0) {
					System.out.println("Successfully updated ");
				}

				break;
			case 2:
				System.out.println("Enter phone");
				int phone = sc.nextInt();
				ps = con.prepareStatement("update employee set phone = ? where eid=?");
				ps.setInt(1, phone);
				ps.setInt(2, eid);
				rowsAffected =ps.executeUpdate();
				if(rowsAffected > 0) {
					System.out.println("Successfully updated ");
				}
				break;
			case 3:
				System.out.println("Enter Location");
				String loc = sc.next();
				ps = con.prepareStatement("update employee set location = ? where eid=?");
				ps.setString(1, loc);
				ps.setInt(2, eid);
				rowsAffected =ps.executeUpdate();
				if(rowsAffected > 0) {
					System.out.println("Successfully updated ");
				}
				break;
			default:
				System.out.println("Wrong input");
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}


	}

	//Delete
	static void delete(Connection con, Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		PreparedStatement ps = null;
		System.out.println("Enter the EID of the employee that you want to remove...");
		int eid= sc.nextInt();

		try {
			ps = con.prepareStatement("delete from employee where eid=?");
			ps.setInt(1,eid);

			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Employee with EID: "+eid+" deleted successfully");
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null ) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
