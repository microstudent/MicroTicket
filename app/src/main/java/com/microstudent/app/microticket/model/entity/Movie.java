package com.microstudent.app.microticket.model.entity;

/**
 * 电影实体类
 * Created by MicroStudent on 2016/4/5.
 */
public class Movie {
    private Movie(int id) {
        this.id = id;
    }

    public static Movie build(int id){
        return new Movie(id);
    }
    public Movie actor(String name) {
        this.name = name;
        return this;
    }

    public Movie country(String country) {
        this.country = country;
        return this;
    }

    public Movie poster_url_s(String poster_url_s) {
        this.poster_url_s = poster_url_s;
        return this;
    }

    public Movie poster_url_m(String poster_url_m) {
        this.poster_url_m = poster_url_m;
        return this;
    }

    public Movie detail(String detail) {
        this.detail = detail;
        return this;
    }

    public Movie director(String director) {
        this.director = director;
        return this;
    }

    public Movie en_name(String en_name) {
        this.en_name = en_name;
        return this;
    }

    public Movie longs(String longs) {
        this.longs = longs;
        return this;
    }

    public Movie remark(String remark) {
        this.remark = remark;
        return this;
    }

    public Movie score(int score) {
        this.score = score;
        return this;
    }

    public Movie tags(String tags) {
        this.tags = tags;
        return this;
    }

    public Movie version(String version) {
        this.version = version;
        return this;
    }

    public Movie wantCount(long wantCount) {
        this.wantCount = wantCount;
        return this;
    }

    public Movie seenCount(long seenCount) {
        this.seenCount = seenCount;
        return this;
    }

    public Movie willFlag(short willFlag) {
        this.willFlag = willFlag;
        return this;
    }

    public Movie status(int status) {
        this.status = status;
        return this;
    }

    public int getId() {
        return id;
    }

    private int id;//识别id
    private String actor;//演员
    private String country;//国家
    private String poster_url_s;//小封面url
    private String poster_url_m;//中封面url
    private String detail;//故事梗概
    private String director;//导演
    private String en_name;//英文名
    private String longs;//片长
    private String name;//电影名
    private String remark;//一句话介绍
    private int score;//电影评分
    private String tags;//标签
    private String version;//3D/2D等
    private long wantCount;//多少人想看
    private long seenCount;//多少人已经看过
    private short willFlag;//为1表示wantCount生效？
    private int status;//为 1 时表示获取 正在热映 的电影，为 2 时表示获取 即将上映 的电影
}
