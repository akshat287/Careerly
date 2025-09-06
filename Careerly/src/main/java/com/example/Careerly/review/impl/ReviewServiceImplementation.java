package com.example.Careerly.review.impl;

import com.example.Careerly.review.Review;
import com.example.Careerly.review.ReviewController;
import com.example.Careerly.review.ReviewRepo;
import com.example.Careerly.review.ReviewService;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImplementation implements ReviewService {

    ReviewRepo reviewRepo;

    public ReviewServiceImplementation(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<Review> reviewsByCompanyId(Long id) {
        return List.of();
    }

    @Override
    public void createReview(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public List<Review> AllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteReview(Long id) {
        try{
            reviewRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateReview(Long id, Review review) {
        Optional<Review> opt=reviewRepo.findById(id);
        if(opt.isPresent()){
            Review rev=opt.get();
            rev.setCompany(review.getCompany());
            rev.setRating(review.getRating());
            rev.setReview(review.getReview());
            reviewRepo.save(rev);
            return true;
        }
        return false;
    }
}
