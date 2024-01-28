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

	//レビューの内容
	private int id;
	private String title;
	private String body;
	private Date createdAt;
	private Date deletedAt;
	private int mountainId;
	private int accountId;
	
	//レビューを作成したユーザー名
	private String username;
	
	//レビュー対象の山の名前
	private String name;
	
}
