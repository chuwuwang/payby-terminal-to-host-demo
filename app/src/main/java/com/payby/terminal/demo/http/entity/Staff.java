package com.payby.terminal.demo.http.entity;


public class Staff{
    private Long id;
    private String name;
    private String status;
    private String password;
    private String role;

    public Staff() {
        this.id = 0L;
        this.name = "";
        this.status = "";
        this.password = "";
        this.role = "";
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
