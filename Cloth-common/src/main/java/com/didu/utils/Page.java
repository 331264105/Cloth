package com.didu.utils;

/**
 * Created by Administrator on 2017/12/1.
 */
public class Page {
    private int page;
    private int rows;

    public Page(int page, int rows) {
        this.page = page;
        this.rows = rows;
    }

    public Page() {
        super();
    }

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

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }
}
