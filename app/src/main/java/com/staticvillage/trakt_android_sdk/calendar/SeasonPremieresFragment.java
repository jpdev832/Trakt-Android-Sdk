package com.staticvillage.trakt_android_sdk.calendar;

import com.staticvillage.trakt_android_sdk.App;
import com.staticvillage.trakt_android_sdk.common.ExtendedCalendarResultFragment;

import java.util.Date;

import rx.Observable;

/**
 * Created by joelparrish on 11/6/16.
 */

public class SeasonPremieresFragment extends ExtendedCalendarResultFragment {
    public static SeasonPremieresFragment newInstance() {
        return new SeasonPremieresFragment();
    }

    @Override
    public void setUrl() {
        endpointUrl.setText("calendars/all/shows/premieres/{start_date}/{days}");
    }

    @Override
    public Observable<String> getResult() {
        Date startDate = getStartDate();
        int days = getDays();
        boolean extended = extendedCheckBox.isChecked();
        return App.getTraktService()
                .getSeasonPremieres(startDate, days, extended, null)
                .map(response -> gson.toJson(response));
    }
}
