package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Sp02ApplicationTests {

	@Autowired
	EmpService empService;
	
	@Test
	void contextLoads() {
		List<EmpVO> list = empService.getEmpAllList();
		assertTrue(!list.isEmpty());
	}

}
