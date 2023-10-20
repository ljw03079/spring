package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
	
	@Test
	public void getEmpAll() {
		List<EmpVO> list = empMapper.selectAllEmpInfo();
		assertFalse(list.isEmpty());
		//System.out.println(list.isEmpty());
	}
	
	@Test
	public void getEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployee_id("100");
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLast_name(),"King");
	}
}