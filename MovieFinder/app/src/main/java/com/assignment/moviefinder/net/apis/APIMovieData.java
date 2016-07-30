package com.assignment.moviefinder.net.apis;


import com.assignment.moviefinder.db.bean.MovieBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class APIMovieData extends _AbstractAPIHelper<_APIMovieFinder> {

    public APIMovieData() {
        super(_APIMovieFinder.class);
    }

    public void getMovieInfo(String movie) {

        Call<MovieBean> call;

        call = mService.getMovieData(movie);

        call.enqueue(new Callback<MovieBean>() {
            @Override
            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                if (response.body().getResponse().equalsIgnoreCase("true")) {
                    onGetMovieFinderAPISuccess(response.body());

                } else {
                    onGetMovieFinderAPIError();
                }
            }

            @Override
            public void onFailure(Call<MovieBean> call, Throwable t) {
                onGetMovieFinderAPIFailure(t);
            }

        });
    }

    protected void onGetMovieFinderAPIError(){
        throw new UnsupportedOperationException("stub!!");
    };

    protected void onGetMovieFinderAPISuccess(MovieBean movieBean) {
        throw new UnsupportedOperationException("stub!!");
    }

    protected void onGetMovieFinderAPIFailure(Throwable t) {
        throw new UnsupportedOperationException("stub!!");
    }

}
