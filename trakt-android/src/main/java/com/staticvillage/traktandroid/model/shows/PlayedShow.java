package com.staticvillage.traktandroid.model.shows;

import com.google.gson.annotations.SerializedName;
import com.staticvillage.traktandroid.model.common.Show;

/**
 * Created by joelparrish on 10/30/16.
 */

public class PlayedShow {
    @SerializedName("watcher_count")
    private long watcherCount;
    @SerializedName("play_count")
    private long playCount;
    @SerializedName("collected_count")
    private long collectedCount;
    @SerializedName("collector_count")
    private long collectorCount;
    private Show show;

    public long getWatcherCount() {
        return watcherCount;
    }

    public void setWatcherCount(long watcherCount) {
        this.watcherCount = watcherCount;
    }

    public long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(long playCount) {
        this.playCount = playCount;
    }

    public long getCollectedCount() {
        return collectedCount;
    }

    public void setCollectedCount(long collectedCount) {
        this.collectedCount = collectedCount;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public long getCollectorCount() {
        return collectorCount;
    }

    public void setCollectorCount(long collectorCount) {
        this.collectorCount = collectorCount;
    }
}
