package com.reviewQueue.activities;

import android.app.Activity;
import android.os.Bundle;
import com.google.inject.Inject;
import com.reviewQueue.R;
import com.reviewQueue.service.interfaces.IReviewFetcherService;
import roboguice.activity.RoboActivity;

public class HomeActivity extends RoboActivity
{
    @Inject IReviewFetcherService _reviewFetcher;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
