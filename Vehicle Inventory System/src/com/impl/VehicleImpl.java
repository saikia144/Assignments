package com.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.model.IVehicle;
import com.model.Vehicle;

public class VehicleImpl implements IVehicle{
	
	private List<Vehicle> vehicleList;
	
	public VehicleImpl() {
		
		Vehicle v1 = new Vehicle("Toyota",2019,5000);
		Vehicle v2 = new Vehicle("Suzuki" ,2016 ,3500);
		Vehicle v3 = new Vehicle("Benz" ,2021 ,6000);
		Vehicle v4 = new Vehicle("Kia" ,2020, 4500);
		
		vehicleList = new LinkedList<Vehicle>();
		
		vehicleList.add(v1);
		vehicleList.add(v2);
		vehicleList.add(v3);
		vehicleList.add(v4);
		
	}
	
	
	public void display() {
		vehicleList.forEach(e -> System.out.println(e.getBrand()+" "+e.getMfgYear()+" "+e.getPrice()));
	}

	@Override
	public void sortVehicleByYear() {
		Comparator<Vehicle> comparator = Comparator.comparingInt(Vehicle::getMfgYear);
	    Collections.sort(vehicleList, comparator);
	    display();
	}

	@Override
	public void sortVehicleByPrice() {
		Comparator<Vehicle> comparator = Comparator.comparingDouble(Vehicle::getPrice);
	    Collections.sort(vehicleList, comparator);
		display();
	}

	@Override
	public void addVehicle(String name, int mYear, double price) {
		
		Vehicle v = new Vehicle(name, mYear, price);
		vehicleList.add(v);
	}


}
