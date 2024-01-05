package com.example.mountain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mountain.entity.Mountain;
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
	 * topページ
	 */
	//topページ表示
	@GetMapping("/mountain")
	public String top() {
		return "top.html";
	}
	
	// 検索ページを表示
	@GetMapping("/mountain/search")
	public String search() {
		return "search.html";
	}
	
	//運任せボタン（詳細画面を表示）
	@GetMapping("/mountain/random-show")
	public String randomShow(Model model) {
		Mountain mountain = mountainService.showOne();
		model.addAttribute("mtData",mountain);
		return "show.html";
	}
	
	
	/*
	 * 検索ページ
	 */
	//すべての山
	@GetMapping("/mountain/result-all")
	public String select(Model model) {
		List<Mountain> mountainList = mountainService.showAll();
		model.addAttribute("mtList",mountainList);
		return "result.html";
	}
	//場所で探す
	@GetMapping("/mountain/result-prefecture")
	public String selectPref(@RequestParam("prefecture") String prefecture,Model model) {
		List<Mountain> mountainList = mountainService.selectPref(prefecture);
		model.addAttribute("mtList",mountainList);
		return "result.html";
	}
	//コースタイムで探す
	@GetMapping("/mountain/result-coursetime")
	public String selectTime(@RequestParam("time") String time,Model model) {
		List<Mountain> mountainList = mountainService.selectTime(time);
		model.addAttribute("mtList",mountainList);
		return "result.html";
	}
	//気分で探す
	@GetMapping("/mountain/result-feeling")
	public String selectFeel(@RequestParam("feeling") String feeling,Model model) {
		List<Mountain> mountainList = mountainService.selectFeel(feeling);
		model.addAttribute("mtList",mountainList);
		return "result.html";
	}
	
	
	
	/*
	 * 詳細ページ
	 */
	@GetMapping("/mountain/show{id}")
	public String showView(@PathVariable("id") String id,Model model) {
		Mountain mountain = mountainService.findById(id);
		model.addAttribute("mtData",mountain);
		return "show.html";
	}
}
