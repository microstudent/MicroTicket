package com.microstudent.app.microticket.util;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.microstudent.app.microticket.config.ContextApplication;

/**
 * 对手机的信息获取类
 * Created by MicroStudent on 2016/4/6.
 */
public final class PhoneUtil {
    public static String getImei() {
        TelephonyManager telephonyManager = (TelephonyManager)
                ContextApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        } else return "";
    }
}
