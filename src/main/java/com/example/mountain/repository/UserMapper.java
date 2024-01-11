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

	void saveUser(SignupForm signupForm);
	
	public MtUser selectUser(String username);
	
}
