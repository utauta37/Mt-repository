package com.example.mountain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mountain.authentication.UserDetailsImpl;
import com.example.mountain.entity.MtUser;
import com.example.mountain.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserMapper mapper;
	
	//private final PasswordEncoder passwordEncoder;

	//selectUserで取得した情報を、UserDetailsインターフェースを実装するUserクラスに変換する
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		MtUser mtUser = mapper.findByUsername(username);
		//情報が取得できなかった場合UsernameNotFoundExceptionでthrowsする
		if(mtUser == null) {
			throw new UsernameNotFoundException("User not found:" + username);
		}
		return (new UserDetailsImpl(mtUser));
	}


}
