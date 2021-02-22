package com.no_3.solution.service_impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.no_3.solution.models.Customer;
import com.no_3.solution.repositories.CustomerRepo;
import com.no_3.solution.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepo custRepo;

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = custRepo.findAll();
		return customers;
	}

	@Override
	public Customer getCustomer(Integer id) {
	    Customer cust = custRepo.getCustomerById(id);
		return cust;
	}

	@Override
	public String addCustomer(Customer cust) {
		Customer existingCust = this.getCustomer(cust.getId());
		
		if(existingCust == null) {
			custRepo.save(cust);
			return "success";
		}
		return null;
	}

	@Override
	public String updateCustomer(Customer cust) {
		Customer existingCust = this.getCustomer(cust.getId());
		
		if(existingCust != null) {
			custRepo.save(cust);
			return "success";
		}
		return null;
	}

	@Override
	public String deleteCustomer(Integer id) {
		Customer existingCust = this.getCustomer(id);
		
		if(existingCust != null) {
			custRepo.deleteById(existingCust.getId());
			return "success";
		}
		return null;
	}
	
}
