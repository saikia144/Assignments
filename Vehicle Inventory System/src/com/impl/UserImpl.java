package com.impl;

import java.util.LinkedList;
import java.util.List;

import com.model.IUser;
import com.model.User;

public class UserImpl implements IUser{
	private List<User> userList; 
	
	@Override
	public boolean registerUser(User user) {
		userList = new LinkedList<User>();
		
		if(user != null) {
			userList.add(user);
			
			for(User u : userList) {
				System.out.println(u.getFname()+u.getLname()+u.getPassword()+u.getUsername());
				
			}
			return true;
		}else
		
			return false;
	}

	@Override
	public boolean loginUser(String username, String password) {
		
		for(User user : userList) {
			if(user != null && username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				System.out.println(user.getFname()+"!!! Welcome to Autoshop World");
				return true;
			}else {
				System.out.println("Wrong user input!!!");
				return false;
			}
		}
		return true;
	}
	
	
}
