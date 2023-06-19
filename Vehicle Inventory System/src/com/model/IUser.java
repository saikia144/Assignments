package com.model;

public interface IUser {
	boolean registerUser(User user);
	boolean loginUser(String username, String password);
}
