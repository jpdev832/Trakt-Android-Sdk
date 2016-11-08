package com.staticvillage.trakt_android_sdk.show;

import com.staticvillage.trakt_android_sdk.App;
import com.staticvillage.trakt_android_sdk.common.ExtendedResultFragment;

import rx.Observable;

/**
 * Created by joelparrish on 11/6/16.
 */

public class NextEpisodeFragment extends ExtendedResultFragment {
    public static NextEpisodeFragment newInstance() {
        return new NextEpisodeFragment();
    }

    @Override
    public Observable<String> getResult() {
        boolean extended = extendedCheckBox.isChecked();
        return App.getTraktService()
                .getNextEpisode("99718", extended)
                .map(response -> gson.toJson(response));
    }
}
