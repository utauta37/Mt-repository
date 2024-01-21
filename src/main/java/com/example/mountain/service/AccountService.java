package com.example.mountain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mountain.authentication.UserDetailsImpl;
import com.example.mountain.entity.Account;
import com.example.mountain.form.PasswordUpdateForm;
import com.example.mountain.form.SignupForm;
import com.example.mountain.form.UsernameUpdateForm;
import com.example.mountain.repository.AccountMapper;

import lombok.RequiredArgsConstructor;

/** ユーザー情報Service
 * 
 * @author mina
 */
@Service
@RequiredArgsConstructor
public class AccountService {
	
	/** ユーザー情報テーブルDAO */
	private final AccountMapper mapper;
	
	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;
	
	
	
	public boolean userCheck(String username){
		// 二重登録のチェック
		
		if(mapper.findByUsername(username) != null) {
			return true;
		}
		return false;
	}
	

	/** ユーザー新規登録
	 * 
	 * @param signupForm 入力情報
	 * @throws Exception 
	 */
	@Transactional
	public void createUser(SignupForm signupForm){
		
		//パスワードをハッシュ化して、insertUser()に渡すオブジェクトにセット。
		signupForm.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		mapper.insertUser(signupForm);	
	}
	
	/** ユーザー情報テーブル 入力情報で検索
	 * 
	 * @param loginForm 
	 * @return 検索結果
	 */
	public Account getUserByUsername(String username){
		return mapper.findByUsername(username);
	}
	
	/**
	 * ユーザー名変更
	 * 
	 * @param usernameUpdateForm　新ユーザー名
	 */
	public void updateUsername(UserDetailsImpl user,UsernameUpdateForm usernameUpdateForm) {
		int id = user.GetId();
		String username = usernameUpdateForm.getUsername();
		mapper.updateUsername(id,username);
	}
	
	/**
	 * パスワード変更
	 * 
	 * @param passwordUpdateForm　新パスワード
	 */
	public void updatePassword(PasswordUpdateForm passwordUpdateForm) {
		//パスワードをハッシュ化して、updatetUser()に渡すオブジェクトにセット。
		passwordUpdateForm.setPassword(passwordEncoder.encode(passwordUpdateForm.getPassword()));
		mapper.updatePassword(passwordUpdateForm);	
	}

}
