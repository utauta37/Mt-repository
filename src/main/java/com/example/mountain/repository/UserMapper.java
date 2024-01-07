package com.example.mountain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.mountain.form.RegisterForm;

@Mapper
public interface UserMapper {

	void saveUser(RegisterForm registerForm);
}
