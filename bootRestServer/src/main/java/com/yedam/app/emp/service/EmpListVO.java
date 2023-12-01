package com.yedam.app.emp.service;

import java.util.List;

import lombok.Data;

@Data
public class EmpListVO {
	String departmentId;
	List<EmpVO> emps;
}
