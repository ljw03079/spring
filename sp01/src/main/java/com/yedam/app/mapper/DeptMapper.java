package com.yedam.app.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	// ��ü��ȸ
	public List<DeptVO> selectAllDeptInfo();
	
	// �ܰ���ȸ
	public DeptVO selectDeptInfo(DeptVO deptVO);
	
	// ���
	public int insertDeptInfo(DeptVO deptVO);
}
