package com.microstudent.app.microticket.model.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.microstudent.app.microticket.api.APIThreadPool;
import com.microstudent.app.microticket.api.CityAPI;
import com.microstudent.app.microticket.model.OnLoadingCompleteListener;
import com.microstudent.app.microticket.model.entity.City;
import com.microstudent.app.microticket.model.entity.Result;

import java.util.ArrayList;

/**
 *
 * Created by MicroStudent on 2016/4/7.
 */
public class CityModelImpl{
    private static final int MESSAGE_POST_RESULT = 1;//handler的what

    private static final String TAG = "CityModelImpl";
    private CityAPI mApi = new CityAPI();

    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            if (mListener != null) {
                if (msg.obj == null) {
                    mListener.onFailure("获取失败，请稍后再试！");
                } else {
                    @SuppressWarnings("unchecked")
                    ArrayList<City> cityList = (ArrayList<City>) msg.obj;
                    mListener.onSuccess(cityList);
                }
            }
        }
    };

    private OnLoadingCompleteListener<ArrayList<City>> mListener;

    public ArrayList<City> getCityFromDataBase() {
        return null;
    }

    private void getCityFromNetWork() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                String jsonBody = mApi.getCityJsonString();
                if (!jsonBody.isEmpty()) {
                    ArrayList<City> city = convertToArrayList(jsonBody);
                    if (city == null) {
                        //若获取转换失败则发送空消息给Handler处理
                        mMainHandler.obtainMessage().sendToTarget();
                        return;
                    }
                    mMainHandler.obtainMessage(MESSAGE_POST_RESULT, city).sendToTarget();
                }
            }
        };
        APIThreadPool.THREAD_POOL_EXECUTOR.execute(task);
    }

    private ArrayList<City> convertToArrayList(String jsonBody) {
        Log.d(TAG, "得到jsonBody");
        Log.d(TAG, jsonBody.substring(0, 30));

        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("210","广州","guangzhou"));
        cities.add(new City("211","上海","shanghai"));
        cities.add(new City("212","北京","beijing"));

        return cities;
    }

    public void getCity(OnLoadingCompleteListener<ArrayList<City>> listener) {
        this.mListener = listener;
        ArrayList<City> result = getCityFromDataBase();
        if (result == null) {
            getCityFromNetWork();
            return;
        }
        listener.onSuccess(result);
    }
}
