package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.data.Review;
import com.spring.web.data.ReviewDao;

@Service("reviewservice")
public class ReviewService {
	
	
	private ReviewDao reviewDao;
	

	@Autowired
	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	public void create(Review review) {
		reviewDao.create(review);
	}



	public List<Review> getCurrent(){
		return reviewDao.getReviews();
	}
}
