package com.example.mountain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mountain.entity.Account;
import com.example.mountain.form.SignupForm;
import com.example.mountain.form.UpdateForm;
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
	
	//TODO 
	public void updateUser(UpdateForm updateForm) {
		//パスワードをハッシュ化して、updatetUser()に渡すオブジェクトにセット。
		updateForm.setPassword(passwordEncoder.encode(updateForm.getPassword()));
		mapper.updateUser(updateForm);	
	}

}
