package com.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.data.Review;
import com.spring.web.service.ReviewService;

@Controller
public class HomeController {
	
	private ReviewService reviewsService;
	
	@Autowired
	public void setReviewsService(ReviewService reviewsService) {
		this.reviewsService = reviewsService;
	}

	@RequestMapping("/")
	public String showHome(Model model){
		
		List<Review> reviews = reviewsService.getCurrent();
		model.addAttribute("reviews", reviews);
		
		return "home";
	}
	@RequestMapping("/logout")
	public String showloggedout(){
		return "logout";
	}
	@RequestMapping("/review")
	public String showreview(){
		return "review";
	}

}
