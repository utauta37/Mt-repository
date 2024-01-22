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
	
	
	/**
	 * 二重登録のチェック
	 * 
	 * @param username
	 * @return　同じusernameが見つかればtrue、見つからなければfalse
	 */
	public boolean userCheck(String username){
		if(mapper.findByUsername(username) != null) {
			return true;
		}
		return false;
	}
	

	/**
	 * ユーザー新規登録
	 * 
	 * @param signupForm　入力情報
	 */
	@Transactional
	public void createUser(SignupForm signupForm){
		//パスワードをハッシュ化して、insertUser()に渡すオブジェクトにセット。
		signupForm.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		mapper.insertUser(signupForm);	
	}
	
	
	/** ユーザー情報テーブル 入力情報で検索
	 * 
	 * @param loginForm 入力情報
	 * @return 検索結果
	 */
	public Account getUserByUsername(String username){
		return mapper.findByUsername(username);
	}
	
	/**
	 * ユーザー名変更
	 * 
	 * @param user　認証情報
	 * @param usernameUpdateForm　新ユーザー名
	 */
	@Transactional
	public void updateUsername(UserDetailsImpl user,UsernameUpdateForm usernameUpdateForm) {
		int id = user.GetId();
		String username = usernameUpdateForm.getUsername();
		mapper.updateUsername(id,username);
	}
	
	/**
	 * パスワード変更
	 * 
	 * @param user　認証情報
	 * @param passwordUpdateForm　新パスワード
	 */
	@Transactional
	public void updatePassword(UserDetailsImpl user,PasswordUpdateForm passwordUpdateForm) {
		int id = user.GetId();
		//パスワードをハッシュ化
		String password = passwordEncoder.encode(passwordUpdateForm.getPassword());
		mapper.updatePassword(id,password);	
	}

}
