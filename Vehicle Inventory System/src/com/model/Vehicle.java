package com.model;

public class Vehicle {
	private String brand;
	private int mfgYear;
	private double price;
	
	public Vehicle(String brand, int mfgYear, double price) {
		super();
		this.brand = brand;
		this.mfgYear = mfgYear;
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getMfgYear() {
		return mfgYear;
	}
	public void setMfgYear(int mfgYear) {
		this.mfgYear = mfgYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
