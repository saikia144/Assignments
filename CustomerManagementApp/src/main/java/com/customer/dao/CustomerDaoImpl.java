package com.customer.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory factory;

	@Override
	public void saveCustomer(Customer customer) {
		factory.getCurrentSession().save(customer);
	}

	@Override
	public List<Customer> listOfCustomers() {
		TypedQuery<Customer> qry = factory.getCurrentSession().createQuery("from Customer");
		return qry.getResultList();
	}

	@Override
	public void removeCustomerRecord(long id) {
		Customer customer = factory.getCurrentSession().get(Customer.class, id);
		if (customer != null) {
			factory.getCurrentSession().delete(customer);
		}
	}

	@Override
	public void modifyCustomerRecord(long id, String newName, String newCountry) {
	    //Session session = factory.getCurrentSession();
	    Customer customer = factory.getCurrentSession().get(Customer.class, id);

	    if (customer != null) {
	        customer.setName(newName);
	        customer.setCountry(newCountry);
	        factory.getCurrentSession().update(customer); 
	        System.out.println("Inside dao after:" + customer.getName() + " " + customer.getCountry());
	    }
	}


}
