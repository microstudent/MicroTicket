package com.microstudent.app.microticket.presenter.impl;

import com.microstudent.app.microticket.adapter.MoviesAdapter;
import com.microstudent.app.microticket.model.OnLoadingCompleteListener;
import com.microstudent.app.microticket.model.entity.Movie;
import com.microstudent.app.microticket.model.impl.LeastReleaseModelImpl;
import com.microstudent.app.microticket.presenter.LeastReleasePresenter;
import com.microstudent.app.microticket.ui.view.LeastReleaseView;

import java.util.ArrayList;

/**
 *
 * Created by MicroStudent on 2016/4/6.
 */
public class LeastReleasePresenterImpl implements LeastReleasePresenter,OnLoadingCompleteListener<ArrayList<Movie>> {
    private LeastReleaseView mView;
    private LeastReleaseModelImpl mModel;

    private MoviesAdapter mAdapter;

    public LeastReleasePresenterImpl(LeastReleaseView leastReleaseView) {
        this.mView = leastReleaseView;
        mModel = new LeastReleaseModelImpl();
        mAdapter = new MoviesAdapter(mView.getContext());

    }


    @Override
    public void loadData(final int cityNo) {
        if (mView != null) {
            mView.setAdapter(mAdapter);

            mView.showLoading();
            mModel.loadMovies(cityNo, this);
        }
    }

    @Override
    public void onMovieClicked(int position) {

    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void onSuccess(ArrayList<Movie> data) {
        mAdapter.setData(data);
        mView.hideLoading();
    }

    @Override
    public void onFailure(String msg) {
        mView.hideLoading();
        mView.showError(msg);
    }
}
