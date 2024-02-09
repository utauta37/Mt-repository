package com.example.mountain.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mountain.authentication.UserDetailsImpl;
import com.example.mountain.entity.Mountain;
import com.example.mountain.entity.Review;
import com.example.mountain.form.ReviewCreateForm;
import com.example.mountain.service.MountainService;
import com.example.mountain.service.ReviewService;

import lombok.RequiredArgsConstructor;

/**
 * 山の検索機能controller
 * 
 * @author mina
 */


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MountainController {
	
	/** MountainService */
	private final MountainService mountainService;
	
	/** ReviewService */
	private final ReviewService reviewService;

	/**
	 * top画面表示
	 * 
	 * @return　表示画面
	 */
	@GetMapping("/")
	public String top() {
		return "mountains/top";
	}
	
	/**
	 * 検索画面表示
	 * 
	 * @return　表示画面
	 */
	@GetMapping("/search")
	public String search() {
		return "mountains/search";
	}
	
	/**
	 * 運任せボタン（詳細画面を表示）
	 * 
	 * @param model
	 * @return 表示画面
	 */
	@GetMapping("/result-random")
	public String randomShow(Model model) {
		Mountain mountain = mountainService.showOne();
		model.addAttribute("mountain",mountain);
		return "mountains/show";
	}
	
	
	/**
	 * 検索画面（すべての山）
	 * 
	 * @param model
	 * @return　検索結果一覧画面
	 */
	@GetMapping("/result-all")
	public String select(Model model) {
		List<Mountain> mountainList = mountainService.showAll();
		model.addAttribute("mountainList",mountainList);
		return "mountains/result";
	}
	
	/**
	 * 検索画面（場所）
	 * 
	 * @param prefecture
	 * @param model
	 * @return　検索結果一覧画面
	 */
	@GetMapping("/result-prefecture")
	public String selectPref(@RequestParam("prefecture") String prefecture,Model model) {
		List<Mountain> mountainList = mountainService.selectPref(prefecture);
		model.addAttribute("mountainList",mountainList);
		return "mountains/result";
	}
	
	/**
	 * 検索画面（コースタイム）
	 * 
	 * @param time
	 * @param model
	 * @return　検索結果一覧画面
	 */
	@GetMapping("/result-coursetime")
	public String selectTime(@RequestParam("time") String time,Model model) {
		List<Mountain> mountainList = mountainService.selectTime(time);
		model.addAttribute("mountainList",mountainList);
		return "mountains/result";
	}
	
	/**
	 * 検索画面（気分）
	 * 
	 * @param feeling
	 * @param model
	 * @return　検索結果一覧画面
	 */
	@GetMapping("/result-feeling")
	public String selectFeel(@RequestParam("feeling") String feeling,Model model) {
		List<Mountain> mountainList = mountainService.selectFeel(feeling);
		model.addAttribute("mountainList",mountainList);
		return "mountains/result";
	}
	
	/**
	 * 山の詳細画面
	 * 
	 * @param id　山のID
	 * @param model
	 * @return　表示画面
	 */
	@GetMapping("/show{id}")
	public String showView(@PathVariable("id") int mountainId,Model model) {
		Mountain mountain = mountainService.findById(mountainId);
		List<Review> reviewList = reviewService.selectReview(mountainId);
		model.addAttribute("mountain",mountain);
		model.addAttribute("reviewList",reviewList);
		return "mountains/show";
	}
	
	/**
	 * レビュー作成画面
	 * 
	 * @param user　認証情報
	 * @param reviewCreateForm　入力情報
	 * @param id　山のid
	 * @param model
	 * @return　表示画面
	 */
	@GetMapping("/review-create{id}")
	public String createReviewView(@AuthenticationPrincipal UserDetailsImpl user,ReviewCreateForm reviewCreateForm,@PathVariable("id")int mountainId,Model model) {
		Mountain mountain = mountainService.findById(mountainId);
		model.addAttribute("id",mountain.getId());
		return "mountains/create";
	}
	
	/**
	 * レビュー作成実行
	 * 
	 * @param user 認証情報
	 * @param mountainId 山のID
	 * @param reviewCreateForm 入力情報
	 * @param result バインド結果
	 * @return 入力画面または山詳細画面リダイレクト
	 */
	@PostMapping("/review-create{id}")
	public String createReview(@Validated ReviewCreateForm reviewCreateForm,BindingResult result,@AuthenticationPrincipal UserDetailsImpl user,@PathVariable("id")int mountainId,Model model) {
		if(result.hasErrors()) {
			return "mountains/create";
		}
		reviewService.createReview(user,mountainId,reviewCreateForm);
		return "redirect:/show{id}";
	}

}
