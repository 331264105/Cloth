package com.didu.domain;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Color {
    private int id;
    private String color;
    private String statu;

    public Color(int id, String color, String statu) {
        this.id = id;
        this.color = color;
        this.statu = statu;
    }

    public Color(String color, String statu) {
        this.color = color;
        this.statu = statu;
    }

    public Color() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", statu='" + statu + '\'' +
                '}';
    }
}
