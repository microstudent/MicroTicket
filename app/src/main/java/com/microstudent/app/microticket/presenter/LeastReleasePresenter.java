package com.microstudent.app.microticket.presenter;

import android.support.v4.app.Fragment;

/**
 *
 * Created by MicroStudent on 2016/4/5.
 */
public interface LeastReleasePresenter {
    void loadData(int cityNo);

    void onMovieClicked(int position);

    void onDestroy();
}
