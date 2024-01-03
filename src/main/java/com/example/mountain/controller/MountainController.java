package com.example.mountain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	/*
	 * topページの表示
	 */
	@GetMapping("/mountain")
	public String top() {
		return "top.html";
	}
	
	// 関東の山を探すボタン（検索画面を表示）
	@GetMapping("/mountain/search")
	public String search() {
		return "search.html";
	}
	
	//運任せボタン
	@GetMapping("/mountain/random-show")
	public String randomShow(Model model) {
		Mountains mountain = mountainService.showOne();
		model.addAttribute("mtData",mountain);
		return "show.html";
	}
	
	
	/*
	 * 検索画面
	 */
	//すべての山
	@GetMapping("/mountain/result-all")
	public String select(Model model) {
		List<Mountains> mountainList = mountainService.showAll();
		model.addAttribute("mtList",mountainList);
		return "result.html";
	}
	//場所で探す
	@GetMapping("/mountain/result-prefecture")
	public String selectPref(@RequestParam("prefecture") String prefecture,Model model) {
		List<Mountains> mountainList = mountainService.selectPref(prefecture);
		model.addAttribute("mtList",mountainList);
		return "result.html";
	}
	//コースタイムで探す
	@GetMapping("/mountain/result-coursetime")
	public String selectTime(@RequestParam("time") String time,Model model) {
		List<Mountains> mountainList = mountainService.selectTime(time);
		model.addAttribute("mtList",mountainList);
		return "result.html";
	}
	
	
	
	/*
	 * 詳細画面
	 */
	@GetMapping("/mountain/show{id}")
	public String showView(@PathVariable("id") String id,Model model) {
		Mountains mountain = mountainService.findById(id);
		model.addAttribute("mtData",mountain);
		return "show.html";
	}
}
