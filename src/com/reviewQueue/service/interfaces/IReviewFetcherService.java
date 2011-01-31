package com.reviewQueue.service.interfaces;

import com.reviewQueue.model.Review;
import com.reviewQueue.model.ReviewTypes;

import java.io.IOException;
import java.util.List;

public interface IReviewFetcherService {
    public List<Review> getReviews(ReviewTypes reviewType) throws IOException;
}
