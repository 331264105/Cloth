package com.didu.domain;

/**
 * Created by Administrator on 2017/12/4.
 */
public class Teamwork {
    private int id;
    private String username;
    private String userphone;
    private String address;
    private String project;
    private int uid;

    public Teamwork(int id, String username, String userphone, String address, String project, int uid) {
        this.id = id;
        this.username = username;
        this.userphone = userphone;
        this.address = address;
        this.project = project;
        this.uid = uid;
    }

    public Teamwork(String username, String userphone, String address, String project, int uid) {
        this.username = username;
        this.userphone = userphone;
        this.address = address;
        this.project = project;
        this.uid = uid;
    }

    public Teamwork() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Teamwork{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userphone='" + userphone + '\'' +
                ", address='" + address + '\'' +
                ", project='" + project + '\'' +
                ", uid=" + uid +
                '}';
    }
}
