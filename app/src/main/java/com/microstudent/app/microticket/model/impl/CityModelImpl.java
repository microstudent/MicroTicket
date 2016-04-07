package com.microstudent.app.microticket.model.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.microstudent.app.microticket.api.APIThreadPool;
import com.microstudent.app.microticket.api.CityAPI;
import com.microstudent.app.microticket.model.OnLoadingCompleteListener;

import java.util.HashMap;

/**
 * Created by MicroStudent on 2016/4/7.
 */
public class CityModelImpl {
    private static final int MESSAGE_POST_RESULT = 1;

    private static final String TAG = "CityModelImpl";
    private CityAPI mApi = new CityAPI();

    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            Result result = null;
            if (msg.obj != null) {
                result = (Result) msg.obj;
            }
            if (result == null) {
                Log.w(TAG, "获取城市列表失败");
                if (mListener != null) {
                    mListener.onFailure("获取城市列表失败");
                }
            }else if (mListener != null) {
                mListener.onSuccess(result.cityList);
            }
        }
    };

    private OnLoadingCompleteListener<HashMap<String, String>> mListener;

    public HashMap<String,String> getCityFromDataBase() {
        return null;
    }

    private void getCityFromNetWork() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                String jsonBody = mApi.getCityJsonString();
                if (!jsonBody.isEmpty()) {
                    HashMap<String, String> citys = convertToHashMap(jsonBody);
                    if (citys == null) {
                        //若获取转换失败则发送空消息给Handler处理
                        mMainHandler.obtainMessage().sendToTarget();
                        return;
                    }
                    Result result = new Result(citys);
                    mMainHandler.obtainMessage(MESSAGE_POST_RESULT, result).sendToTarget();
                }
            }
        };
        APIThreadPool.THREAD_POOL_EXECUTOR.execute(task);
    }

    private HashMap<String, String> convertToHashMap(String jsonBody) {
        Log.d(TAG, "得到json");
        return null;
    }

    public void getCity(OnLoadingCompleteListener<HashMap<String,String>> listener) {
        this.mListener = listener;
        HashMap<String,String> result = getCityFromDataBase();
        if (result == null) {
            getCityFromNetWork();
            return;
        }
        listener.onSuccess(result);
    }

    private static class Result{
        HashMap<String, String> cityList;

        public Result(HashMap<String, String> cityList) {
            this.cityList = cityList;
        }
    }
}
