
package com.reviewQueue.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User extends Entity
{
    public User()
    {
        
        ExcludedReviewTypes = new ArrayList<ReviewTypes>();
        SavedReviews = new HashSet<SavedReview>();
    }
    public  String ClaimedIdentifier;
    public  String FriendlyIdentifier;
    public  String FullName;
    public  String Email;
    public  String PostalCode;
    public  String OpenIdProvider;
    public  String OpenIdProviderVersion;
    public  HashSet<SavedReview> SavedReviews;
    public List<ReviewTypes> ExcludedReviewTypes;
    public  Boolean IsSubscribedTo(ReviewTypes reviewType)
    {
        if (reviewType == ReviewTypes.Unknown)
            return false;
        for(ReviewTypes r : ExcludedReviewTypes)
        {
            if(r.Id == reviewType.Id) return true;
        }
        return false;
    }
    public  void SaveReviewToList(Review review)
    {
        SavedReview savedReview = new SavedReview();
        savedReview.Review = review;
        savedReview.DateAdded = new Date();

        SavedReviews.add(savedReview);
    }
    public  void RemoveReviewFromList(SavedReview review)
    {
        //Check.Ensure(SavedReviews.Contains(review), "Tried to remove a rev");
        SavedReviews.remove(review);
    }
    public  void UnsubscribeFrom(ReviewTypes reviewType)
    {
        ExcludedReviewTypes.add(reviewType);
    }
    
}

