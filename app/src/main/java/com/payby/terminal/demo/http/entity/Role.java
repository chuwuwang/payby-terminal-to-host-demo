package com.payby.terminal.demo.http.entity;

import java.util.List;

public class Role {
    private Long id;
    private String name;
    private List<String> accessMenuList;

    public Role() {
        this.id = 0L;
        this.name = "";
        this.accessMenuList = null;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAccessMenuList(List<String> accessMenuList) {
        this.accessMenuList = accessMenuList;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<String> getAccessMenuList() {
        return accessMenuList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accessMenuList=" + accessMenuList +
                '}';
    }
}
