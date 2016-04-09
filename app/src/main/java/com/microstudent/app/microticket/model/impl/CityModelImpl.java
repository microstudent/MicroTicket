package com.microstudent.app.microticket.model.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.microstudent.app.microticket.api.APIThreadPool;
import com.microstudent.app.microticket.api.CityAPI;
import com.microstudent.app.microticket.api.JsonHelper;
import com.microstudent.app.microticket.model.OnLoadingCompleteListener;
import com.microstudent.app.microticket.model.entity.City;
import com.microstudent.app.microticket.model.entity.Result;

import java.util.ArrayList;
import java.util.List;

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
                ArrayList<City> city = convertToArrayList(jsonBody);
                if (city != null) {
                    Log.d(TAG, "sending result");
                    mMainHandler.obtainMessage(MESSAGE_POST_RESULT, city).sendToTarget();
                } else {
                    //转换失败，发送空消息
                    Log.d(TAG, "sending empty message");
                    mMainHandler.obtainMessage().sendToTarget();
                }
            }
        };
        APIThreadPool.THREAD_POOL_EXECUTOR.execute(task);
    }

    private ArrayList<City> convertToArrayList(String jsonBody) {
        Log.d(TAG, "得到jsonBody");
        if (!jsonBody.isEmpty()) {
            String dataBody = JsonHelper.getJsonDataToString(jsonBody);

            return (ArrayList<City>) JsonHelper.toCityList(dataBody);
        }else
            return null;
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
