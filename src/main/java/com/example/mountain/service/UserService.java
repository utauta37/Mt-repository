package com.example.mountain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mountain.entity.MtUser;
import com.example.mountain.form.SignupForm;
import com.example.mountain.repository.UserMapper;

import lombok.RequiredArgsConstructor;

/** ユーザー情報Service
 * 
 * @author mina
 */
@Service
@RequiredArgsConstructor
public class UserService {
	
	/** ユーザー情報テーブルDAO */
	private final UserMapper mapper;
	
	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;
	

	/** ユーザー新規登録
	 * 
	 * @param signupForm 入力情報
	 */
	public void saveUser(SignupForm signupForm) {
		//パスワードをハッシュ化して、saveUser()に渡すオブジェクトにセット。
		signupForm.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		mapper.saveUser(signupForm);
		
		//TODO パスワードをハッシュ化
		
	}
	
	/** ユーザー情報テーブル 入力情報で検索
	 * 
	 * @param loginForm 
	 * @return 検索結果
	 */
	public MtUser selectUser(String username){
		return mapper.selectUser(username);
	}
}
