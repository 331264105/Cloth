package com.didu.domain;

/**
 * Created by Administrator on 2017/11/27.
 */
public class Carousel {
    private int id;
    private String url;

    public Carousel(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public Carousel(String url) {
        this.url = url;
    }

    public Carousel() {
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

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
