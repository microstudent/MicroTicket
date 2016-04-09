package com.microstudent.app.microticket.api;

import com.microstudent.app.microticket.util.OkHttpUtil;
import com.microstudent.app.microticket.util.PhoneUtil;
import com.microstudent.app.microticket.util.TimeUtil;

import java.util.TreeMap;

import okhttp3.Headers;

/**
 * API的基本配置
 * Created by MicroStudent on 2016/4/6.
 */
public final class APIConfig {
    public static final String URL_CITY_LIST = "http://androidcgi.wepiao.com/city/list";
    public static final String URL_MOVIE_LIST = "http://androidcgi.wepiao.com/movie/list";

    private static TreeMap<String, String> map = new TreeMap<>();

    public static final String SIGN_SECRET = "zJwaQBQ553lHr6DfnX02WcJtZF";//密文值

    static {
        map.put("v", "2016022301");
        map.put("t", String.valueOf(TimeUtil.getNowTimestamp()));
        map.put("imei", PhoneUtil.getImei());
        map.put("appver", PhoneUtil.getAndroidVersion());
        map.put("appkey", "9");
        map.put("userId", null);
        map.put("unionId", null);
        map.put("from", "0123456789");
        map.put("deviceid", "ffffffff-98d1-af7b-f94a-43cf00c6e340");
        map.put("appChannelId", "3430000039");
        map.put("uid", null);
        map.put("openId", null);
    }

    public static TreeMap<String,String> getDefaultParams() {
        return map;
    }

    /**
     * 获得默认的header
     * @return 默认的header
     */
    public static Headers.Builder getDefaultHeaders() {
        return new Headers.Builder().add("channelId", "9").add("Content-Type", "application/x-www-form-urlencoded")
                .add("Host", "androidcgi.wepiao.com").add("Connection", "Keep-Alive");
    }
}
