package com.example.mountain.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mountain.authentication.UserDetailsImpl;
import com.example.mountain.form.LoginForm;
import com.example.mountain.form.SignupForm;
import com.example.mountain.form.UpdateForm;
import com.example.mountain.service.UserService;

import lombok.RequiredArgsConstructor;

/** 
 * ユーザー情報Controller
 * 
 * @author mina
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {
	
	/** ユーザー情報service */
	private final UserService service;
	
	
	/** 
	 * 新規ユーザー登録画面
	 * 
	 * @param signupForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/mountain/signup")
	public String registerView(SignupForm signupForm) {
		return "mtUsers/register.html";
	}
	
	/**
	 * ユーザー新規登録
	 * 
	 * @param signupForm
	 * @param result バインド結果
	 * @return 確認画面または入力画面へのパス
	 * @throws Exception 
	 */
	@PostMapping(value="/mountain/signup",params="next")
	public String register(@Validated SignupForm signupForm,BindingResult result,Model model) {
		//チェック処理を行い画面遷移する
		if(result.hasErrors()) {
			return "mtUsers/register.html";
		}else if(service.userCheck(signupForm)){
			model.addAttribute("signupError","ユーザー名がすでに使用されています");
			return "mtUsers/register.html";
		}
		return "mtUsers/confirm.html";
	}
	
	@PostMapping(value="/mountain/signup",params="save")
	public String register(SignupForm signupForm,Model model) {
		service.createUser(signupForm);
		return "redirect:/mountain";
	}
	
	
	
	
	/** 
	 * ログイン画面
	 * 
	 * @param loginForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/mountain/login")
	public String loginView(LoginForm loginForm,Model model) {
		return "mtUsers/login.html";
	}
	

	/**
	 * ログイン
	 * 
	 * @param model 
	 * @return 表示画面
	 */
	@GetMapping("/mountain/user-mypage")
	public String login(@AuthenticationPrincipal UserDetailsImpl user,Model model) {
		return "mtUsers/mypage.html";
	}
	
	
	/**
	 * ユーザー情報変更画面
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@GetMapping("/mountain/user-update")
	public String updateView(@AuthenticationPrincipal UserDetailsImpl user,UpdateForm updateForm,Model model) {
		return "mtUsers/update.html";
	}
	
	@PostMapping(value="/mountain/user-update",params="next")
	public String update(@Validated UpdateForm updateForm,BindingResult result,Model model) {
		//チェック処理を行い画面遷移する
		if(result.hasErrors()) {
			return "mtUsers/register.html";
		//TODO　signupFormでuserCheckメソッドをつくっているのでそのまま使えない…
		}else if(service.userCheck(updateForm)){
			model.addAttribute("signupError","ユーザー名がすでに使用されています");
			return "mtUsers/register.html";
		}
		return "mtUsers/confirm.html";
	}
	
	@PostMapping(value="/mountain/user-update",params="save")
	public String update(UpdateForm updateForm,Model model) {
		//TODO　別でServiceつくるしかない？？？
		service.updateUser(updateForm);
		return "redirect:/mountain";
	}
}
