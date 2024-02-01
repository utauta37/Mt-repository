package com.example.mountain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mountain.entity.Mountain;
import com.example.mountain.repository.MountainMapper;

import lombok.RequiredArgsConstructor;


/**
 * 山の検索機能service
 * 
 * @author mina
 */
@RequiredArgsConstructor
@Service
public class MountainService{
	
	/** MountainMapper */
	private final MountainMapper mapper;
	
	
	/**
	 * 運まかせ
	 * 
	 * @return ランダム取得の結果
	 */
	public Mountain showOne(){
		return mapper.showOne();
	}
	
	/**
	 * すべての山
	 * 
	 * @return 全件取得
	 */
	public List<Mountain> showAll(){
		return mapper.showAll();
	}

	/**
	 * 場所で検索
	 * 
	 * @param prefecture
	 * @return prefectureによって取得
	 */
	public List<Mountain> selectPref(String prefecture){
		return mapper.selectPref(prefecture);
	}
	
	/**
	 * コースタイムで検索
	 * 
	 * @param time
	 * @return 二択で分岐
	 */
	public List<Mountain> selectTime(String time){
		return mapper.selectTime(time);
	}
	
	/**
	 * 気分で検索
	 * 
	 * @param feeling
	 * @return feelingによって取得
	 */
	public List<Mountain> selectFeel(String feeling){
		return mapper.selectFeel(feeling);
	}
	
	/**
	 * 山の詳細
	 * 
	 * @param id
	 * @return idによって取得
	 */
	public Mountain findById(int mountainId){
		return mapper.findById(mountainId);
	}
}

