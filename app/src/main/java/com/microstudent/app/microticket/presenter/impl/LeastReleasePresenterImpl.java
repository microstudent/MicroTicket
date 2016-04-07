package com.microstudent.app.microticket.presenter.impl;

import android.os.Handler;

import com.microstudent.app.microticket.adapter.MoviesAdapter;
import com.microstudent.app.microticket.model.OnLoadingCompleteListener;
import com.microstudent.app.microticket.model.entity.Movie;
import com.microstudent.app.microticket.model.impl.CityModelImpl;
import com.microstudent.app.microticket.model.impl.LeastReleaseModelImpl;
import com.microstudent.app.microticket.presenter.LeastReleasePresenter;
import com.microstudent.app.microticket.ui.view.LeastReleaseView;

import java.util.HashMap;
import java.util.List;

/**
 *
 * Created by MicroStudent on 2016/4/6.
 */
public class LeastReleasePresenterImpl implements LeastReleasePresenter,OnLoadingCompleteListener<List<Movie>> {
    private LeastReleaseView view;
    private LeastReleaseModelImpl model;


    public LeastReleasePresenterImpl(LeastReleaseView leastReleaseView) {
        this.view = leastReleaseView;
        model = new LeastReleaseModelImpl();
    }


    @Override
    public void loadData(final int cityNo) {
        if (view != null) {
            view.showLoading();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //model.getMovies(cityNo, LeastReleasePresenterImpl.this);
                    view.setAdapter(new MoviesAdapter(view.getContext()));
                }
            },2000);
        }
    }

    @Override
    public void onMovieClicked(int position) {

    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onSuccess(List<Movie> data) {
        if (view != null) {

        }
    }

    @Override
    public void onFailure(String msg) {
        if (view != null) {
            view.hideLoading();
            view.showError(msg);
        }
    }
}
