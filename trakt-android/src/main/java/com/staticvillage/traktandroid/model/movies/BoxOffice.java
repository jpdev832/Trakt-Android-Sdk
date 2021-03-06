package com.staticvillage.traktandroid.model.movies;

import com.google.gson.annotations.SerializedName;
import com.staticvillage.traktandroid.model.common.Movie;

/**
 * Created by joelparrish on 10/30/16.
 */

public class BoxOffice {
    @SerializedName("revenue")
    private long revenue;
    private Movie movie;

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
