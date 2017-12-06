package com.didu.domain;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public class Findversion {
    private int id;
    private String leave;
    private String username;
    private String typ;
    private String element;
    private String address;
    private String phone;
    private String status;
    private String datetime;
    private String serial;
    private int uid;
    private String  price;
    private String  num;
    private List<Findversionpic> findversionpics;

    public Findversion(int id, String leave, String username, String typ, String element, String address, String phone, String status, String datetime, String serial, int uid, String price, String num, List<Findversionpic> findversionpics) {
        this.id = id;
        this.leave = leave;
        this.username = username;
        this.typ = typ;
        this.element = element;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.datetime = datetime;
        this.serial = serial;
        this.uid = uid;
        this.price = price;
        this.num = num;
        this.findversionpics = findversionpics;
    }

    public Findversion(String leave, String username, String typ, String element, String address, String phone, String status, String datetime, String serial, int uid, String price, String num, List<Findversionpic> findversionpics) {
        this.leave = leave;
        this.username = username;
        this.typ = typ;
        this.element = element;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.datetime = datetime;
        this.serial = serial;
        this.uid = uid;
        this.price = price;
        this.num = num;
        this.findversionpics = findversionpics;
    }

    public Findversion() {super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeave() {
        return leave;
    }

    public void setLeave(String leave) {
        this.leave = leave;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public List<Findversionpic> getFindversionpics() {
        return findversionpics;
    }

    public void setFindversionpics(List<Findversionpic> findversionpics) {
        this.findversionpics = findversionpics;
    }

    @Override
    public String toString() {
        return "Findversion{" +
                "id=" + id +
                ", leave='" + leave + '\'' +
                ", username='" + username + '\'' +
                ", typ='" + typ + '\'' +
                ", element='" + element + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", datetime='" + datetime + '\'' +
                ", serial='" + serial + '\'' +
                ", uid=" + uid +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                ", findversionpics=" + findversionpics +
                '}';
    }
}
