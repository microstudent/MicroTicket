package com.microstudent.app.microticket.model.impl;

import com.microstudent.app.microticket.config.ContextApplication;
import com.microstudent.app.microticket.model.OnLoadingCompleteListener;
import com.microstudent.app.microticket.model.entity.Movie;
import com.microstudent.app.microticket.util.NetworkUtils;

import java.util.List;

/**
 *
 * Created by MicroStudent on 2016/4/6.
 */
public class LeastReleaseModelImpl {
    public List<Movie> getMoviesFromDataBase(int cityID){
        return null;
    }

    public List<Movie> getMoviesByNetWork(int cityID){
        if (NetworkUtils.isNetworkConnected(ContextApplication.getContext())) {
            return null;
        }
        return null;
    }

    public void getMovies(int cityID,OnLoadingCompleteListener<List<Movie>> listener) {
        List<Movie> movies;
        movies = getMoviesFromDataBase(cityID);
        if (movies == null) {
            movies = getMoviesByNetWork(cityID);
        }
        if (movies == null) {
            listener.onFailure("连接失败");
            return;
        }
        listener.onSuccess(movies);
    }
}
