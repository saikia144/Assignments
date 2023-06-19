package com.jdbcExample;

public class Employee {
	private int eid;
	private String name;
	private int phone;
	private String department;
	private String location;
	
	public Employee(int eid, String name, int phone, String department, String location) {
		super();
		this.eid = eid;
		this.name = name;
		this.phone = phone;
		this.department = department;
		this.location = location;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
