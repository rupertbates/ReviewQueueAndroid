package com.reviewQueue.model;

import java.util.ArrayList;
import java.util.List;

public class MusicTypes extends Enumeration
    {

        public static final MusicTypes
            Classical = new MusicTypes(1, "classical", "Classical music and opera"),
            Electronic = new MusicTypes(2, "electronic", "Electronic music"),
            Jazz = new MusicTypes(3, "Jazz"),
            Folk = new MusicTypes(4, "Folk"),
            Pop = new MusicTypes(5, "popandrock", "Pop and Rock"),
            Urban = new MusicTypes(6, "urban", "Urban music"),
            World = new MusicTypes(7, "world", "World music"),
            Soul = new MusicTypes(8, "Soul"),
            DanceMusic = new MusicTypes(9, "dance", "Dance music"),
            Unknown = new MusicTypes(10, "Unknown", "Unknown", false);
        protected MusicTypes(int id, String name)
        {
            this(id, name, name, true);
        }
        protected MusicTypes(int id, String name, String displayName)
        {
           this(id, name, displayName, true);
        }
        protected MusicTypes(int id, String name, String displayName, Boolean showInUI)
        {
            super(id, name, displayName, showInUI);
        }
        public MusicTypes()
        {
            Reviews = new ArrayList<MusicReview>();
        }

        public List<MusicReview> Reviews;
    }

