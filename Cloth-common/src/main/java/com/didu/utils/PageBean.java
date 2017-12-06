package com.didu.utils;

/**
 * Created by Administrator on 2017/11/18.
 */
public class PageBean {
    private int page;
    private  int  rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCounts() {
        return (page-1)*rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }
}
