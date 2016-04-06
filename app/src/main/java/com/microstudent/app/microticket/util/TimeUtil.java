package com.microstudent.app.microticket.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by MicroStudent on 2016/4/5.
 */
public final class TimeUtil {
    public static long getNowTimestamp(){
        return System.currentTimeMillis();
    }

    public static String timestamp2Time(long timestamp){
        if (timestamp<=0)
            return "";
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timestamp * 1000));
    }
}
