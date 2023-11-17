package com.yedam.app.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.user.service.UserService;
import com.yedam.app.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public UserVO insertUserInfo(UserVO userVO) {
		System.out.println("====== 단건처리) ");
		System.out.println(userVO);
		return userVO;
	}

	@Override
	public Map<String, Object> insertUserList(List<UserVO> userList) {
		Map<String, Object> map = new HashMap<>();
		int total = 0;
		System.out.println("======= 다건처리) ");
		for(UserVO user : userList) {
			System.out.println(user);
			total++;
		}
		
		System.out.println("====== End) ");
		map.put("count", total);
		map.put("list", userList);
		return map;
	}

}
