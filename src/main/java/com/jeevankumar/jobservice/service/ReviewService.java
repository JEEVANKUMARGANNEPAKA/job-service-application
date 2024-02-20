package com.jeevankumar.jobservice.service;

import com.jeevankumar.jobservice.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean createReview(Long companyId,Review review);

}
