package com.microstudent.app.microticket.model.entity;

/**
 * 电影实体类
 * Created by MicroStudent on 2016/4/5.
 */
public class Movie {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public String getPoster_url_size21() {
        return poster_url_size21;
    }

    public void setPoster_url_size21(String poster_url_size21) {
        this.poster_url_size21 = poster_url_size21;
    }

    public String getPoster_url_size3() {
        return poster_url_size3;
    }

    public void setPoster_url_size3(String poster_url_size3) {
        this.poster_url_size3 = poster_url_size3;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public String getLongs() {
        return longs;
    }

    public void setLongs(String longs) {
        this.longs = longs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSimple_remarks() {
        return simple_remarks;
    }

    public void setSimple_remarks(String simple_remarks) {
        this.simple_remarks = simple_remarks;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getWantCount() {
        return wantCount;
    }

    public void setWantCount(long wantCount) {
        this.wantCount = wantCount;
    }

    public long getSeenCount() {
        return seenCount;
    }

    public void setSeenCount(long seenCount) {
        this.seenCount = seenCount;
    }

    public short getWillFlag() {
        return willFlag;
    }

    public void setWillFlag(short willFlag) {
        this.willFlag = willFlag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int id;//识别id
    private String actor;//演员
    private String country;//国家
    private String poster_url;//小封面url
    private String poster_url_size21;//中封面url
    private String poster_url_size3;//中封面url
    private String detail;//故事梗概
    private String director;//导演
    private String en_name;//英文名
    private String longs;//片长
    private String name;//电影名
    private String remark;//一句话介绍
    private String simple_remarks;//一句话介绍
    private String score;//电影评分
    private String tags;//标签
    private String version;//3D/2D等
    private long wantCount;//多少人想看
    private long seenCount;//多少人已经看过
    private short willFlag;//为1表示wantCount生效？
    private int status;//为 1 时表示获取 正在热映 的电影，为 2 时表示获取 即将上映 的电影
}
