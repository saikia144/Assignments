package com.driver;

import java.util.Scanner;

import com.impl.UserImpl;
import com.impl.WorkoutImpl;
import com.model.User;
import com.model.WorkOut;

public class GymAppDriver {
	public static void main(String[] args) {
		
		System.out.println("The max number of records that can be entered are 5\n");
		System.out.println("Enter the user details below and also the index position(max val = 4, min val= 0)");
		
		System.out.println("Total users you want to register: ");
		Scanner sc = new Scanner(System.in);
		int count  = sc.nextInt();
		int index;
		
		UserImpl uimpl = new UserImpl();
		
		for(int i = 0; i<count; i++) {
			
			System.out.println("Enter the index at which you want to insert the user: ");
			index = sc.nextInt();
			
			User user = new User();
			
			System.out.println("Enter firstname: ");String fname = sc.next();
			System.out.println("Enter lasttname: ");String lname = sc.next();
			System.out.println("Enter username: ");String uname = sc.next();
			System.out.println("Enter password: ");String pwd = sc.next();
			
			user.setFirstName(fname);
			user.setLastName(lname);
			user.setUserName(uname);;
			user.setPassword(pwd);
			
			boolean res = uimpl.registerUser(user, index);
			
			if(res) {
				System.out.println("User registered successfully");
			}else {
				System.out.println("Nope...you entered wrong index or incorrect values");
			}
		}
		
		boolean log_test = uimpl.Userlogin("psai","asas");
		System.out.println("Login status: /n"+log_test);
		
		//IWorkOut interface methods test
		
		System.out.println("Enter your workout details: ");
		
		System.out.println("Enter how many workouts you want to add");
		count = sc.nextInt();
		
		WorkoutImpl wimpl = new WorkoutImpl();
		
		for(int i = 0 ; i<count; i++) {
			System.out.println("Enter the index where you want to insert the details: ");
			index = sc.nextInt(); 
			
			System.out.println("Enter workout type(cardio/muscle)");
			String type=  sc.next();
			
			System.out.println("Enter equipment type: ");
			String equip = sc.next();
			
			System.out.println("Enter weights you want to use: ");
			int weight = sc.nextInt();
			
			System.out.println("Enter repetitions");
			int reps = sc.nextInt();
			
			System.out.println("Enter reason for workout: ");
			String reason = sc.next();
			
			WorkOut wout = new WorkOut();
			wout.setType(type);
			wout.setEquipment(equip);
			wout.setWeights(weight);
			wout.setRepetitions(reps);
			wout.setReason(reason);
			
			wimpl.addWorkout(wout, index);
		}
		
		
		WorkOut[] workout = wimpl.displayMyWorkouts();
		
		int wlen = workout.length;
		
		for(int i=0;i<wlen;i++) {
			if(workout[i].getType() != null) {
				System.out.println("\nWorkout- "+i);
				System.out.println("Type: "+workout[i].getType());
				System.out.println("Equipment: "+workout[i].getEquipment());
				System.out.println("Weights: "+workout[i].getWeights());
				System.out.println("Reps: "+workout[i].getRepetitions());
				System.out.println("Reason: "+workout[i].getReason());
			}
		}
		
	}
}
