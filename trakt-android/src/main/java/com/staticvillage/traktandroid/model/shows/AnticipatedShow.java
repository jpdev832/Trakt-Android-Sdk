package com.staticvillage.traktandroid.model.shows;

import com.google.gson.annotations.SerializedName;
import com.staticvillage.traktandroid.model.common.Show;

/**
 * Created by joelparrish on 10/30/16.
 */

public class AnticipatedShow {
    @SerializedName("list_count")
    private long listCount;
    private Show show;

    public long getListCount() {
        return listCount;
    }

    public void setListCount(long listCount) {
        this.listCount = listCount;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
