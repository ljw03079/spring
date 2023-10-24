package com.yedam.app.dept.service;

import java.util.List;

public interface DeptService {
	// 전체조회
	public List<DeptVO> getDeptAll();
	
	// 단건조회
	public DeptVO getDeptInfo(DeptVO deptVO);
	
	// 등록
	public int insertDeptInfo(DeptVO deptVO);
}
