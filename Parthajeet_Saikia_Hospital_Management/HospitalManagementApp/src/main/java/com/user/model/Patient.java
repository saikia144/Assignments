package com.user.model;

public class Patient {
	private int id;
	private String pname;
	private String bgroup;
	private String disease;
	
	public Patient() {}
	
	public Patient(int id,String pname, String bgroup, String disease) {
		this.id = id;
		this.pname = pname;
		this.bgroup = bgroup;
		this.disease = disease;
	}
	
	public Patient(String pname, String bgroup, String disease) {
		this.pname = pname;
		this.bgroup = bgroup;
		this.disease = disease;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String name) {
		this.pname = name;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + pname + ", bgroup=" + bgroup + ", disease=" + disease + "]";
	}
	
	
}
