package com.staticvillage.trakt_android_sdk.movie;

import com.staticvillage.trakt_android_sdk.App;
import com.staticvillage.trakt_android_sdk.common.ExtendedResultFragment;

import rx.Observable;

/**
 * Created by joelparrish on 11/6/16.
 */

public class AnticipatedFragment extends ExtendedResultFragment {
    public static AnticipatedFragment newInstance() {
        return new AnticipatedFragment();
    }

    @Override
    public Observable<String> getResult() {
        boolean extended = extendedCheckBox.isChecked();
        return App.getTraktService()
                .getAnticipatedMovies(0, 10, extended, null)
                .map(response -> gson.toJson(response));
    }
}