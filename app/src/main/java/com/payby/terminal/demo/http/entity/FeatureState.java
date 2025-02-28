package com.payby.terminal.demo.http.entity;

public class FeatureState {
    private String  status;
    private String  display;

    public FeatureState() {
        this.status = "";
        this.display = "";
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDisplay(String display) {
        this.display = display;
    }

    public String getStatus() {
        return status;
    }
    public String getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return "FeatureState{" +
                "status='" + status + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
