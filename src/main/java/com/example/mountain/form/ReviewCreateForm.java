package com.example.mountain.form;

import java.io.Serializable;

import lombok.Data;

/**
 * レビュー作成Form
 * 
 * @author mina
 */
@Data
public class ReviewCreateForm  implements Serializable{
	
	private String title;
	
	private String body;
	
	
}
