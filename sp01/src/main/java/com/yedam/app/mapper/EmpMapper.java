package com.yedam.app.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

//		com.yedam.app.**.mapper => ��ΰ� ���ƾ� ��.
public interface EmpMapper {
	public List<EmpVO> selectAllEmpInfo();
	public EmpVO selectEmpInfo(EmpVO empVo);
}
