package com.example.mountain.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mountain.authentication.UserDetailsImpl;
import com.example.mountain.entity.Review;
import com.example.mountain.form.LoginForm;
import com.example.mountain.form.PasswordUpdateForm;
import com.example.mountain.form.SignupForm;
import com.example.mountain.form.UsernameUpdateForm;
import com.example.mountain.service.AccountService;
import com.example.mountain.service.ReviewService;

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
	private final AccountService accountService;
	
	/** レビュー情報Service */
	private final ReviewService reviewService;
	
	
	/** 
	 * ログイン画面
	 * 
	 * @param loginForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/login")
	public String loginView(LoginForm loginForm,Model model) {
		return "accounts/login";
	}
	
	/**
	 * ログイン成功後画面
	 * 
	 * @param user 認証情報
	 * @param model
	 * @return　表示画面
	 */
	@GetMapping("/mypage")
	public String loginSuccess(@AuthenticationPrincipal UserDetailsImpl user,Model model) {
		List<Review> reviewList = reviewService.selectUserReview(user);
		model.addAttribute("reviewList",reviewList);
		return "accounts/mypage";
	}
	
	
	
	/** 
	 * 新規ユーザー登録画面
	 * 
	 * @param signupForm 入力情報
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/signup")
	public String registerView(SignupForm signupForm,@AuthenticationPrincipal UserDetailsImpl user) {
		//ログイン中の場合はマイページへ
		if(user != null) {
			return "redirect:/mypage";
		}
		return "accounts/register";
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
			return "accounts/register";
		}
		if(accountService.userCheck(signupForm.getUsername())){
			model.addAttribute("signupError","ユーザー名がすでに使用されています");
			return "accounts/register";
		}
		return "accounts/confirm-register";
	}
	/**
	 * ユーザー新規登録実行
	 * 
	 * @param signupForm　入力情報
	 * @param model
	 * @return　表示画面リダイレクト
	 */
	@PostMapping(value="/signup",params="save")
	public String register(SignupForm signupForm,Model model) {
		accountService.createUser(signupForm);
		return "redirect:/mountain";
	}
	
	
	/**
	 * レビュー削除
	 * 
	 * @param reviewId
	 * @return
	 */
	@PostMapping("/review-delete")
	public String deleteReview(@RequestParam("id")int reviewId) {
		reviewService.deleteReview(reviewId);
		return "redirect:/mypage";
	}
	
	
	/**
	 * ユーザー名変更画面
	 * 
	 * @param user 認証情報
	 * @param usernameUpdateForm
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/update/username")
	public String updateView(@AuthenticationPrincipal UserDetailsImpl user,UsernameUpdateForm usernameUpdateForm,Model model) {
		return "accounts/update-username";
	}
	
	
	/**
	 * ユーザー名変更（確認）
	 * 
	 * @param usernameUpdateForm　入力情報
	 * @param result　バリデーションの結果
	 * @param model
	 * @return　確認画面または入力画面へのパス
	 */
	@PostMapping(value="/update/username",params="next")
	public String updateUsername(@Validated UsernameUpdateForm usernameUpdateForm,BindingResult result,Model model) {
		//チェック処理を行い画面遷移する
		if(result.hasErrors()) {
			return "accounts/update-username";
		}
		if(accountService.userCheck(usernameUpdateForm.getUsername())){
			model.addAttribute("updateError","ユーザー名がすでに使用されています");
			return "accounts/update-username";
		}
		return "accounts/confirm-username";
	}
	
	/**
	 * ユーザー名変更（実行）
	 * 
	 * @param user　認証情報
	 * @param usernameUpdateForm　入力情報
	 * @param model
	 * @return　表示画面リダイレクト
	 */
	@PostMapping(value="/update/username",params="save")
	public String updateUsename(@AuthenticationPrincipal UserDetailsImpl user,UsernameUpdateForm usernameUpdateForm,Model model) {
		accountService.updateUsername(user,usernameUpdateForm);
		return "redirect:/mountain";
	}
	
	
	
	/**
	 * パスワード変更画面
	 * 
	 * @param user　認証情報
	 * @param passwordUpdateForm　入力情報
	 * @param model
	 * @return　表示画面
	 */
	@GetMapping("/update/password")
	public String updateView(@AuthenticationPrincipal UserDetailsImpl user,PasswordUpdateForm passwordUpdateForm,Model model) {
		return "accounts/update-password";
	}
	
	/**
	 * パスワード変更（確認）
	 * 
	 * @param passwordUpdateForm　入力情報
	 * @param result　バリデーションの結果
	 * @param model
	 * @return　確認画面または入力画面へのパス
	 */
	@PostMapping(value="/update/password",params="next")
	public String updatePassword(@Validated PasswordUpdateForm passwordUpdateForm,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "accounts/update-password";
		}return "accounts/confirm-password";
	}
	
	/**
	 * パスワード変更（実行）
	 * 
	 * @param user　認証情報
	 * @param passwordUpdateForm　入力情報
	 * @param model
	 * @return　表示画面リダイレクト
	 */
	@PostMapping(value="/update/password",params="save")
	public String updatePassword(@AuthenticationPrincipal UserDetailsImpl user,PasswordUpdateForm passwordUpdateForm,Model model) {
		accountService. updatePassword(user,passwordUpdateForm);
		return "redirect:/mountain";
	}
	
	/**
	 * ユーザー削除
	 * 
	 * @param user　認証情報
	 * @return　表示画面リダイレクト
	 */
	@PostMapping(value="/user-delete",params="delete")
	public String deleteUser(@AuthenticationPrincipal UserDetailsImpl user) {
		accountService.deleteUser(user);
		return "redirect:/mountain";
	}
}
