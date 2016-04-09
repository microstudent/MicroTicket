package com.microstudent.app.microticket.model.entity;

/**
 * Created by MicroStudent on 2016/4/8.
 */
public class City {
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
}
