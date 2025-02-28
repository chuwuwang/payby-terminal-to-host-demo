package com.payby.terminal.demo.http.response.device;

import androidx.annotation.NonNull;

public class Store {
    private String name;
    private String location;
    private String cashDeskPhotoPath;
    private String storeEntrancePhotoPath;

    public Store() {
        this.name = "";
        this.location = "";
        this.cashDeskPhotoPath = "";
        this.storeEntrancePhotoPath = "";
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public String getCashDeskPhotoPath() {
        return cashDeskPhotoPath;
    }
    public String getStoreEntrancePhotoPath() {
        return storeEntrancePhotoPath;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setCashDeskPhotoPath(String cashDeskPhotoPath) {
        this.cashDeskPhotoPath = cashDeskPhotoPath;
    }
    public void setStoreEntrancePhotoPath(String storeEntrancePhotoPath) {
        this.storeEntrancePhotoPath = storeEntrancePhotoPath;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", cashDeskPhotoPath='" + cashDeskPhotoPath + '\'' +
                ", storeEntrancePhotoPath='" + storeEntrancePhotoPath + '\'' +
                '}';
    }
}
