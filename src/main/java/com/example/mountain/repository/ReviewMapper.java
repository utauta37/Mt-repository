package com.example.mountain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mountain.entity.Review;

/**
 * レビュー情報Mapper
 * 
 * @author mina
 */
@Mapper
public interface ReviewMapper {
	
	void insertReview(@Param("accountId")int accountId,@Param("mountainId")int mountainId,@Param("title")String title,@Param("body")String body);

	public List<Review> selectByMountainId(int id);
}
