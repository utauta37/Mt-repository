package com.example.mountain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.mountain.entity.User;
import com.example.mountain.form.LoginForm;
import com.example.mountain.form.SigninForm;

/** ユーザー情報Mapper
 * 
 * @author mina
 */
@Mapper
public interface UserMapper {

	void saveUser(SigninForm signinForm);
	
	public User selectUser(LoginForm loginform);
	
}
