package com.microstudent.app.microticket.api;

import android.util.Log;

import com.microstudent.app.microticket.util.OkHttpUtil;

import java.io.IOException;
import java.util.TreeMap;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by MicroStudent on 2016/4/9.
 */
public class MovieAPI {
    private static final String TAG = "MovieAPI";

    private int cityID;

    public final static int STATUS_LEAST_RELEASE = 1;

    public final static int STATUS_COMING_SOON = 2;


    public MovieAPI(int cityID) {
        this.cityID = cityID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public Request getRequest(String requestBody) {
        RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), requestBody);

        return new Request.Builder()
                .post(body).url(APIConfig.URL_MOVIE_LIST).headers(APIConfig.getDefaultHeaders().build()).build();
    }

    public String getRequestBody(int cityID, int status) {
        TreeMap<String, String> params = APIConfig.getDefaultParams();
        params.put("status", String.valueOf(status));
        params.put("cityId", String.valueOf(cityID));
        return OkHttpUtil.convertToBodyString(params);
    }

    /**
     * 获取未处理的JSON字符串，可能返回空字符串
     * @param status 要获取的电影列表类型，见本类中的STATUS常量
     * @return @nullable 未处理的空字符串
     */
    public String getJsonString(int cityID,int status) {
        Response response;
        String requestBody = getRequestBody(cityID,status);
        try {
            response = OkHttpUtil.execute(getRequest(requestBody));
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
}
