package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class EmpVO {
	private String employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String hire_date;
	private String job_id;
	private String department_id;
	private String salary;
}
