package com.payby.terminal.demo.http.entity;

public class TerminalSetup {
    private String key;
    private String value;

    public TerminalSetup() {
        this.key = "";
        this.value = "";
    }

    public void setKey(String key) {
        this.key = key;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TerminalSetup{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
