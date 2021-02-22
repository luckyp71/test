package com.no_3.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.no_3.solution.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE id=:id")
	Customer getCustomerById(Integer id);
	
}
