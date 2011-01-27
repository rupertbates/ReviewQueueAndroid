package com.reviewQueue.model;

import java.util.List;

public class MusicReview extends Review
    {
        protected MusicReview()
        {
            ReviewType = ReviewTypes.Music;
        }
        public MusicReview(List<MusicTypes> types)
        {
            ReviewType = ReviewTypes.Music;
            MusicTypes = types;
        }
        public List<MusicTypes> MusicTypes;
    }

