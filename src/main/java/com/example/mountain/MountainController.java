package com.example.mountain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MountainController {

	@GetMapping("/mountain")
	public String top() {
		return "top.html";
	}
	
	@GetMapping("/mountain/search")
	public String search() {
		return "search.html";
	}
}
