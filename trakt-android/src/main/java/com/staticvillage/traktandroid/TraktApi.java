package com.staticvillage.traktandroid;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.staticvillage.traktandroid.model.auth.AccessToken;
import com.staticvillage.traktandroid.model.common.Alias;
import com.staticvillage.traktandroid.model.movies.AnticipatedMovie;
import com.staticvillage.traktandroid.model.shows.AnticipatedShow;
import com.staticvillage.traktandroid.model.calendars.CalendarMovie;
import com.staticvillage.traktandroid.model.calendars.CalendarShow;
import com.staticvillage.traktandroid.model.sync.CollectionShow;
import com.staticvillage.traktandroid.model.search.EpisodeQueryResult;
import com.staticvillage.traktandroid.model.sync.LastActivity;
import com.staticvillage.traktandroid.model.movies.CollectedMovie;
import com.staticvillage.traktandroid.model.movies.PlayedMovie;
import com.staticvillage.traktandroid.model.search.MovieQueryResult;
import com.staticvillage.traktandroid.model.movies.MovieUpdate;
import com.staticvillage.traktandroid.model.common.Rating;
import com.staticvillage.traktandroid.model.shows.PlayedShow;
import com.staticvillage.traktandroid.model.search.ShowQueryResult;
import com.staticvillage.traktandroid.model.shows.ShowUpdate;
import com.staticvillage.traktandroid.model.common.StandardSeason;
import com.staticvillage.traktandroid.model.common.Translation;
import com.staticvillage.traktandroid.model.movies.Release;
import com.staticvillage.traktandroid.model.movies.TrendingMovie;
import com.staticvillage.traktandroid.model.shows.TrendingShow;
import com.staticvillage.traktandroid.model.common.Episode;
import com.staticvillage.traktandroid.model.common.Genre;
import com.staticvillage.traktandroid.model.common.Movie;
import com.staticvillage.traktandroid.model.common.Person;
import com.staticvillage.traktandroid.model.common.Season;
import com.staticvillage.traktandroid.model.common.Show;
import com.staticvillage.traktandroid.model.movies.WatchedMovie;
import com.staticvillage.traktandroid.model.people.MovieCrew;
import com.staticvillage.traktandroid.model.people.ShowCrew;
import com.staticvillage.traktandroid.model.shows.WatchedShow;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by joelparrish on 10/15/16.
 */

public interface TraktApi {
    //<editor-fold desc="Authorization">
    @POST("oauth/token")
    Observable<AccessToken> getToken(@Body RequestBody body);

    @POST("oauth/revoke")
    Observable<JsonObject> revokeToken(@Body RequestBody body);
    //</editor-fold>

    //<editor-fold desc="Calendar">
    @GET("calendars/my/shows/{start_date}/{days}")
    Observable<List<CalendarShow>> getMyShows(@Path("start_date") String startDate,
                                              @Path("days") int days,
                                              @QueryMap Map<String, String> params);

    @GET("calendars/my/shows/new/{start_date}/{days}")
    Observable<List<CalendarShow>> getMyNewShows(@Path("start_date") String startDate,
                                                 @Path("days") int days,
                                                 @QueryMap Map<String, String> params);

    @GET("calendars/my/shows/premieres/{start_date}/{days}")
    Observable<List<CalendarShow>> getMySeasonPremieres(@Path("start_date") String startDate,
                                                        @Path("days") int days,
                                                        @QueryMap Map<String, String> params);

    @GET("calendars/my/movies/{start_date}/{days}")
    Observable<List<CalendarMovie>> getMyMovies(@Path("start_date") String startDate,
                                                @Path("days") int days,
                                                @QueryMap Map<String, String> params);

    @GET("calendars/all/shows/{start_date}/{days}")
    Observable<List<CalendarShow>> getShows(@Path("start_date") String startDate,
                                            @Path("days") int days,
                                            @QueryMap Map<String, String> params);

