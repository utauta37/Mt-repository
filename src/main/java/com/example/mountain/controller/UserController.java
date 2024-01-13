package com.example.mountain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mountain.form.LoginForm;
import com.example.mountain.form.SignupForm;
import com.example.mountain.service.UserService;

import lombok.RequiredArgsConstructor;

/** ユーザー情報Controller
 * 
 * 
 * @author mina
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {
	
	/** ユーザー情報service */
	private final UserService service;
	
	/** PasswordEncoder */
	//private final PasswordEncoder passwordEncoder;
	
	
	/** 新規ユーザー登録画面
	 * 
	 * @param signupForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/mountain/signup")
	public String registerView(SignupForm signupForm,Model model) {
		return "register.html";
	}
	
	/**
	 * ユーザー新規登録
	 * 
	 * @param signupForm
	 * @param result バインド結果
	 * @return 確認画面または入力画面へのパス
	 */
	@PostMapping(value="/mountain/signup",params="next")
	public String register(@Validated SignupForm signupForm,BindingResult result,Model model) {
		//チェック処理を行い画面遷移する
		if(result.hasErrors()) {
			return "register.html"; 
		}
		
		return "confirm.html";
	}
	
	@PostMapping(value="/mountain/signup",params="save")
	public String register(SignupForm signupForm,Model model) {
		service.saveUser(signupForm);
		return "redirect:/mountain/login";
	}
	
	
	/** ログイン画面
	 * 
	 * @param loginForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/mountain/login")
	public String loginView(LoginForm loginForm,Model model) {
		return "login.html";
	}
	
	/** ログイン
	 * 
	 * @param loginForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@PostMapping("/mountain/login")
	public String login(LoginForm loginForm,Model model) {	
		return "mypage.html";
	}
	
	@GetMapping("/mountain/user-mypage")
	public String mypageView(Model model) {
		return "mypage.html";
	}
}
