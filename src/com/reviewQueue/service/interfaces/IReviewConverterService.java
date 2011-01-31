package com.reviewQueue.service.interfaces;

import com.reviewQueue.model.Review;

import java.util.List;

public interface IReviewConverterService{
    public List<Review> convertReviews(String json);
}
