package com.example.mountain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mountain.authentication.UserDetailsImpl;
import com.example.mountain.entity.Account;
import com.example.mountain.repository.AccountMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final AccountMapper mapper;
	

	//selectUserで取得した情報を、UserDetailsインターフェースを実装するクラスに変換する
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		Account account = mapper.findByUsername(username);
		//情報が取得できなかった場合UsernameNotFoundExceptionでthrowsする
		if(account == null) {
			throw new UsernameNotFoundException("User not found:" + username);
		}		
		return new UserDetailsImpl(account);
	}


}
