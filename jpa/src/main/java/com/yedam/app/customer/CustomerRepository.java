package com.yedam.app.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public List<Customer> findByFirstNameLike(String firstName);
}
