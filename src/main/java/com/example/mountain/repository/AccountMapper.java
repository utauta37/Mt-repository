package com.example.mountain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.mountain.entity.Account;
import com.example.mountain.form.SignupForm;
import com.example.mountain.form.UpdateForm;

/** ユーザー情報Mapper
 * 
 * @author mina
 */
@Mapper
public interface AccountMapper {

	void insertUser(SignupForm signupForm);
	
	public Account findByUsername(String username);
	
	public Account selectUser(SignupForm signupForm);
	
	void updateUser(UpdateForm updateForm);
	
}
