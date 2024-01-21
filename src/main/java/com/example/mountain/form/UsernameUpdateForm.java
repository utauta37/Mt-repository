package com.example.mountain.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsernameUpdateForm implements Serializable{
	


	@Size(min = 1,max = 50, message="名前は１文字以上です")
	@NotBlank
	private String username;

}
