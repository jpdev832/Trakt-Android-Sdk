package com.staticvillage.traktandroidsdk.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joelparrish on 10/31/16.
 */

public class MovieUpdate {
    @SerializedName("updated_at")
    private String updatedAt;
    private Movie movie;

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
