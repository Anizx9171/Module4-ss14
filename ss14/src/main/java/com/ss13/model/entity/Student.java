package com.ss13.model.entity;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private String address;
    private Date birthdate;
    private boolean sex;

    public Student() {
    }

    public Student(int id, String name, String address, Date birthdate, boolean sex) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
