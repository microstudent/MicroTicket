package com.microstudent.app.microticket.model.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.microstudent.app.microticket.api.APIThreadPool;
import com.microstudent.app.microticket.api.JsonHelper;
import com.microstudent.app.microticket.api.MovieAPI;
import com.microstudent.app.microticket.config.ContextApplication;
import com.microstudent.app.microticket.model.OnLoadingCompleteListener;
import com.microstudent.app.microticket.model.entity.City;
import com.microstudent.app.microticket.model.entity.Movie;
import com.microstudent.app.microticket.util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by MicroStudent on 2016/4/6.
 */
public class LeastReleaseModelImpl {

    private static final String TAG = "LeastReleaseModelImpl";
    private static final int MESSAGE_POST_RESULT = 1;
    private OnLoadingCompleteListener<ArrayList<Movie>> mListener;

    private MovieAPI mApi;

    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            if (mListener != null) {
                if (msg.obj == null) {
                    mListener.onFailure("获取失败，请稍后再试！");
                } else {
                    @SuppressWarnings("unchecked")
                    ArrayList<Movie> movies = (ArrayList<Movie>) msg.obj;
                    mListener.onSuccess(movies);
                }
            }
        }
    };

    public ArrayList<Movie> getMoviesFromDataBase(int cityID){
        return null;
    }


    /**
     * 在网络中获取电影
     * @param cityID 城市号
     */
    public void getMoviesByNetWork(final int cityID){
        if (mApi == null) {
            mApi = new MovieAPI(cityID);
        } else if (mApi.getCityID() != cityID) {
            mApi.setCityID(cityID);
        }
        Runnable task = new Runnable() {
            @Override
            public void run() {
                String jsonBody = mApi.getJsonString(cityID,MovieAPI.STATUS_LEAST_RELEASE);
                ArrayList<Movie> movies = convertToArrayList(jsonBody);
                if (movies != null) {
                    Log.d(TAG, "sending result");
                    mMainHandler.obtainMessage(MESSAGE_POST_RESULT, movies).sendToTarget();
                } else {
                    //转换失败，发送空消息
                    Log.d(TAG, "sending empty message");
                    mMainHandler.obtainMessage().sendToTarget();
                }
            }
        };
        APIThreadPool.THREAD_POOL_EXECUTOR.execute(task);
    }

    /**
     * **待改进！**
     */
    public void loadMovies(int cityID, OnLoadingCompleteListener<ArrayList<Movie>> listener) {
        this.mListener = listener;
        ArrayList<Movie> result = getMoviesFromDataBase(cityID);
        if (result == null) {
            getMoviesByNetWork(cityID);
            return;
        }
        listener.onSuccess(result);
    }

    private ArrayList<Movie> convertToArrayList(String jsonBody) {
        Log.d(TAG, "得到jsonBody");
        if (!jsonBody.isEmpty()) {
            String dataBody = JsonHelper.getJsonDataToString(jsonBody);

            return (ArrayList<Movie>) JsonHelper.toMovieList(dataBody);
        }else
            return null;
    }
}
