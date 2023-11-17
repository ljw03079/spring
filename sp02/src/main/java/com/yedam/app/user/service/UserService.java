package com.yedam.app.user.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	// 단건처리
		public UserVO insertUserInfo(UserVO userVO);
		
	// 다건처리
		public Map<String, Object> insertUserList(List<UserVO> userList);
}
