package com.example.registrationwithfirbasedatabase;

public class studentPojo {

    String name;
    String rollNumber;
    String branch;
    String mobilenumbr;
    String email;

    public studentPojo() {
    }

    public studentPojo(String name, String rollNumber, String branch, String mobilenumbr, String email) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.branch = branch;
        this.mobilenumbr = mobilenumbr;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMobilenumbr() {
        return mobilenumbr;
    }

    public void setMobilenumbr(String mobilenumbr) {
        this.mobilenumbr = mobilenumbr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
