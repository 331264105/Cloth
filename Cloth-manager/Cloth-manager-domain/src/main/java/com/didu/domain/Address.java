package com.didu.domain;

/**
 * Created by Administrator on 2017/11/27.
 */
public class Address {
        private int id;
        private String username;
        private String phone;
        private String city;
        private String detailaddress;
        private int pid;
        private String selected;

    public Address(String username, String phone, String city, String detailaddress, int pid, String selected) {
        this.username = username;
        this.phone = phone;
        this.city = city;
        this.detailaddress = detailaddress;
        this.pid = pid;
        this.selected = selected;
    }

    public Address(int id, String username, String phone, String city, String detailaddress, int pid, String selected) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.city = city;
        this.detailaddress = detailaddress;
        this.pid = pid;
        this.selected = selected;
    }

    public Address() {
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

    public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDetailaddress() {
            return detailaddress;
        }

        public void setDetailaddress(String detailaddress) {
            this.detailaddress = detailaddress;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getSelected() {
            return selected;
        }

        public void setSelected(String selected) {
            this.selected = selected;
        }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", detailaddress='" + detailaddress + '\'' +
                ", pid=" + pid +
                ", selected='" + selected + '\'' +
                '}';
    }
}
