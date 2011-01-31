package com.reviewQueue;

import com.google.inject.Module;
import roboguice.application.RoboApplication;

import java.util.List;

public class ReviewQueueApplication extends RoboApplication{
    protected void addApplicationModules(List<Module> modules){
        modules.add(new ReviewQueueModule());

    }
}
