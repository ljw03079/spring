package com.yedam.app.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.emp.service.GreetingVO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class EmpController {

	@Autowired
	EmpService empService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@ResponseBody
	@GetMapping("emp")
	public List<EmpVO> findEmp(EmpVO vo){
		log.debug("findEmp=====");
		return empService.findEmp(vo);
	}
	
}

