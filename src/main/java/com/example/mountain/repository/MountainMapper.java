package com.example.mountain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mountain.entity.Mountains;

//インターフェースに＠Mapperアノテーションを付与することで自動的にSpringのBeanとして登録される
@Mapper
public interface MountainMapper {
	
	//一件ランダム取得
	public Mountains showOne();
	
	//全件のデータを一覧で取得
	public List<Mountains> showAll();
	
	//
	public List<Mountains> selectPref(String prefecture);
	
}
