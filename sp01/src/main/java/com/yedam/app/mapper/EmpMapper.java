package com.yedam.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

//		com.yedam.app.**.mapper => 경로가 같아야 함.
public interface EmpMapper {
	// 전체조회 (다건조회)
	public List<EmpVO> selectAllEmpInfo();
	
	// 사원조회 (단건조회)
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	// 등록
	public int insertEmpInfo(EmpVO empVO);
	
	// 수정
	public int updateEmpInfo(EmpVO empVO);
	
	// 수정 : Dynamic SQL
	public int updateEmpInfoDynamic(EmpVO empVO);
	
	// 삭제
	// @Param : SQL 안의 이름을 정해주기 위해 사용, 매개변수 2개 이상일 경우 주로 사용
	// 객체일 때는 paramName.employeeName 형식으로 SQL에 사용
	public int deleteEmpInfo(@Param("empid") int employeeId);
}
