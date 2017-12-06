package com.didu.domain;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private String units;
    private int num;
    private String statu;
    private String status;
    private String color;
    private String pname;
    private String fabric;
    private String season;
    private String sku;
    private String art;
    private String textture;
    private String url;
    private String place;

    public Product(int id, String name, double price, String units, int num, String statu, String status, String color, String pname, String fabric, String season, String sku, String art, String textture, String url, String place) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.units = units;
        this.num = num;
        this.statu = statu;
        this.status = status;
        this.color = color;
        this.pname = pname;
        this.fabric = fabric;
        this.season = season;
        this.sku = sku;
        this.art = art;
        this.textture = textture;
        this.url = url;
        this.place = place;
    }

    public Product(String name, double price, String units, int num, String statu, String status, String color, String pname, String fabric, String season, String sku, String art, String textture, String url, String place) {
        this.name = name;
        this.price = price;
        this.units = units;
        this.num = num;
        this.statu = statu;
        this.status = status;
        this.color = color;
        this.pname = pname;
        this.fabric = fabric;
        this.season = season;
        this.sku = sku;
        this.art = art;
        this.textture = textture;
        this.url = url;
        this.place = place;
    }

    public Product() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnits() {
        return units;
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getTextture() {
        return textture;
    }

    public void setTextture(String textture) {
        this.textture = textture;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", units='" + units + '\'' +
                ", num=" + num +
                ", statu='" + statu + '\'' +
                ", status='" + status + '\'' +
                ", color='" + color + '\'' +
                ", pname='" + pname + '\'' +
                ", fabric='" + fabric + '\'' +
                ", season='" + season + '\'' +
                ", sku='" + sku + '\'' +
                ", art='" + art + '\'' +
                ", textture='" + textture + '\'' +
                ", url='" + url + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
