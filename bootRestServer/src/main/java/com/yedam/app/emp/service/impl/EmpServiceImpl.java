package com.yedam.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpMapper empMapper;
	
	@Override
	public EmpVO getEmp(EmpVO empVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpVO> findEmp(EmpVO empVO) {
		return empMapper.findEmp(empVO);
	}

	@Override
	public void empInsert(EmpVO empVO) {
		// TODO Auto-generated method stub
		
	}

}
