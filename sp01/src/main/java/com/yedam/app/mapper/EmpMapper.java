package com.yedam.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

//		com.yedam.app.**.mapper => ��ΰ� ���ƾ� ��.
public interface EmpMapper {
	// ��ü��ȸ (�ٰ���ȸ)
	public List<EmpVO> selectAllEmpInfo();
	
	// �����ȸ (�ܰ���ȸ)
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	// ���
	public int insertEmpInfo(EmpVO empVO);
	
	// ����
	public int updateEmpInfo(EmpVO empVO);
	
	// ���� : Dynamic SQL
	public int updateEmpInfoDynamic(EmpVO empVO);
	
	// ����
	// @Param : SQL ���� �̸��� �����ֱ� ���� ���, �Ű����� 2�� �̻��� ��� �ַ� ���
	// ��ü�� ���� paramName.employeeName �������� SQL�� ���
	public int deleteEmpInfo(@Param("empid") int employeeId);
}
