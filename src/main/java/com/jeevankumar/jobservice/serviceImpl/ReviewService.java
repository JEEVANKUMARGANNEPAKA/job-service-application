package com.jeevankumar.jobservice.serviceImpl;

import com.jeevankumar.jobservice.entity.Company;
import com.jeevankumar.jobservice.entity.Review;
import com.jeevankumar.jobservice.repository.CompanyRepository;
import com.jeevankumar.jobservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService implements com.jeevankumar.jobservice.service.ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;



    @Override
    public List<Review> getAllReviews(Long companyId) {
        return this.reviewRepository.findByCompanyId(companyId);

    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        Optional<Company> company=this.companyRepository.findById(companyId);
        if (company.isPresent()){

        }
        return false;
    }
}
