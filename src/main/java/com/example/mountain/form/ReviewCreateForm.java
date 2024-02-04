package com.example.mountain.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * レビュー作成Form
 * 
 * @author mina
 */
@Data
public class ReviewCreateForm  implements Serializable{
	
	
	@Size(max = 30,message="タイトルは30字以内で入力してください")
	@NotBlank(message="タイトルを入力してください")
	private String title;
	
	@Size(max = 1000,message="投稿文は1000字以内で入力してください")
	@NotBlank(message="投稿文を入力してください")
	private String body;
	
	
}
