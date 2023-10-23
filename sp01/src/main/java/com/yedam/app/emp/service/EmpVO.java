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
	
	// 1) �÷����� Ÿ���� ���� or ���� Ÿ�� ��� String
	// 2) �⺻Ÿ��(int, double ��) or Wrap Ŭ����(Integer, Double) => Null ����(�������� �� ����� ����� �ȵ� ���� ����.)
	// ù��°�� �⺻������ ��쿡 ����(������ ������ ��) �ι�°�� ���
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
	// sql.date�� ��¥��� �Ұ�, spring �ȿ����� sql�ȿ� �ִ� class ������� ����. => util.date�� ���
}
