package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private Date hireDate;
	private double salary;
	private double commissionPct;
	private String jobId;
	private int departmentId;
	private int managerId;
}
