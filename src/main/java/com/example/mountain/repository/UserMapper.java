package com.example.mountain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.mountain.entity.MtUser;
import com.example.mountain.form.SignupForm;

/** ユーザー情報Mapper
 * 
 * @author mina
 */
@Mapper
public interface UserMapper {

	void insertUser(SignupForm signupForm);
	
	public MtUser findByUsername(String username);
	
	public MtUser selectUser(SignupForm signupForm);
	
}
