package com.payby.terminal.demo.http.response.device;

import com.payby.terminal.demo.http.entity.AmexMidMapping;
import com.payby.terminal.demo.http.entity.Receipt;
import com.payby.terminal.demo.http.entity.Role;
import com.payby.terminal.demo.http.entity.Staff;
import com.payby.terminal.demo.http.entity.TerminalSetup;

import java.util.List;
import java.util.Map;

public class ConfigInfo {
    private Store store;
    private Device device;
    private Merchant merchant;
    private List<Role> roleList;
    private List<Staff> staffList;
    private Map<String, Boolean> needPassword;
    private Receipt posReceipt;
    private AmexMidMapping  amexMidMapping;
    private List<TerminalSetup> terminalSetupList;

    public ConfigInfo() {
        this.store = new Store();
        this.device = new Device();
        this.merchant = new Merchant();
        this.roleList = null;
        this.staffList = null;
        this.needPassword = null;
        this.posReceipt = new Receipt();
        this.amexMidMapping = new AmexMidMapping();
        this.terminalSetupList = null;
    }

    public Store getStore() {
        return store;
    }
    public Device getDevice() {
        return device;
    }
    public Merchant getMerchant() {
        return merchant;
    }
    public List<Role> getRoleList() {
        return roleList;
    }
    public List<Staff> getStaffList() {
        return staffList;
    }
    public Map<String, Boolean> getNeedPassword() {
        return needPassword;
    }
    public Receipt getPosReceipt() {
        return posReceipt;
    }
    public AmexMidMapping getAmexMidMapping() {
        return amexMidMapping;
    }
    public List<TerminalSetup> getTerminalSetupList() {
        return terminalSetupList;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    public void setDevice(Device device) {
        this.device = device;
    }
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
    public void setNeedPassword(Map<String, Boolean> needPassword) {
        this.needPassword = needPassword;
    }
    public void setPosReceipt(Receipt posReceipt) {
        this.posReceipt = posReceipt;
    }
    public void setAmexMidMapping(AmexMidMapping amexMidMapping) {
        this.amexMidMapping = amexMidMapping;
    }
    public void setTerminalSetupList(List<TerminalSetup> terminalSetupList) {
        this.terminalSetupList = terminalSetupList;
    }

    @Override
    public String toString() {
        return "ConfigInfo{" +
                "store=" + store +
                ", device=" + device +
                ", merchant=" + merchant +
                ", roleList=" + roleList +
                ", staffList=" + staffList +
                ", needPassword=" + needPassword +
                ", posReceipt=" + posReceipt +
                ", amexMidMapping=" + amexMidMapping +
                ", terminalSetupList=" + terminalSetupList +
                '}';
    }
}
