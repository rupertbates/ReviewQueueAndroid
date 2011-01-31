import com.reviewQueue.model.Review;
import com.reviewQueue.model.ReviewTypes;
import com.reviewQueue.service.ReviewConverterService;
import com.reviewQueue.service.ReviewFetcherService;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestHttpClient {

    @Test
    public void can_get_results_from_live_webserver() throws IOException
    {
        ReviewFetcherService svc = new ReviewFetcherService(new ReviewConverterService());
        String content = svc.getReviewJson(ReviewTypes.Music);
        Assert.assertTrue(!content.equals(""));
        List<Review> reviews = svc.getReviews(ReviewTypes.Film);
        Assert.assertTrue(reviews.size() > 0);

    }
}
