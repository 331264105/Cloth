package com.didu.domain;

/**
 * Created by Administrator on 2017/11/28.
 */
public class Push {
    private int id;
    private String url;
    private String text;

    public Push(int id, String url, String text) {
        this.id = id;
        this.url = url;
        this.text = text;
    }

    public Push(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public Push() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "PushControl{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
