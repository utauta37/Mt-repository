package com.example.mountain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.mountain.entity.MtUser;
import com.example.mountain.form.SignupForm;
import com.example.mountain.form.UpdateForm;

/** ユーザー情報Mapper
 * 
 * @author mina
 */
@Mapper
public interface UserMapper {

	void insertUser(SignupForm signupForm);
	
	public MtUser findByUsername(String username);
	
	public MtUser selectUser(SignupForm signupForm);
	
	public MtUser updateUser(UpdateForm updateForm);
	
}