    @GET("calendars/all/shows/new/{start_date}/{days}")
    Observable<List<CalendarShow>> getNewShows(@Path("start_date") String startDate,
                                               @Path("days") int days,
                                               @QueryMap Map<String, String> params);

    @GET("calendars/all/shows/premieres/{start_date}/{days}")
    Observable<List<CalendarShow>> getSeasonPremieres(@Path("start_date") String startDate,
                                                      @Path("days") int days,
                                                      @QueryMap Map<String, String> params);

    @GET("calendars/all/movies/{start_date}/{days}")
    Observable<List<CalendarMovie>> getMovies(@Path("start_date") String startDate,
                                              @Path("days") int days,
                                              @QueryMap Map<String, String> params);
    //</editor-fold>

    //<editor-fold desc="Genre">
    @GET("genres/{type}")
    Observable<List<Genre>> getGenres(@Path("type") String type);
    //</editor-fold>

    //<editor-fold desc="Movies">
    @GET("movies/trending")
    Observable<List<TrendingMovie>> getTrendingMovies(@QueryMap Map<String, String> params);

    @GET("movies/popular")
    Observable<List<Movie>> getPopularMovies(@QueryMap Map<String, String> params);

    @GET("movies/played/{period}")
    Observable<List<PlayedMovie>> getPlayedMovies(@QueryMap Map<String, String> params);

    @GET("movies/watched/{period}")
    Observable<List<WatchedMovie>> getWatchedMovies(@QueryMap Map<String, String> params);

    @GET("movies/collected/{period}")
    Observable<List<CollectedMovie>> getCollectedMovies(@QueryMap Map<String, String> params);

    @GET("movies/anticipated")
    Observable<List<AnticipatedMovie>> getAnticipatedMovies(@QueryMap Map<String, String> params);

    @GET("movies/updates")
    Observable<List<MovieUpdate>> getMovieUpdates(@QueryMap Map<String, String> params);

    @GET("movies/{id}")
    Observable<Movie> getMovieSummary(@Path("id") String id, @QueryMap Map<String, String> params);

    @GET("movies/{id}/aliases")
    Observable<List<Alias>> getMovieAliases(@Path("id") String id);

    @GET("movies/{id}/releases/{country}")
    Observable<List<Release>> getMovieReleases(@Path("id") String id, @Path("country") String country);

    @GET("movies/{id}/translations/{language}")
    Observable<List<Translation>> getMovieTranslations(@Path("id") String id, @Path("language") String language);

    @GET("movies/{id}/ratings")
    Observable<Rating> getMovieRatings(@Path("id") String id);

    @GET("movies/{id}/related")
    Observable<List<Movie>> getRelatedMovies(@Path("id") String id, @QueryMap Map<String, String> params);
    //</editor-fold>

    //<editor-fold desc="People">
    @GET("people/{id}")
    Observable<Person> getPerson(@Path("id") String id, @QueryMap Map<String, String> params);

    @GET("people/{id}/movies")
    Observable<MovieCrew> getMovieCredits(@Path("id") String id, @QueryMap Map<String, String> params);

    @GET("people/{id}/shows")
    Observable<ShowCrew> getShowCredits(@Path("id") String id, @QueryMap Map<String, String> params);
    //</editor-fold>

    //<editor-fold desc="Recommendations">
    @GET("recommendations/movies")
    Observable<List<Movie>> getMovieRecommendations(@QueryMap Map<String, String> params);

    @DELETE("recommendations/movies/{id}")
    Observable<List<Movie>> hideMovieRecommendation(@Path("id") String id);

    @GET("recommendations/shows")
    Observable<List<Show>> getShowRecommendations(@QueryMap Map<String, String> params);

    @DELETE("recommendations/shows/{id}")
    Observable<List<Show>> hideShowRecommendation(@Path("id") String id);
    //</editor-fold>

    //<editor-fold desc="Search">
    @GET("search/movie")
    Observable<List<MovieQueryResult>> searchMovies(@QueryMap Map<String, String> params);

    @GET("search/show")
    Observable<List<ShowQueryResult>> searchShows(@QueryMap Map<String, String> params);

