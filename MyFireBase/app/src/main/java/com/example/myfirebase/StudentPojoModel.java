package com.example.myfirebase;

public class StudentPojoModel {
    String name,email,mobile,address,gender,branch;
/*Alt+insert*/
    public StudentPojoModel(String name, String email, String mobile, String address, String gender, String branch) {

        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.gender = gender;
        this.branch = branch;
    }
    /*Alt+insert*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
