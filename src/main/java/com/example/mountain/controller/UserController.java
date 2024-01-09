package com.example.mountain.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mountain.entity.User;
import com.example.mountain.form.LoginForm;
import com.example.mountain.form.SigninForm;
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
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/** 新規ユーザー登録画面
	 * 
	 * @param signinForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/mountain/signin")
	public String registerView(SigninForm signinForm,Model model) {
		return "register.html";
	}
	
	/** 新規ユーザー登録
	 * 
	 * @param signinForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@PostMapping("/mountain/signin")
		public String register(@ModelAttribute SigninForm signinForm,Model model) {
		service.saveUser(signinForm);
		return "mypage.html";
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
		User user = service.selectUser(loginForm);
		var isCorrectUserAuth = user.getEmail().equals(loginForm.getEmail());
		if(isCorrectUserAuth){
			return "redirect:/mypage.html";
		}else {
			model.addAttribute("errorMsg","メールアドレスとパスワードの組み合わせが間違っています。");
			return "login.html";
		}
	}
	
	
}