    @GET("search/episode")
    Observable<List<EpisodeQueryResult>> searchEpisodes(@QueryMap Map<String, String> params);
    //</editor-fold>

    //<editor-fold desc="Shows">
    @GET("shows/trending")
    Observable<List<TrendingShow>> getTrendingShows(@QueryMap Map<String, String> params);

    @GET("shows/popular")
    Observable<List<Show>> getPopularShows(@QueryMap Map<String, String> params);

    @GET("shows/played/{period}")
    Observable<List<PlayedShow>> getPlayedShows(@QueryMap Map<String, String> params);

    @GET("shows/watched/{period}")
    Observable<List<WatchedShow>> getWatchedShows(@QueryMap Map<String, String> params);

    @GET("shows/collected/{period}")
    Observable<List<CollectionShow>> getCollectedShows(@QueryMap Map<String, String> params);

    @GET("shows/anticipated")
    Observable<List<AnticipatedShow>> getAnticipatedShows(@QueryMap Map<String, String> params);

    @GET("shows/updates")
    Observable<List<ShowUpdate>> getShowUpdates(@QueryMap Map<String, String> params);

    @GET("shows/{id}")
    Observable<Show> getShowSummary(@Path("id") String id,
                                    @QueryMap Map<String, String> params);

    @GET("shows/{id}/aliases")
    Observable<List<Alias>> getShowAliases(@Path("id") String id);

    @GET("shows/{id}/translations/{language}")
    Observable<List<Translation>> getShowTranslations(@Path("id") String id,
                                                      @Path("language") String language);

    @GET("shows/{id}/ratings")
    Observable<Rating> getShowRatings(@Path("id") String id);

    @GET("shows/{id}/related")
    Observable<List<Show>> getRelatedShows(@Path("id") String id,
                                           @QueryMap Map<String, String> params);

    @GET("shows/{id}/next_episode")
    Observable<Episode> getNextEpisode(@Path("id") String id,
                                       @QueryMap Map<String, String> params);

    @GET("shows/{id}/last_episode")
    Observable<Episode> getLastEpisode(@Path("id") String id,
                                       @QueryMap Map<String, String> params);
    //</editor-fold>

    //<editor-fold desc="Season">
    @GET("shows/{id}/seasons")
    Observable<List<StandardSeason>> getAllSeasons(@Path("id") String id,
                                                   @QueryMap Map<String, String> params);

    @GET("shows/{id}/seasons/{season}")
    Observable<List<Season>> getSeasonSummary(@Path("id") String id,
                                              @Path("season") int season,
                                              @QueryMap Map<String, String> params);

    @GET("shows/{id}/seasons/{season}/ratings")
    Observable<Rating> getSeasonRatings(@Path("id") String id,
                                        @Path("season") int season,
                                        @QueryMap Map<String, String> params);
    //</editor-fold>

    //<editor-fold desc="Episodes">
    @GET("shows/{id}/seasons/{season}/episodes/{episode}")
    Observable<Episode> getEpisode(@Path("id") String id,
                                   @Path("season") int season,
                                   @Path("episode") int episode,
                                   @QueryMap Map<String, String> params);

    @GET("shows/{id}/seasons/{season}/episodes/{episode}/ratings")
    Observable<Rating> getEpisodeRating(@Path("id") String id,
                                        @Path("season") int season,
                                        @Path("episode") int episode);
    //</editor-fold>

    //<editor-fold desc="Sync">
    @GET("sync/last_activities")
    Observable<LastActivity> getLastActivities();

    @GET("sync/collection/shows")
    Observable<List<CollectionShow>> getShowCollection(@QueryMap Map<String, String> params);

    @GET("sync/collection/movies")
    Observable<List<CollectionShow>> getMovieCollection(@QueryMap Map<String, String> params);

    @POST("sync/collection")
    Observable<JsonElement> addToCollection(@Body RequestBody body);

    @POST("sync/collection/remove")
    Observable<JsonElement> removeFromCollection(@Body RequestBody body);
    //</editor-fold>
}
