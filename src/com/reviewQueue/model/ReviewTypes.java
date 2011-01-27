package com.reviewQueue.model;

import java.util.ArrayList;
import java.util.List;

public class ReviewTypes extends Enumeration
    {
        public static final ReviewTypes 
            Film = new ReviewTypes(1, "Film"),
            Music = new ReviewTypes(2, "Music"),
            Books = new ReviewTypes(3, "Books"),
            Theatre = new ReviewTypes(4, "Theatre"),
            Game = new ReviewTypes(5, "Games"),
            TvAndRadio = new ReviewTypes(6, "TvAndRadio", "Television & Radio"),
            Unknown = new ReviewTypes(7, "Unknown", "Unknown", false);
        
        protected ReviewTypes(int id, String name)
        {
            this(id, name, name, true);
        }
        protected ReviewTypes(int id, String name, String displayName)
        {
            this(id, name, displayName, true);
        }
        protected ReviewTypes(int id, String name, String displayName, Boolean showInUI)
        {
            super(id, name, displayName, showInUI);
        }
        public ReviewTypes()
        {
            Reviews = new ArrayList<Review>();
        }

        public List<Review> Reviews;
    }

