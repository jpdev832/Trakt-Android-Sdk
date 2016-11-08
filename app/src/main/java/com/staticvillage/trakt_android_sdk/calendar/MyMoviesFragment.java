package com.staticvillage.trakt_android_sdk.calendar;

import com.staticvillage.trakt_android_sdk.App;
import com.staticvillage.trakt_android_sdk.common.ExtendedResultFragment;

import java.util.Calendar;

import rx.Observable;

/**
 * Created by joelparrish on 11/6/16.
 */

public class MyMoviesFragment extends ExtendedResultFragment {
    public static MyMoviesFragment newInstance() {
        return new MyMoviesFragment();
    }

    @Override
    public Observable<String> getResult() {
        boolean extended = extendedCheckBox.isChecked();
        return App.getTraktService()
                .getMyMovies(Calendar.getInstance().getTime(), 7, extended, null)
                .map(response -> gson.toJson(response));
    }
}