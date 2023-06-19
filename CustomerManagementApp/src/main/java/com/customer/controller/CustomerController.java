package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping("/")
	public String showForm(Model model) {
		Customer c= new Customer();
		model.addAttribute("customer",c);
		return "signup";
	}

	@GetMapping("/customerlist")
	public String customerList(Model model) {
		List<Customer> list = service.listOfCustomers();
		model.addAttribute("list",list);
		return "customer-list";
	}

	@GetMapping("/deleteCustomer")
	public String removeCustomer(long id) {
		service.deleteCustomer(id);
		return "redirect:/customerlist";
	}

	@PostMapping("/addCust")
	public String displayDetailsEntered(@ModelAttribute("customer") Customer customer) {
		System.out.println(customer.getName()+" "+customer.getCountry());
		service.createCustomer(customer);
		return "redirect:/customerlist";
	}

	@PostMapping("/update")
	public String updateCustomer(int id,String name, String country) {
		service.updateCustomer(id, name, country);
		return "redirect:/customerlist";	
		}

}

