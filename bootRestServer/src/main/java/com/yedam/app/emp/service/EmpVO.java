package com.yedam.app.emp.service;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmpVO {
	String 		employeeId;
	String 		firstName;
	String 		lastName;
	String 		email;
	Timestamp   hireDate;
	String 		managerId;
	BigDecimal  salary;
	String 		jobId;
	String 		departmentId;
}
