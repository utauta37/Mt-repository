package com.example.mountain.service;

import org.springframework.stereotype.Service;

import com.example.mountain.entity.User;
import com.example.mountain.form.LoginForm;
import com.example.mountain.form.SigninForm;
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

	/** ユーザー新規登録
	 * 
	 * @param signinForm 入力情報
	 */
	public void saveUser(SigninForm signinForm) {
		mapper.saveUser(signinForm);
	}
	
	/** ユーザー情報テーブル 入力情報で検索
	 * 
	 * @param loginForm 
	 * @return 検索結果
	 */
	public User selectUser(LoginForm loginForm){
		return mapper.selectUser(loginForm);
	}
}
