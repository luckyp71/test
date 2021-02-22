package com.no_3.solution.services;

import java.util.List;

import com.no_3.solution.models.Customer;

public interface CustomerService {
	
//  Get all customers
	public List<Customer> getCustomers();
	
//	Get customer by its id
	public Customer getCustomer(Integer id);
	
//	Add customer
	public String addCustomer(Customer cust);
	
//	Update 	customer
	public String updateCustomer(Customer cust);
	
//	Delete customer
	public String deleteCustomer(Integer id);

}
