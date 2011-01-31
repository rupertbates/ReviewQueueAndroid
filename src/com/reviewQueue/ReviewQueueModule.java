package com.reviewQueue;

import com.reviewQueue.service.ReviewConverterService;
import com.reviewQueue.service.ReviewFetcherService;
import com.reviewQueue.service.interfaces.IReviewConverterService;
import com.reviewQueue.service.interfaces.IReviewFetcherService;
import roboguice.config.AbstractAndroidModule;

public class ReviewQueueModule extends AbstractAndroidModule{

    @Override
    protected void configure() {
        bind(IReviewConverterService.class).to(ReviewConverterService.class);
        bind(IReviewFetcherService.class).to(ReviewFetcherService.class);
    }
}
