package com.example.Careerly.review;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public ResponseEntity<List<Review>> getAllReview(){
        List<Review> reviews=reviewService.AllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Review> getById(@PathVariable Long id){
        Review rev=reviewService.getReviewById(id);
        if(rev!=null)
            return new ResponseEntity<>(rev,HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createreview(@RequestBody Review review){
        reviewService.createReview(review);
        return new ResponseEntity<>("Review Added!!",HttpStatus.CREATED);
    }

    @PutMapping("/id")
    public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review rev){
        boolean bool= reviewService.updateReview(id,rev);
        if(bool)
            return new ResponseEntity<>("Updated successfully!!",HttpStatus.OK);
        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id){
        boolean bool=reviewService.deleteReview(id);
        if(bool)
            return new ResponseEntity<>("Deleted Successfully!!",HttpStatus.OK);
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
