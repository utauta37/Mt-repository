package com.example.mountain.entity;

import lombok.Data;

/** ユーザー情報テーブルEntity
 * 
 * @author mina
 * 
 */
@Data
public class Account {
	
	private int id;

	/** ユーザー名 */
	private String username;
	
	/** パスワード */
	private String password;
}
