package com.example.mountain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.mountain.entity.Mountains;
import com.example.mountain.repository.MountainMapper;

@Service
@Repository
public class MountainRepository implements MountainMapper {
	
	//MountainMapperクラスのインスタンス化をしてくれる
	@Autowired
	MountainMapper mr;
	
	//MountainMapperクラス（抽象クラス）のオーバーライドをする（処理の追加）
	@Override
	public List<Mountains> showAll(){
		return mr.showAll();
	}
	
	@Override
	public Mountains showOne(){
		return mr.showOne();
	}
}

