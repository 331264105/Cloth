package com.didu.domain;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Status {
    private int id;
    private String statu;
    private String status;

    public Status(int id, String statu, String status) {
        this.id = id;
        this.statu = statu;
        this.status = status;
    }

    public Status(String statu, String status) {
        this.statu = statu;
        this.status = status;
    }

    public Status() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", statu='" + statu + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
