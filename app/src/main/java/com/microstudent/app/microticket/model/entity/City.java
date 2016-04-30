package com.microstudent.app.microticket.model.entity;

import android.support.annotation.NonNull;

import com.microstudent.app.microticket.util.PinyinUtils;

/**
 * Created by MicroStudent on 2016/4/8.
 */
public class City implements Comparable<City>{
    private String cityID;
    private String name;
    private String pinyin;

    public String getId() {
        return cityID;
    }

    public void setId(String cityID) {
        this.cityID = cityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(@NonNull City another) {
        int i = 0;
        char a, b;
        do {
            a = PinyinUtils.getPinyinLetter(name, i);
            b = PinyinUtils.getPinyinLetter(another.name, i);
            i++;
        } while (a == b && i < name.length() && i < another.name.length());
        return a - b;
    }
}
