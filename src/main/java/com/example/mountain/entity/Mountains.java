package com.example.mountain.entity;

import lombok.Data;

//DBから持ってきた情報を保管する
//カラム名と対応

@Data
public class Mountains {
	
	private int id;
	private String name;
	private String content;
	private int time;
	private String station;
	private String prefecture;
}
