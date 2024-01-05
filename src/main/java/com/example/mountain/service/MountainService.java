package com.example.mountain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mountain.entity.Mountain;
import com.example.mountain.repository.MountainMapper;

//MountainMapperクラス（抽象クラス）のオーバーライドをして処理の記述
@Service
public class MountainService implements MountainMapper {
	
	//MountainMapperクラスのインスタンス化
	@Autowired
	MountainMapper mountainMapper;
	
	//「運まかせ」ランダム取得の結果を返す
	@Override
	public Mountain showOne(){
		return mountainMapper.showOne();
	}
	
	//「すべての山」全件取得
	@Override
	public List<Mountain> showAll(){
		return mountainMapper.showAll();
	}
	
	//「場所で検索」選ばれたprefectureによって取得
	@Override
	public List<Mountain> selectPref(String prefecture){
		return mountainMapper.selectPref(prefecture);
	}
	//「コースタイムで検索」二択で分岐
	@Override
	public List<Mountain> selectTime(String time){
		return mountainMapper.selectTime(time);
	}
	//「気分で検索」選ばれたfeelingによって取得
	@Override
	public List<Mountain> selectFeel(String feeling){
		return mountainMapper.selectFeel(feeling);
	}
	//「山の名前」山のidによって取得
	@Override
	public Mountain findById(String id){
		return mountainMapper.findById(id);
	}
}

