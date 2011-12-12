package com.eliasBland;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by IntelliJ IDEA.
 * User: rupert
 * Date: 11/12/11
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
public class ReviewListFragment extends ListFragment implements LoaderManager.LoaderCallbacks {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public Loader onCreateLoader(int id, Bundle args) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void onLoadFinished(Loader loader, Object data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void onLoaderReset(Loader loader) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
