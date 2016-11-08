package com.staticvillage.trakt_android_sdk.calendar;

import com.staticvillage.trakt_android_sdk.App;
import com.staticvillage.trakt_android_sdk.common.ExtendedResultFragment;

import java.util.Calendar;

import rx.Observable;

/**
 * Created by joelparrish on 11/6/16.
 */

public class MySeasonPremieresFragment extends ExtendedResultFragment {
    public static MySeasonPremieresFragment newInstance() {
        return new MySeasonPremieresFragment();
    }

    @Override
    public Observable<String> getResult() {
        boolean extended = extendedCheckBox.isChecked();
        return App.getTraktService()
                .getMySeasonPremieres(Calendar.getInstance().getTime(), 7, extended, null)
                .map(response -> gson.toJson(response));
    }
}
