package com.staticvillage.traktandroidsdk.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joelparrish on 10/31/16.
 */

public class StandardSeason {
    @SerializedName("number")
    private Integer number;
    @SerializedName("ids")
    private Identifier ids;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Identifier getIds() {
        return ids;
    }

    public void setIds(Identifier ids) {
        this.ids = ids;
    }
}
