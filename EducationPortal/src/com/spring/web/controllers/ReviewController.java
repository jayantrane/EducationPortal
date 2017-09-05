package com.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.data.Review;

import com.spring.web.service.ReviewService;

@Controller 

public class ReviewController {
	@Autowired
	ReviewService reviewService;

	@RequestMapping("/createreview")
	public String createReview(Model model) {
	
		model.addAttribute("review", new Review());
		
		return "createreview";
	}
	
	@RequestMapping(value="/increate", method=RequestMethod.POST)
	public String inCreate(Model model, @Valid Review review, BindingResult result) {
		
		if(result.hasErrors()) {
			
			System.out.println("Form does not validated");
			
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error : errors){
				System.out.println(error.getDefaultMessage());
			}
			return "createreview";
		}
		else{
		
			System.out.println("Form validated");
		reviewService.create(review);
		
		return "reviewadded";
		}
	}
	
	@RequestMapping("/reviews")
	public String showOffers(Model model) {

		List<Review> reviews = reviewService.getCurrent();
		
		model.addAttribute("reviews", reviews);
		
		return "reviews";
	}
}
