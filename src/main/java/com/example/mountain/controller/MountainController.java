package com.example.mountain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mountain.entity.Mountains;
import com.example.mountain.service.MountainService;

@Controller
@RequestMapping("/")
public class MountainController {
	
	/*
	 * MountainServiceクラスのインスタンス化
	 */
	@Autowired
	MountainService mountainService;

	@GetMapping("/mountain")
	public String top() {
		return "top.html";
	}
	
	@GetMapping("/mountain/search")
	public String search() {
		return "search.html";
	}
	
	/*
	 * Serviceからデータを受け取りmountainに代入
	 * mtDataという名前でmountainにある情報を格納
	 * thymeleafで［mtData.カラム名］指定するとデータを表示できる
	 */
	@GetMapping("/mountain/random-show")
	public String randomShow(Model model) {
		Mountains mountain = mountainService.showOne();
		model.addAttribute("mtData",mountain);
		return "show.html";
	}
	
	@GetMapping("/mountain/result-all")
	public String select(Model model) {
		List<Mountains> mountainList = mountainService.showAll();
		model.addAttribute("mtList",mountainList);
		return "result.html";
	}
	
	@GetMapping("/mountain/result-prefecture")
	public String selectPref(@RequestParam("prefecture") String prefecture,Model model) {
		List<Mountains> mountainList = mountainService.selectPref(prefecture);
		model.addAttribute("mtList",mountainList);
		return "result.html";
	}

}
