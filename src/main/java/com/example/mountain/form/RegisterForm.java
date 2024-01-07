package com.example.mountain.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class RegisterForm implements Serializable{

	private String userName;
	private String email;
	private String password;
}
