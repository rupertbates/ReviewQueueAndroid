package com.reviewQueue.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.reviewQueue.model.Review;

import java.util.List;

public class ReviewAdapter extends BaseAdapter {
    private Context mContext;
    List<Review> _reviews;
    public ReviewAdapter(Context c, List<Review> reviews) {
        _reviews = reviews;
        mContext = c;
    }

    public int getCount() {
        return _reviews.size();
    }

    public Object getItem(int position) {
        return _reviews.get(position);
    }

    public long getItemId(int position) {
        return _reviews.get(position).Id;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View reviewView, ViewGroup parent) {
        TextView txtView;
        if (reviewView == null) {  // if it's not recycled, initialize some attributes
            txtView = new TextView(mContext);
            txtView.setLayoutParams(new GridView.LayoutParams(85, 85));
            //txtView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            txtView.setPadding(8, 8, 8, 8);
        } else {
            txtView = (TextView) reviewView;
        }
        txtView.setText(_reviews.get(position).Title);
        //txtView.setImageResource(mThumbIds[position]);
        return txtView;
    }


}
