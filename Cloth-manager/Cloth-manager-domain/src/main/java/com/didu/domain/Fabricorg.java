package com.didu.domain;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Fabricorg {
    private int id;
    private String fabric;
    private String statu;

    public Fabricorg(int id, String fabric, String statu) {
        this.id = id;
        this.fabric = fabric;
        this.statu = statu;
    }

    public Fabricorg(String fabric, String statu) {
        this.fabric = fabric;
        this.statu = statu;
    }

    public Fabricorg() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    @Override
    public String toString() {
        return "Fabricorg{" +
                "id=" + id +
                ", fabric='" + fabric + '\'' +
                ", statu='" + statu + '\'' +
                '}';
    }
}
