package com.example.sematec4;

public class Item {
    private int uavatar;
    private String uname;
    private String uphone;
    private String uaddress;

    public Item(int uavatar, String uname, String uphone, String uaddress) {
        this.uavatar = uavatar;
        this.uname = uname;
        this.uphone = uphone;
        this.uaddress = uaddress;
    }

    public int getUavatar() {
        return uavatar;
    }

    public void setUavatar(int uavatar) {
        this.uavatar = uavatar;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }
}
