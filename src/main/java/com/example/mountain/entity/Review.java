package com.example.mountain.entity;

import java.util.Date;

import lombok.Data;

/**
 * レビュー情報テーブルEntity
 * 
 * @author mina
 */
@Data
public class Review {

	private int id;
	private String title;
	private String body;
	private Date createdAt;
	private Date deletedAt;
	private int mountainId;
	private int accountId;
	
	private String username;
//	private List<Mountain> mountainList;
//	private List<Account> accountList;
}
