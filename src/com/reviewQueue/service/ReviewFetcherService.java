package com.reviewQueue.service;
import com.reviewQueue.model.Review;
import com.reviewQueue.model.ReviewTypes;
import com.reviewQueue.service.interfaces.IReviewConverterService;
import com.reviewQueue.service.interfaces.IReviewFetcherService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.List;
import com.google.inject.Inject;

public class ReviewFetcherService implements IReviewFetcherService{
    IReviewConverterService _converter;
    @Inject
    public ReviewFetcherService(IReviewConverterService converter)
    {
        _converter = converter;
    }
    public List<Review> getReviews(ReviewTypes reviewType) throws IOException
    {
        return _converter.convertReviews(getReviewJson(reviewType));
    }
    public String getReviewJson(ReviewTypes reviewType) throws IOException
    {
        String url = String.format("http://reviewqueue.stage.guardianprofessional.co.uk/review/%s/json", reviewType.Name);
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);

        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        String content = "";
        if (entity != null) {
            content = EntityUtils.toString(entity);
        }
        return content;
    }


}
