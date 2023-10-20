package com.yedam.app.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

//		com.yedam.app.**.mapper => 경로가 같아야 함.
public interface EmpMapper {
	public List<EmpVO> selectAllEmpInfo();
	public EmpVO selectEmpInfo(EmpVO empVo);
}
