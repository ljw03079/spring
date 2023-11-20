package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AopMapper;
import com.yedam.app.aop.service.AopService;

@Service
public class AopServiceImpl implements AopService {

	@Autowired
	AopMapper aopMapper;
	

	public AopServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Transactional
	@Override
	public void insert() {
		aopMapper.insertNumber("101");
		aopMapper.insertNumber("a101");
	}

}
