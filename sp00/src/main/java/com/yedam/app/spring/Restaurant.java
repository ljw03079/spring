package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {

	//Autowired: Setter, @Autowired => 해당 클래스 @Component
	@Autowired
	Chef chef;
	
	public void open() {
		chef.cooking();
	}
}
