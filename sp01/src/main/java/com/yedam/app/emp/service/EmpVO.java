package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
//	private String employee_id;
//	private String first_name;
//	private String last_name;
//	private String email;
//	private String hire_date;
//	private String job_id;
//	private String department_id;
//	private String salary;
	
	// 1) 컬럼따라 타입을 구분 or 실제 타입 대신 String
	// 2) 기본타입(int, double 등) or Wrap 클랩스(Integer, Double) => Null 포함(연산했을 때 제대로 계산이 안될 수도 있음.)
	// 첫번째가 기본이지만 경우에 따라(문제가 생겼을 시) 두번째를 사용
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentId;
	// sql.date는 날짜계산 불가, spring 안에서는 sql안에 있는 class 사용하지 않음. => util.date만 사용
}
