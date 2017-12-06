package com.didu.domain;

/**
 * Created by Administrator on 2017/11/30.
 */
public class OrdersShop {
    private int id;
    private String name;
    private String url;
    private String color;
    private double price;
    private int num;
    private String units;
    private int cid;
    private int pid;
    private String serial;
    private String sku;

    public OrdersShop(int id, String name, String url, String color, double price, int num, String units, int cid, int pid, String serial, String sku) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.color = color;
        this.price = price;
        this.num = num;
        this.units = units;
        this.cid = cid;
        this.pid = pid;
        this.serial = serial;
        this.sku = sku;
    }

    public OrdersShop(String name, String url, String color, double price, int num, String units, int cid, int pid, String serial, String sku) {
        this.name = name;
        this.url = url;
        this.color = color;
        this.price = price;
        this.num = num;
        this.units = units;
        this.cid = cid;
        this.pid = pid;
        this.serial = serial;
        this.sku = sku;
    }

    public OrdersShop() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "OrdersShop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", units='" + units + '\'' +
                ", cid=" + cid +
                ", pid=" + pid +
                ", serial='" + serial + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }
}
