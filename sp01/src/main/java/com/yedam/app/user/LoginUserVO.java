package com.yedam.app.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;

// security는 userdetails가 반드시 필요함.
// 필드를 기준으로 생성자 만들어줌.
@AllArgsConstructor
@Getter
public class LoginUserVO implements UserDetails {
	
	// UserDetails -> Ajax 통신할 때 거부하는 속성들 있음. loginUserVo와 UserVo 분리해서 만듦.
	private UserVO userVO;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority(userVO.getRole()));
		return auths;
	}

	@Override
	public String getPassword() {
		return userVO.getPwd();
	}

	@Override
	public String getUsername() {
		return userVO.getId();
	}

	@Override
	public boolean isAccountNonExpired() { // 계정 만료여부
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 계정 잠금여부
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 계정 패스워드 만료여부
		return true;
	}

	@Override
	public boolean isEnabled() { // 계정 사용가능 여부
		return true;
	}

}
