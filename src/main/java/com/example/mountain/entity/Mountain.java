package com.example.mountain.entity;

import lombok.Data;

/**
 * 山の情報テーブルEntity
 * 
 * @author mina
 */

@Data
public class Mountain {
	
	private int id;
	private String name;
	private String content;
	private int time;
	private String station;
	private String prefecture;
	private String images;

}
