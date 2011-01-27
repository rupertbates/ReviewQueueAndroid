import com.google.gson.Gson;
import com.reviewQueue.model.ReviewTypes;
import org.junit.Assert;
import org.junit.Test;

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
    public void can_deserialize_some_real_json(){
        Gson gson = new Gson();

        String json = gson.toJson(ReviewTypes.Books);
        ReviewTypes reviewType = gson.fromJson(json, ReviewTypes.class);
        Assert.assertTrue(ReviewTypes.Books.DisplayName.equals(reviewType.DisplayName));
        Assert.assertTrue(ReviewTypes.Books.Id == reviewType.Id);
        Assert.assertTrue(ReviewTypes.Books.Name.equals(reviewType.Name));
    }
}
