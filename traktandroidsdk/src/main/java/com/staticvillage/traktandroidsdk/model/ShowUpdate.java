package com.staticvillage.traktandroidsdk.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joelparrish on 10/31/16.
 */

public class ShowUpdate {
    @SerializedName("updated_at")
    private String updatedAt;
    private Show show;

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
