package com.didu.domain;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public class Orders {
    private int id;
    private String serial;
    private String uname;
    private int pid;
    private String totalnum;
    private double sum;
    private String address;
    private String leave;
    private String uphone;
    private String status;
    private String atime;
    private String btime;
    private String ctime;
    private List<OrdersShop> ordersShopList;

    public Orders(int id, String serial, String uname, int pid, String totalnum, double sum, String address, String leave, String uphone, String status, String atime, String btime, String ctime) {
        this.id = id;
        this.serial = serial;
        this.uname = uname;
        this.pid = pid;
        this.totalnum = totalnum;
        this.sum = sum;
        this.address = address;
        this.leave = leave;
        this.uphone = uphone;
        this.status = status;
        this.atime = atime;
        this.btime = btime;
        this.ctime = ctime;
    }

    public Orders(String serial, String uname, int pid, String totalnum, double sum, String address, String leave, String uphone, String status, String atime, String btime, String ctime) {
        this.serial = serial;
        this.uname = uname;
        this.pid = pid;
        this.totalnum = totalnum;
        this.sum = sum;
        this.address = address;
        this.leave = leave;
        this.uphone = uphone;
        this.status = status;
        this.atime = atime;
        this.btime = btime;
        this.ctime = ctime;
    }

    public Orders() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(String totalnum) {
        this.totalnum = totalnum;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLeave() {
        return leave;
    }

    public void setLeave(String leave) {
        this.leave = leave;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public List<OrdersShop> getOrdersShopList() {
        return ordersShopList;
    }

    public void setOrdersShopList(List<OrdersShop> ordersShopList) {
        this.ordersShopList = ordersShopList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", uname='" + uname + '\'' +
                ", pid=" + pid +
                ", totalnum='" + totalnum + '\'' +
                ", sum=" + sum +
                ", address='" + address + '\'' +
                ", leave='" + leave + '\'' +
                ", uphone='" + uphone + '\'' +
                ", status='" + status + '\'' +
                ", atime='" + atime + '\'' +
                ", btime='" + btime + '\'' +
                ", ctime='" + ctime + '\'' +
                ", ordersShopList=" + ordersShopList +
                '}';
    }
}
