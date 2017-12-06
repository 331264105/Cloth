package com.didu.domain;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Productname {
    private int id;
    private String pname;
    private String statu;

    public Productname(int id, String pname, String statu) {
        this.id = id;
        this.pname = pname;
        this.statu = statu;
    }

    public Productname(String pname, String statu) {
        this.pname = pname;
        this.statu = statu;
    }

    public Productname() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    @Override
    public String toString() {
        return "Productname{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", statu='" + statu + '\'' +
                '}';
    }
}
