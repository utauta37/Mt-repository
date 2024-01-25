package com.example.mountain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * レビュー情報Mapper
 * 
 * @author mina
 */
@Mapper
public interface ReviewMapper {
	
	void insertReview(@Param("accountId")int accountId,@Param("mountainId")int mountainId,@Param("title")String title,@Param("body")String body);

}
