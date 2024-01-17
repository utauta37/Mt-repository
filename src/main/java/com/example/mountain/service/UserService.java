package com.example.mountain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mountain.entity.MtUser;
import com.example.mountain.form.SignupForm;
import com.example.mountain.form.UpdateForm;
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
	
	
	
	public boolean userCheck(SignupForm signupForm){
		// 二重登録のチェック
		
		if(mapper.findByUsername(signupForm.getUsername()) != null) {
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
	public MtUser getUserByUsername(String username){
		return mapper.findByUsername(username);
	}
	
	//TODO 
	public void updateUser(UpdateForm updateForm) {
		//パスワードをハッシュ化して、insertUser()に渡すオブジェクトにセット。
		updateForm.setPassword(passwordEncoder.encode(updateForm.getPassword()));
		mapper.updateUser(updateForm);	
	}

}
