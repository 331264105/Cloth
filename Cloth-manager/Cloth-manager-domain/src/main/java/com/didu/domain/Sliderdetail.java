package com.didu.domain;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Sliderdetail {
    private int id;
    private String url ;
    private int cid;

    public Sliderdetail(String url, int cid) {
        this.url = url;
        this.cid = cid;
    }

    public Sliderdetail(int id, String url, int cid) {
        this.id = id;
        this.url = url;
        this.cid = cid;

    }

    public Sliderdetail() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Sliderdetail{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", cid=" + cid +
                '}';
    }
}
