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
	private final MountainMapper mountainMapper;
	
	
	/**
	 * 運まかせ
	 * 
	 * @return ランダム取得の結果
	 */
	public Mountain showOne(){
		return mountainMapper.showOne();
	}
	
	/**
	 * すべての山
	 * 
	 * @return 全件取得
	 */
	public List<Mountain> showAll(){
		return mountainMapper.showAll();
	}

	/**
	 * 場所で検索
	 * 
	 * @param prefecture
	 * @return prefectureによって取得
	 */
	public List<Mountain> selectPref(String prefecture){
		return mountainMapper.selectPref(prefecture);
	}
	
	/**
	 * コースタイムで検索
	 * 
	 * @param time
	 * @return 二択で分岐
	 */
	public List<Mountain> selectTime(String time){
		return mountainMapper.selectTime(time);
	}
	
	/**
	 * 気分で検索
	 * 
	 * @param feeling
	 * @return feelingによって取得
	 */
	public List<Mountain> selectFeel(String feeling){
		return mountainMapper.selectFeel(feeling);
	}
	
	/**
	 * 山の詳細
	 * 
	 * @param id
	 * @return idによって取得
	 */
	public Mountain findById(String id){
		return mountainMapper.findById(id);
	}
}

