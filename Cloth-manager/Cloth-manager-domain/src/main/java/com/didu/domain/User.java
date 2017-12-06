package com.didu.domain;

/**
 * Created by Administrator on 2017/12/4.
 */
public class User {
    private int id;
    private String username;
    private String userphone;
    private String openid;

    public User(int id, String username, String userphone, String openid) {
        this.id = id;
        this.username = username;
        this.userphone = userphone;
        this.openid = openid;
    }

    public User(String username, String userphone, String openid) {
        this.username = username;
        this.userphone = userphone;
        this.openid = openid;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userphone='" + userphone + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }
}
