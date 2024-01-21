package com.example.mountain.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PasswordUpdateForm {
	
	
	@Size(min = 8,max = 128, message="パスワードは8文字以上です")
	@NotBlank
	private String password;
}
