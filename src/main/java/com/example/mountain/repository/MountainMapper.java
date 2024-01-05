package com.example.mountain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mountain.entity.Mountain;

//インターフェースに＠Mapperアノテーションを付与することで自動的にSpringのBeanとして登録される
@Mapper
public interface MountainMapper {
	
	//一件ランダム取得
	public Mountain showOne();
	
	//全件のデータを一覧で取得
	public List<Mountain> showAll();
	
	//prefectureの値に応じてデータを取得
	public List<Mountain> selectPref(String prefecture);
	
	//「long」または「short」でデータを取得
	public List<Mountain> selectTime(String time);
	
	//feeling１～４の数字に応じてデータを取得
	public List<Mountain> selectFeel(String feeling);
	
	//idにあったデータを一件取得
	public Mountain findById(String id);
}
