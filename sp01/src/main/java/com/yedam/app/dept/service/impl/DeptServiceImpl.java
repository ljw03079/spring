package com.yedam.app.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	DeptMapper deptMapper;

	@Override
	public List<DeptVO> getDeptAll() {
		return deptMapper.selectAllDeptInfo();
	}

	@Override
	public DeptVO getDeptInfo(DeptVO deptVO) {
		return deptMapper.selectDeptInfo(deptVO);
	}

	@Override
	public int insertDeptInfo(DeptVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		
		if(result == 1) {
			return deptVO.getDepartmentId();
		}else {
			return -1;
		}
	}
	
	
}
