package com.didu.domain;

/**
 * Created by Administrator on 2017/12/4.
 */
public class Findversionpic {
    private int id;
    private String url;
    private int uid;
    private int cid;

    public Findversionpic(int id, String url, int uid, int cid) {
        this.id = id;
        this.url = url;
        this.uid = uid;
        this.cid = cid;
    }

    public Findversionpic(String url, int uid, int cid) {
        this.url = url;
        this.uid = uid;
        this.cid = cid;
    }

    public Findversionpic() {super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Findversionpic{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", uid=" + uid +
                ", cid=" + cid +
                '}';
    }
}
