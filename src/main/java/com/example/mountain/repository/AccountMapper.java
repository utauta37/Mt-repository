package com.example.mountain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.mountain.entity.Account;
import com.example.mountain.form.SignupForm;

/** ユーザー情報Mapper
 * 
 * @author mina
 */
@Mapper
public interface AccountMapper {

	void insertUser(SignupForm signupForm);
	
	public Account findByUsername(String username);
	
	void updateUsername(int id,String username);
	
	void updatePassword(int id,String password);
	
	void deleteUser(int id);
	
}
