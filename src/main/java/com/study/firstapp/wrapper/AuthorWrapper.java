package com.study.firstapp.wrapper;

import com.study.firstapp.common.wrapper.ReferenceBaseWrapper;

public class AuthorWrapper extends ReferenceBaseWrapper {

    private String name;
    private String address;
    private String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "AuthorWrapper{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
