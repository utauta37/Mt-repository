package com.example.mountain.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.mountain.entity.MtUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {
	
	private final MtUser mtUser;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getPassword() {
		return mtUser.getPassword();
	}

	@Override
	public String getUsername() {
		return mtUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
