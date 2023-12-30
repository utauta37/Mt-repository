package com.example.mountain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mountain.entity.Mountains;
import com.example.mountain.service.MountainRepository;

@Controller
@RequestMapping("/")
public class MountainController {
	
	@Autowired
	MountainRepository mountainRepository;

	@GetMapping("/mountain")
	public String top() {
		return "top.html";
	}
	
	@GetMapping("/mountain/search")
	public String search() {
		return "search.html";
	}
	
	@GetMapping("/mountain/show")
	public String show(Model model) {
		Mountains mountain = mountainRepository.showOne();
		model.addAttribute("mtData",mountain);
		return "show.html";
	}
	

}
