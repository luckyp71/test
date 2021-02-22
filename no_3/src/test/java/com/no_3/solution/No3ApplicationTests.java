package com.no_3.solution;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.no_3.solution.controllers.CustomerController;

@SpringBootTest
class No3ApplicationTests {

	@Autowired
	CustomerController custController;	
	
//	Assumed we have invoked "Add Customer" service and fill name with Lucky
	@Test
	public void testGetCustomer() {
		String expectedResult="Lucky";
		String actualResult = custController.getCustomer(1).getBody().getName();
		assertEquals(expectedResult, actualResult);
	}
	
//	Assumed we only add one customer by invoking "Add Customer" service
	@Test
	public void testGetCustomers() {
		int expectedResult = 1;
		int actualResult = custController.getCustomers().getBody().size();
		
		assertEquals(expectedResult, actualResult);
	}
	
}
