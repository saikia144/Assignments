package com.driver;

import java.util.Scanner;

import com.impl.UserImpl;
import com.impl.VehicleImpl;
import com.model.User;

public class VehicleAppDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Welcome to AUTOSHOP WORLD!!!");
			System.out.println("Please signup with your details");
			System.out.println("Please enter your first name:");
			String fname = sc.next();

			System.out.println("Please enter your last name:");
			String lname = sc.next();

			System.out.println("Please enter your username:");
			String username = sc.next();

			System.out.println("Please enter your password:");
			String password = sc.next();

			User user = new User(fname,lname,username,password);
			UserImpl u = new UserImpl();
			u.registerUser(user);


			System.out.println("Thank you…Registration success!!!\n");

			System.out.println("Please sign in with your details:");

			System.out.println("Please enter your username");
			String userInput_uname = sc.next();

			System.out.println("Please enter your password");
			String userInput_pwd = sc.next();

			u.loginUser(userInput_uname, userInput_pwd);
			//System.out.println(res);

			System.out.println("\n List of available vehicles:");
			VehicleImpl vimpl = new VehicleImpl();
			
			System.out.println("Enter vehicle brand name:");
			String v_brand = sc.next();
			
			System.out.println("Enter vehicle manufacturing year");
			int v_mfgYear = sc.nextInt();
			
			System.out.println("Enter vehicle price");
			double v_price = sc.nextDouble();

			vimpl.addVehicle(v_brand,v_mfgYear,v_price);
			vimpl.display();

			System.out.println("\nHow do you want to sort the available data?? Choose from below");
			System.out.println("1. By Price of the Vehicle");
			System.out.println("2. By Year of manufacturing");
			int userInp = Integer.parseInt(sc.next());
			switch(userInp) {
			case 1:
				System.out.println("Sorting Vehicles by their price:");
				System.out.println("================================");
				vimpl.sortVehicleByPrice();
				break;
			case 2:
				System.out.println("Sorting Vehicles by Manufacturing year:");
				System.out.println("=======================================");
				vimpl.sortVehicleByYear();
				break;
			default :
				System.out.println("Wrong input..!!!");
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}

	}
}
