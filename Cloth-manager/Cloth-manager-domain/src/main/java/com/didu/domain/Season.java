package com.didu.domain;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Season {
    private int id;
    private String season;
    private String statu;

    public Season(int id, String season, String statu) {
        this.id = id;
        this.season = season;
        this.statu = statu;
    }

    public Season(String season, String statu) {
        this.season = season;
        this.statu = statu;
    }

    public Season() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", season='" + season + '\'' +
                ", statu='" + statu + '\'' +
                '}';
    }
}
