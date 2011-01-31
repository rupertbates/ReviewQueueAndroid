package com.reviewQueue.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.inject.Inject;
import com.reviewQueue.R;
import com.reviewQueue.adapters.ReviewAdapter;
import com.reviewQueue.model.Review;
import com.reviewQueue.model.ReviewTypes;
import com.reviewQueue.service.interfaces.IReviewFetcherService;
import roboguice.activity.RoboActivity;
import roboguice.activity.RoboListActivity;

import java.io.IOException;
import java.util.List;

public class HomeActivity extends RoboListActivity
{
    @Inject IReviewFetcherService _reviewFetcher;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try
        {
            List<Review> reviews = _reviewFetcher.getReviews(ReviewTypes.Unknown);
            setListAdapter(new ReviewAdapter(this, reviews));
            //setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, COUNTRIES));

            ListView lv = getListView();
              lv.setTextFilterEnabled(true);

              lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                  // When clicked, show a toast with the TextView text
                  Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                          Toast.LENGTH_SHORT).show();
                }
              });
        }
        catch (IOException ex)
        {
            //log it or something;
        }

    }
    static final String[] COUNTRIES = new String[] {"England", "Scotland", "Northern Ireland", "Wales"};
}
