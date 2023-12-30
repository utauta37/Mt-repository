package com.example.mountain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mountain.entity.Mountains;

//インターフェースに＠Mapperアノテーションを付与することで自動的にSpringのBeanとして登録される
@Mapper
public interface MountainMapper {
	//Mountainsクラス(entity)のインスタンスを一覧で持つListクラスを生成
	public List<Mountains> showAll();
	
	
	public Mountains showOne();
}
