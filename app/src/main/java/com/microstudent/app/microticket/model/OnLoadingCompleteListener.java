package com.microstudent.app.microticket.model;

/**
 * 回调接口
 * Created by MicroStudent on 2016/4/7.
 */
public interface OnLoadingCompleteListener<V> {
        void onSuccess(V data);
        void onFailure(String msg);
}
