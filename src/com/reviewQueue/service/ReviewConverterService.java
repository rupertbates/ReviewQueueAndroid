package com.reviewQueue.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.reviewQueue.model.Review;
import com.reviewQueue.service.interfaces.IReviewConverterService;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class ReviewConverterService implements IReviewConverterService{
    protected static Gson _gson;
    static
    {
        GsonBuilder b = new GsonBuilder();
        b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        _gson = b.create();
    }
    public List<Review> convertReviews(String json)
    {
        Type collectionType = new TypeToken<Collection<Review>>(){}.getType();
        return _gson.fromJson(json, collectionType);
    }
}
