package com.example.mountain.form;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateForm {
	
	private int id;

	@Size(min = 1,max = 50, message="名前は１文字以上です")
	private String username;

	@Size(min = 8,max = 128, message="パスワードは8文字以上です")
	private String password;
}
