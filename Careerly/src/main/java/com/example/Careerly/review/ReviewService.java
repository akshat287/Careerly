package com.example.Careerly.review;

import java.util.List;

public interface ReviewService {
    List<Review> reviewsByCompanyId(Long id);
    void createReview(Review review);
    List<Review> AllReviews();
    Review getReviewById(Long id);
    boolean deleteReview(Long id);
    boolean updateReview(Long id, Review review );

}
