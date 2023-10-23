package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.mapper.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	
	@Autowired
	EmpMapper empMapper;
	
	//@Test
	public void getEmpAll() {
		List<EmpVO> list = empMapper.selectAllEmpInfo();
		assertFalse(list.isEmpty());
		//System.out.println(list.isEmpty());
	}
	
	//@Test
	public void getEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(),"King");
	}
	
	//@Test
	public void insertEmpInfo() {
		//µî·Ï
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kang");
		empVO.setFirstName("San-Ha");
		empVO.setEmail("shKang@google.com");
		empVO.setJobId("IT_PROG");
		
		empMapper.insertEmpInfo(empVO);
		assertNotEquals(empVO.getEmployeeId(), 0);
	}
	
	//@Test
	public void updateEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(556);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		
		findVO.setSalary(1000);
		int result = empMapper.updateEmpInfo(findVO);
		assertEquals(result, 1);
	}
	
	//@Test
	public void updateDynamic() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(556);
		empVO.setFirstName("Hal-La");
		
		int result = empMapper.updateEmpInfoDynamic(empVO);
		assertEquals(result, 1);
	}
	
	@Test
	public void deleteEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(556);
		
		int result = empMapper.deleteEmpInfo(556);
		assertEquals(result, 1);
	}
}