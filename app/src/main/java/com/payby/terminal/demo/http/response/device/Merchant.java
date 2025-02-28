package com.payby.terminal.demo.http.response.device;

public class Merchant {
    private String mid;
    private String name;
    private String status;
    private String category;
    private String contactName;
    private String contactEmail;
    private String contactMobile;
    private String licencePhotoPath;

    public Merchant() {
        this.mid = "";
        this.name = "";
        this.status = "";
        this.category = "";
        this.contactName = "";
        this.contactEmail = "";
        this.contactMobile = "";
        this.licencePhotoPath = "";
    }

    public String getMid() {
        return mid;
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public String getCategory() {
        return category;
    }
    public String getContactName() {
        return contactName;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public String getContactMobile() {
        return contactMobile;
    }
    public String getLicencePhotoPath() {
        return licencePhotoPath;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "mid='" + mid + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactMobile='" + contactMobile + '\'' +
                ", licencePhotoPath='" + licencePhotoPath + '\'' +
                '}';
    }
}
