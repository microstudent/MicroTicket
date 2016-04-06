package com.microstudent.app.microticket.config;

import android.app.Application;
import android.content.Context;

/**
 * Created by MicroStudent on 2016/4/6.
 */
public class ContextApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        if (context != null) {
            return context;
        } else throw new RuntimeException("context is null!");
    }
}
