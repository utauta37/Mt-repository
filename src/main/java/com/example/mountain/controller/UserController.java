package com.example.mountain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mountain.form.LoginForm;
import com.example.mountain.form.RegisterForm;
import com.example.mountain.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/mountain/register")
	public String registerView() {
		return "register.html";
	}
	@PostMapping("/mountain/register")
		public String register(@ModelAttribute RegisterForm registerForm,Model model) {
		userService.saveUser(registerForm);
		return "review_create.html";
	}
	//loginページ表示
	@GetMapping("/mountain/login")
	public String loginView(LoginForm form,Model model) {
		return "login.html";
	}
	@PostMapping("/mountain/login")
	public String login(LoginForm form) {
		
		return "review_create.html";
	}
}
