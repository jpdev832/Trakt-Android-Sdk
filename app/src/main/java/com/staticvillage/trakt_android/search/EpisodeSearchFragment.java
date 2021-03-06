package com.staticvillage.trakt_android.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.staticvillage.trakt_android.App;
import com.staticvillage.trakt_android.common.ExtendedResultFragment;

import rx.Observable;

/**
 * Created by joelparrish on 11/6/16.
 */

public class EpisodeSearchFragment extends ExtendedResultFragment {
    public static EpisodeSearchFragment newInstance() {
        return new EpisodeSearchFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        searchContainer.setVisibility(View.VISIBLE);
        return view;
    }

    @Override
    public Observable<String> getResult() {
        String query = searchText.getText().toString();
        boolean extended = extendedCheckBox.isChecked();
        return App.getTraktService()
                .searchEpisodes(query, extended, null)
                .map(response -> gson.toJson(response));
    }
}
