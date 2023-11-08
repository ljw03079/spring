package com.yedam.app.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;

// security�� userdetails�� �ݵ�� �ʿ���.
// �ʵ带 �������� ������ �������.
@AllArgsConstructor
@Getter
public class LoginUserVO implements UserDetails {
	
	// UserDetails -> Ajax ����� �� �ź��ϴ� �Ӽ��� ����. loginUserVo�� UserVo �и��ؼ� ����.
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
	public boolean isAccountNonExpired() { // ���� ���Ῡ��
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // ���� ��ݿ���
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // ���� �н����� ���Ῡ��
		return true;
	}

	@Override
	public boolean isEnabled() { // ���� ��밡�� ����
		return true;
	}

}
