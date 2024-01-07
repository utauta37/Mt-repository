package com.example.mountain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mountain.form.RegisterForm;
import com.example.mountain.repository.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;

	public void saveUser(RegisterForm registerForm) {
		userMapper.saveUser(registerForm);
	}
}
