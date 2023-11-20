package com.yedam.app.aop.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AopMapper {
	@Insert("INSERT INTO AAA VALUES (#{value})")
	public int insertNumber(String value);
}
