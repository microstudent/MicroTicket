package com.microstudent.app.microticket.api;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.microstudent.app.microticket.model.entity.City;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 处理JSON字段的类
 * Created by MicroStudent on 2016/4/9.
 */
public class JsonHelper {
    private static final String TAG = "JsonHelper";

    /**
     * 在返回的完全未处理的字段中提取出Data字段，返回，若data字段为空，返回null
     * @param jsonBody 完全未处理的json字段
     * @return data字段parse成的JsonArray，可能为null
     */
    public static JSONArray getJsonDataToJsonArray(String jsonBody) {
        if (!jsonBody.isEmpty()) {
            JSONObject jsonObject = JSON.parseObject(jsonBody);
            if (jsonObject.containsKey("data")) {
                return jsonObject.getJSONArray("data");
            }
        }
        Log.d(TAG, "returning null Json, the data is null");
        return null;
    }

    /**
     * 和getJsonDataToJsonArray方法没有太大的区别，区别只在返回类型变成String,可能返回空字符串
     * @param jsonBody 未处理的JsonBody
     * @return 处理后的json的data字段String类型,可能返回空字符串
     */
    public static String getJsonDataToString(String jsonBody) {
        if (!jsonBody.isEmpty()) {
            JSONObject jsonObject = JSON.parseObject(jsonBody);
            if (jsonObject.containsKey("data")) {
                return jsonObject.getString("data");
            }
        }
        Log.d(TAG, "returning empty String, the data is null");
        return "";
    }

    /**
     * 将data字段转换为City类的List，可能返回null
     * @param jsonString data字段
     * @return CityList nullable
     */
    public static List<City> toCityList(String jsonString) {
        if (!jsonString.isEmpty()) {
            List<City> list = new ArrayList<>();
            try {
                list = JSON.parseArray(jsonString, City.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
        return null;
    }

}
