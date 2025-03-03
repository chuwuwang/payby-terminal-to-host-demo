package com.payby.terminal.demo.http.entity;

public class TerminalSetup {
    private String pkey;
    private String pvalue;

    public TerminalSetup() {
        this.pkey = "";
        this.pvalue = "";
    }

    public void setKey(String key) {
        this.pkey = key;
    }
    public void setValue(String value) {
        this.pvalue = value;
    }

    public String getKey() {
        return pkey;
    }
    public String getValue() {
        return pvalue;
    }

    @Override
    public String toString() {
        return "TerminalSetup{" +
                "key='" + pkey + '\'' +
                ", value='" + pvalue + '\'' +
                '}';
    }
}
