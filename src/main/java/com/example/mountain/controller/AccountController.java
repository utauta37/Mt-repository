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
import com.example.mountain.entity.Account;
import com.example.mountain.form.LoginForm;
import com.example.mountain.form.SignupForm;
import com.example.mountain.form.UpdateForm;
import com.example.mountain.service.AccountService;

import lombok.RequiredArgsConstructor;

/** 
 * ユーザー情報Controller
 * 
 * @author mina
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class AccountController {
	
	/** ユーザー情報service */
	private final AccountService service;
	
	
	/** 
	 * 新規ユーザー登録画面
	 * 
	 * @param signupForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/signup")
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
	@PostMapping(value="/signup",params="next")
	public String register(@Validated SignupForm signupForm,BindingResult result,Model model) {
		//チェック処理を行い画面遷移する
		if(result.hasErrors()) {
			return "mtUsers/register.html";
		}else if(service.userCheck(signupForm.getUsername())){
			model.addAttribute("signupError","ユーザー名がすでに使用されています");
			return "mtUsers/register.html";
		}
		return "mtUsers/confirm.html";
	}
	
	@PostMapping(value="/signup",params="save")
	public String register(SignupForm signupForm,Model model) {
		service.createUser(signupForm);
		return "redirect:/";
	}
	
	
	
	
	/** 
	 * ログイン画面
	 * 
	 * @param loginForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/login")
	public String loginView(LoginForm loginForm,Model model) {
		return "mtUsers/login.html";
	}
	

	/**
	 * ログイン
	 * 
	 * @param model 
	 * @return 表示画面
	 */
	@GetMapping("/user-mypage")
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
	@GetMapping("/user-update")
	public String login(@AuthenticationPrincipal UserDetailsImpl user,UpdateForm updateForm, Model model) {
		Account account = service.getUserByUsername(user.getUsername());
		model.addAttribute("mtUser",account);
		return "mtUsers/update.html";
	}
	
	
	
	@PostMapping(value="/user-update{id}",params="next")
	public String update(@Validated UpdateForm updateForm,BindingResult result,Model model) {
		//チェック処理を行い画面遷移する
		if(result.hasErrors()) {
			return "mtUsers/register.html";
		}else if(service.userCheck(updateForm.getUsername())){
			model.addAttribute("signupError","ユーザー名がすでに使用されています");
			return "mtUsers/user-update.html";
		}
		return "mtUsers/confirm.html";
	}
	
	@PostMapping(value="/user-update{id}",params="save")
	public String update(UpdateForm updateForm,Model model) {
		service.updateUser(updateForm);
		return "redirect:/mountain";
	}
}
