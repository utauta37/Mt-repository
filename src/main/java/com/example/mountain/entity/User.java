package com.example.mountain.entity;

import lombok.Data;

/** ユーザー情報テーブルEntity
 * 
 * @author mina
 * 
 */
@Data
public class User {

	/** ユーザー名 */
	private String userName;
	
	/** メールアドレス */
	private String email;
	
	/** パスワード */
	private String password;
}
