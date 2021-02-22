package com.no_3.solution.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.no_3.solution.service_impls.CustomerServiceImpl;
import com.no_3.solution.models.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerServiceImpl custService;
	
	private String responseMessage = "{\"Message\":\"Success\"}";
	
	@GetMapping(value="")
	public ResponseEntity<List<Customer>> getCustomers(){
		List<Customer> customers = custService.getCustomers();
		
		return ResponseEntity.status(HttpStatus.OK).body(customers);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id")Integer id){
		
		Customer customers = custService.getCustomer(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(customers); 
	}
	
	@PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addCustomer(@RequestBody Customer cust){
		
		String resp = custService.addCustomer(cust);
		
		if(resp != null) {
			return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body("{\"Messge\":\"Customer with given id already existed\"}");
	}

	@PutMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCustomer(@RequestBody Customer cust){
		
		String resp = custService.updateCustomer(cust);
		if(resp != null) {
			return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body("{\"Messge\":\"Customer with given id does not exist\"}");
	}	
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCustomer(@PathVariable("id")Integer id){
		
		String resp = custService.deleteCustomer(id);
		if(resp != null) {
			return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body("{\"Messge\":\"Customer with given id does not exist\"}");
	}	
}
