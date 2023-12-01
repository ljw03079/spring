package com.yedam.app.emp.service;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	String firstName;
	int dept;
	List<String> hobby;
}
