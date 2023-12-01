package com.yedam.app.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
	
	@Autowired CustomerRepository customerRepository;
	
	@ResponseBody
	@GetMapping("/customer")
	public Iterable<Customer> customer(){
		return customerRepository.findAll();
	}
	
	@ResponseBody
	@GetMapping("/findName")
	public Iterable<Customer> findName(String firstName){
		return customerRepository.findByFirstNameLike("%"+firstName+"%");
	}
}
