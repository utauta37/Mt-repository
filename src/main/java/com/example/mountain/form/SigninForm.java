package com.example.mountain.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SigninForm implements Serializable{

	@Size(max = 10,min = 1)
	@NotBlank
	private String userName;
	
	@Size(max = 256,min = 6)
	@NotBlank
	private String email;
	
	@Size(max = 128,min = 8)
	@NotBlank
	private String password;
}
