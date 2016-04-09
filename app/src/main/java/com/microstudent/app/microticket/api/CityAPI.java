package com.microstudent.app.microticket.api;

import android.util.Log;

import com.microstudent.app.microticket.util.OkHttpUtil;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * Created by MicroStudent on 2016/4/6.
 */
public class CityAPI {
    private static final String TAG = "CityAPI";

    /**
     * 同步获取城市列表String，不能在UI线程中执行
     */
    public static String getCityJsonString(){
        String requestBody = OkHttpUtil.convertToBodyString(APIConfig.getDefaultParams());
        RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), requestBody);
        Request request = new Request.Builder()
                .post(body).url(APIConfig.URL_CITY_LIST).headers(APIConfig.getDefaultHeaders().build()).build();
        Response response;
        try {
            response = OkHttpUtil.execute(request);
            if (response.isSuccessful()) {
                Log.d(TAG, "response is successful!");
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "response is failed!");
        return "";
    }

    /**
     * 异步获取城市列表
     * @param callback 获取成功/失败的回调
     */
    public void getCityJsonString(Callback callback) {
        String requestBody = OkHttpUtil.convertToBodyString(APIConfig.getDefaultParams());
        RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), requestBody);
        Request request = new Request.Builder()
                .post(body).url(APIConfig.URL_CITY_LIST).headers(APIConfig.getDefaultHeaders().build()).build();
        OkHttpUtil.enqueue(request,callback);
    }
}
