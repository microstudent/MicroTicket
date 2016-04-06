package com.microstudent.app.microticket.util;

import java.io.IOException;
import java.util.List;

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
     * 根据List的内容生成body内容
     * @param parameters 键值对
     * @return body
     */
    public static String convertToBodySrting(List<BasicNameValuePair> parameters) {
            final StringBuilder result = new StringBuilder();
            for (final BasicNameValuePair parameter : parameters) {
                final String encodedName = parameter.key;
                final String encodedValue = parameter.value;
                if (result.length() > 0) {
                    result.append('&');
                }
                result.append(encodedName);
                if (encodedValue != null) {
                    result.append('=');
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
