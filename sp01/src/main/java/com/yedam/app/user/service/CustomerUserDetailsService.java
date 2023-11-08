package com.yedam.app.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yedam.app.user.LoginUserVO;
import com.yedam.app.user.UserVO;
import com.yedam.app.user.mapper.UserMapper;

@Component("userDetailsService")
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userMapper.getUser(username);
		
		if(userVO == null) {
			throw new UsernameNotFoundException("No User");
			
		}
		return new LoginUserVO(userVO);
	}

}
