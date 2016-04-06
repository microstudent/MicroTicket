package com.microstudent.app.microticket.ui.view;

import com.microstudent.app.microticket.model.entity.Movie;

import java.util.List;

/**
 * Created by MicroStudent on 2016/4/5.
 */
public interface LeastReleaseView {
    void showLoading();
    void hideLoading();
    void showError(String msg);
    void setMoviesData(List<Movie> movies);
}
