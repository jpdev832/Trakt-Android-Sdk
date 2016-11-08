package com.staticvillage.trakt_android_sdk.genre;

import com.staticvillage.trakt_android_sdk.App;
import com.staticvillage.trakt_android_sdk.common.ExtendedResultFragment;

import rx.Observable;

/**
 * Created by joelparrish on 11/6/16.
 */

public class ShowGenreFragment extends ExtendedResultFragment {
    public static ShowGenreFragment newInstance() {
        return new ShowGenreFragment();
    }

    @Override
    public Observable<String> getResult() {
        boolean extended = extendedCheckBox.isChecked();
        return App.getTraktService()
                .getShowGenres()
                .map(response -> gson.toJson(response));
    }
}
