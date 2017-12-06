package com.didu.domain;

/**
 * Created by Administrator on 2017/11/30.
 */
public class Shoppingcar {
    private int id;
    private int cid;
    private int pid;
    private String color;
    private String selected;
    private String name;
    private String url;
    private double price;
    private String units;
    private int num;
    private String sku;

    public Shoppingcar(int id, int cid, int pid, String color, String selected, String name, String url, double price, String units, int num, String sku) {
        this.id = id;
        this.cid = cid;
        this.pid = pid;
        this.color = color;
        this.selected = selected;
        this.name = name;
        this.url = url;
        this.price = price;
        this.units = units;
        this.num = num;
        this.sku = sku;
    }

    public Shoppingcar(int cid, int pid, String color, String selected, String name, String url, double price, String units, int num, String sku) {
        this.cid = cid;
        this.pid = pid;
        this.color = color;
        this.selected = selected;
        this.name = name;
        this.url = url;
        this.price = price;
        this.units = units;
        this.num = num;
        this.sku = sku;
    }

    public Shoppingcar() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnits() {
        return units;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Shoppingcar{" +
                "id=" + id +
                ", cid=" + cid +
                ", pid=" + pid +
                ", color='" + color + '\'' +
                ", selected='" + selected + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", units='" + units + '\'' +
                ", num=" + num +
                ", sku='" + sku + '\'' +
                '}';
    }
}
