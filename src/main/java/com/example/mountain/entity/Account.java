package com.example.mountain.entity;

import java.sql.Timestamp;

import lombok.Data;

/** ユーザー情報テーブルEntity
 * 
 * @author mina
 * 
 */
@Data
public class Account {
	
	/** ユーザーid */
	private int id;

	/** ユーザー名 */
	private String username;
	
	/** パスワード */
	private String password;
	
	private Timestamp deletedAt;
	
	private String role;
}
