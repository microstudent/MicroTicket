package com.microstudent.app.microticket.config;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by MicroStudent on 2016/4/6.
 */
public class ContextApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        //初始化Fresco框架
        Fresco.initialize(context);
    }

    public static Context getContext() {
        if (context != null) {
            return context;
        } else throw new RuntimeException("context is null!");
    }
}
