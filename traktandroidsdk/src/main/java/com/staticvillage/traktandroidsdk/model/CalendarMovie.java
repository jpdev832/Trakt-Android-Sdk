package com.staticvillage.traktandroidsdk.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joelparrish on 10/30/16.
 */

public class CalendarMovie {
    @SerializedName("first_aired")
    private String released;
    private Movie movie;

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
