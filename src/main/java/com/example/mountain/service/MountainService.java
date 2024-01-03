package com.example.mountain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mountain.entity.Mountains;
import com.example.mountain.repository.MountainMapper;

//MountainMapperクラス（抽象クラス）のオーバーライドをして処理の記述
@Service
public class MountainService implements MountainMapper {
	
	//MountainMapperクラスのインスタンス化
	@Autowired
	MountainMapper mountainMapper;
	
	//「運まかせ」ランダム取得の結果を返す
	@Override
	public Mountains showOne(){
		return mountainMapper.showOne();
	}
	
	//「すべての山」全件取得
	@Override
	public List<Mountains> showAll(){
		return mountainMapper.showAll();
	}
	
	//「場所で検索」選ばれたボタンによって取得
	@Override
	public List<Mountains> selectPref(String prefecture){
		return mountainMapper.selectPref(prefecture);
	}
	

}

