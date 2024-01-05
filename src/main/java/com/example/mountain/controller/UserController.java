package com.example.mountain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mountain.form.UserForm;

@Controller
@RequestMapping("/")
public class UserController {
	
	//loginページ表示
	@GetMapping("/mountain/login")
	public String loginview(UserForm form,Model model) {
		return "login.html";
	}
	@PostMapping("/mountain/login")
	public void login(UserForm form) {
		System.out.println(form.toString());//コンソールにデータがとんだ！
	}
}
