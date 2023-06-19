package com.customer.service;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerService {
	public void createCustomer(Customer customer);
	public List<Customer> listOfCustomers();
	public void deleteCustomer(long id);
	public void updateCustomer(long id, String name, String country);
}
