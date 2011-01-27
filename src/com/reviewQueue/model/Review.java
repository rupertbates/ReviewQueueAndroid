package com.reviewQueue.model;

import java.util.Date;

public class Review extends Entity
    {
        protected Review()
        {
        }
        public Review(ReviewTypes type)
        {
            ReviewType = type;
        }
        //public int Id { get; protected set; }
        
        public String Title;
        public String StandFirst;
        public String TrailText;
        public String Body;
        public Date PublicationDate;
        public ReviewTypes ReviewType;
        public int StarRating;
        public String WebUrl;
        public String Thumbnail;
    }
