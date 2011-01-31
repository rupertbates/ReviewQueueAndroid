import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.reviewQueue.model.MusicReview;
import com.reviewQueue.model.MusicTypes;
import com.reviewQueue.model.Review;
import com.reviewQueue.model.ReviewTypes;
import com.reviewQueue.service.ReviewConverterService;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GsonTests {
    @Test
    public void can_serialize_and_deserialize_ReviewTypes(){
        Gson gson = new Gson();

        String json = gson.toJson(ReviewTypes.Books);
        ReviewTypes reviewType = gson.fromJson(json, ReviewTypes.class);
        Assert.assertTrue(ReviewTypes.Books.DisplayName.equals(reviewType.DisplayName));
        Assert.assertTrue(ReviewTypes.Books.Id == reviewType.Id);
        Assert.assertTrue(ReviewTypes.Books.Name.equals(reviewType.Name));
    }
    @Test
    public void can_deserialize_some_reviews(){


        GsonBuilder b = new GsonBuilder();
        b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Gson gson = b.create();
        List<Review> reviews = new ArrayList<Review>();
        Review r = new Review(ReviewTypes.Books);
        r.PublicationDate = new Date();
        r.Title = "test title";
        reviews.add(r);
        MusicReview r2 = new MusicReview(new ArrayList<MusicTypes>());
        r2.PublicationDate = new Date();
        r2.Title = "test music review";
        reviews.add(r2);

        String json = gson.toJson(reviews);
        //Type collectionType = new TypeToken<List<ReviewQueueApplication>>(){}.getType();
        //Collection<ReviewTypes> reviews = gson.fromJson(json, collectionType);


        Assert.assertTrue(reviews.size() > 0);
    }
    @Test
    public void can_deserialize_some_real_json(){
        String file = System.getProperty("user.dir") + "\\Tests\\files\\reviewsfromreviewqueue.js";
        String json = FileHelper.readTextFromFile(file);

        GsonBuilder b = new GsonBuilder();
        b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Gson gson = b.create();

        Type collectionType = new TypeToken<Collection<Review>>(){}.getType();
        Collection<Review> reviews = gson.fromJson(json, collectionType);

        Assert.assertTrue(reviews.size() > 0);

        Collection<Review> reviews2 = new ReviewConverterService().convertReviews(json);
        Assert.assertTrue(reviews.size() == reviews2.size());
    }
}
