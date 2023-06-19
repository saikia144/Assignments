package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.dao.CustomerDao;
import com.customer.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public void createCustomer(Customer customer) {
		
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> listOfCustomers() {
		
		List<Customer> clist = customerDao.listOfCustomers();
		return clist;
	}

	@Override
	@Transactional
	public void deleteCustomer(long id) {
		customerDao.removeCustomerRecord(id);
		
	}
	
	@Transactional
	@Override
	public void updateCustomer(long id, String name, String country) {
		
		customerDao.modifyCustomerRecord(id,name,country);
	}
	
}
