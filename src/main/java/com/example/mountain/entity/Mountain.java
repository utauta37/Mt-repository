package com.example.mountain.entity;

import lombok.Data;

/*
 * mountainssテーブルから取得したデータを保管
 * 各カラム名に対応
 */

@Data
public class Mountain {
	
	private int id;
	private String name;
	private String content;
	private int time;
	private String station;
	private String prefecture;

}
