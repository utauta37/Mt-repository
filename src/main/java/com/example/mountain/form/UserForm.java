package com.example.mountain.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserForm implements Serializable{

	private String email;
	private String password;
}
