package com.payby.terminal.demo.http.entity;

public class AmexMidMapping {
    private String mid;
    private String amexMid;

    public AmexMidMapping() {
        this.mid = "";
        this.amexMid = "";
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
    public void setAmexMid(String amexMid) {
        this.amexMid = amexMid;
    }

    public String getMid() {
        return mid;
    }
    public String getAmexMid() {
        return amexMid;
    }

    @Override
    public String toString() {
        return "AmexMidMapping{" +
                "mid='" + mid + '\'' +
                ", amexMid='" + amexMid + '\'' +
                '}';
    }
}
