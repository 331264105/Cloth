package com.didu.domain;

/**
 * Created by Administrator on 2017/12/4.
 */
public class Admin {
    private int id;
    private String password;
    private String userphone;
    private String number;
    private String remark;

    public Admin(int id, String password, String userphone, String number, String remark) {
        this.id = id;
        this.password = password;
        this.userphone = userphone;
        this.number = number;
        this.remark = remark;
    }

    public Admin(String password, String userphone, String number, String remark) {
        this.password = password;
        this.userphone = userphone;
        this.number = number;
        this.remark = remark;
    }

    public Admin() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userphone='" + userphone + '\'' +
                ", number='" + number + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
