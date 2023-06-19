package com.impl;

import com.model.IUser;
import com.model.User;

public class UserImpl implements IUser {
	private User users[];

	public UserImpl() {
		users = new User[5];

		for(int i = 0;i<users.length;i++) {
			users[i] = new User();
		}
	}

	@Override
	public boolean registerUser(User user, int index) {

		if(user == null || index < 0) {
			return false;
		}


		if(users[index].getFirstName() != null) {
			System.out.println(users[index].getFirstName());
			return false;
		}

		users[index] = user;

		return true;
	}

	@Override
	public boolean Userlogin(String username, String password) {
		String uname,pwd;
		
		for(User u : users) {
			//System.out.println(u.getFirstName()+" "+u.getLastName()+" "+u.getUserName()+" "+u.getPassword());
			uname = u.getUserName();
			pwd = u.getPassword();
			
			if(u != null && username.equals(uname) && password.equals(pwd)) {
				System.out.println("Welcome "+uname+", you have logged in successfully");
				return true;
			}
		}
		return false;
	}


}
