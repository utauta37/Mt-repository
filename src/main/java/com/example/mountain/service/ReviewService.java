package com.example.mountain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mountain.authentication.UserDetailsImpl;
import com.example.mountain.form.ReviewCreateForm;
import com.example.mountain.repository.ReviewMapper;

import lombok.RequiredArgsConstructor;

/**
 * レビュー情報Service
 * 
 * @author mina
 */
@RequiredArgsConstructor
@Service
public class ReviewService {
	
	/** レビュー情報Mapper */
	private final ReviewMapper mapper;
	
	/**
	 * レビュー作成
	 * 
	 * @param user 認証情報
	 * @param mountainId 山識別id
	 * @param reviewCreateForm 入力情報
	 */
	@Transactional
	public void createReview(UserDetailsImpl user,int mountainId,ReviewCreateForm reviewCreateForm) {
		int accountId = user.GetId();
		String title = reviewCreateForm.getTitle();
		String body = reviewCreateForm.getBody();
		mapper.insertReview(accountId,mountainId,title,body);
	}

}
