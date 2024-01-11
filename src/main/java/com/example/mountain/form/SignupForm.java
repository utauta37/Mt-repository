package com.example.mountain.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/** ユーザー新規登録画面form
 * 
 * @author mina
 */
@Data
public class SignupForm implements Serializable{

	@Size(min = 1,max = 50, message="名前は１文字以上です")
	@NotBlank(message="名前が入力されていません")
	private String username;

	
	@Size(min = 8,max = 128, message="パスワードは8文字以上です")
	@NotBlank(message="パスワードを入力してください")
	private String password;
}
