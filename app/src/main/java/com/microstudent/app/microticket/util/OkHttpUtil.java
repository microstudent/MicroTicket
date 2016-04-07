package com.microstudent.app.microticket.util;

import com.microstudent.app.microticket.api.APIList;

import java.io.IOException;
import java.util.TreeMap;

import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * Created by MicroStudent on 2016/4/6.
 */
public class OkHttpUtil {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient();


    public static Response execute(Request request) throws IOException {
        return client.newCall(request).execute();
    }

    //异步执行
    public static void enqueue(Request request, Callback callback){
        client.newCall(request).enqueue(callback);
    }

    /**
     * 根据键值对生成post_body
     * @param params 键值对
     * @return body
     */
    public static String convertToBodyString(TreeMap<String, String> params) {
        StringBuilder builder = new StringBuilder();
        final String bodyWithoutSign = convertToBodySrtingWithoutSign(params);
        final String sign = Md5Util.string2Md5Upper(APIList.signSecret + bodyWithoutSign);
        builder.append("sign=");
        builder.append(sign);
        builder.append("&");
        builder.append(bodyWithoutSign);
        return builder.toString();
    }

    /**
     * 根据有序TreeMap的内容生成body内容,不包含sign值
     * @param parameters 键值对
     * @return body
     */
    private static String convertToBodySrtingWithoutSign(TreeMap<String,String> parameters) {
        final StringBuilder result = new StringBuilder();
        for (String encodedName : parameters.keySet()) {
            final String encodedValue = parameters.get(encodedName);
            if (result.length() > 0) {
                result.append('&');
            }
            result.append(encodedName);
            result.append('=');
            if (encodedValue != null) {
                result.append(encodedValue);
            }
        }
        return result.toString();
    }

    /**
     * 获得默认的header
     * @return 默认的header
     */
    public static Headers.Builder getDefaultHeaders() {
        return new Headers.Builder().add("channelId", "9").add("Content-Type", "application/x-www-form-urlencoded")
                .add("Host", "androidcgi.wepiao.com").add("Connection", "Keep-Alive");
    }


    private static String post(String url,RequestBody body)throws IOException {
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    private class BasicNameValuePair {
        public final String key;
        public final String value;

        public BasicNameValuePair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
