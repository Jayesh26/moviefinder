package com.assignment.moviefinder.net.apis;


import com.assignment.moviefinder.db.bean.MovieBean;
import com.assignment.moviefinder.net.APIConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author jayesh
 * @Since 27/7/16.
 */

interface _APIMovieFinder {
    @GET("/")
    Call<MovieBean> getMovieData(@Query(APIConstants.QUERY_MOVIE_NAME) String movieName);
}
