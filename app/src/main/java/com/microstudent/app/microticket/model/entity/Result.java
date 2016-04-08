package com.microstudent.app.microticket.model.entity;

import java.util.List;

/**
 * Created by MicroStudent on 2016/4/8.
 */
public abstract class Result<T> {
    private String msg;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }
}
