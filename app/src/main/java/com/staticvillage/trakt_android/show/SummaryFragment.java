package com.staticvillage.trakt_android.show;

import com.staticvillage.trakt_android.App;
import com.staticvillage.trakt_android.common.ExtendedResultFragment;

import rx.Observable;

/**
 * Created by joelparrish on 11/6/16.
 */

public class SummaryFragment extends ExtendedResultFragment {
    public static SummaryFragment newInstance() {
        return new SummaryFragment();
    }

    @Override
    public Observable<String> getResult() {
        boolean extended = extendedCheckBox.isChecked();
        return App.getTraktService()
                .getShowDetails("99718", extended)
                .map(response -> gson.toJson(response));
    }
}
