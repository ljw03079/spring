package com.yedam.app.dept.service;

import java.util.List;

public interface DeptService {
	// ��ü��ȸ
	public List<DeptVO> getDeptAll();
	
	// �ܰ���ȸ
	public DeptVO getDeptInfo(DeptVO deptVO);
	
	// ���
	public int insertDeptInfo(DeptVO deptVO);
}
