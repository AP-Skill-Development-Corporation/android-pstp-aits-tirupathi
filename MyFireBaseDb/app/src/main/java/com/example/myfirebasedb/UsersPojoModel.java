package com.example.myfirebasedb;

public class UsersPojoModel {
    String name,aadhar,email,mobile;
    /*Alt+insert */

    public UsersPojoModel(String name, String aadhar, String email, String mobile) {
        this.name = name;
        this.aadhar = aadhar;
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
