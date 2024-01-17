package com.example.mountain.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/** ログイン画面form
 * 
 * @author mina
 */

@Data
public class LoginForm implements Serializable{
	
	/** メールアドレス */
	@Size(max = 256,min = 6)
	@NotBlank
	private String username;
	
	/** パスワード */
	@Size(max = 128,min = 8)
	@NotBlank
	private String password;
}
