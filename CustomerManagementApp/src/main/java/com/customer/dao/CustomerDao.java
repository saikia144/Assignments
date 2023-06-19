package com.customer.dao;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerDao {
	public void saveCustomer(Customer customer);
	public List<Customer> listOfCustomers();
	public void removeCustomerRecord(long id);
	public void modifyCustomerRecord(long id,String name, String country);
}
