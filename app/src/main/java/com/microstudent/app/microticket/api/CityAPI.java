package com.microstudent.app.microticket.api;

import com.microstudent.app.microticket.util.PhoneUtil;
import com.microstudent.app.microticket.util.TimeUtil;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by MicroStudent on 2016/4/6.
 */
public class CityAPI {
    private static final String version = "2016022301";
    private static final long time = TimeUtil.getNowTimestamp();
    private String sign;
    private static final String imei = PhoneUtil.getImei();

}
