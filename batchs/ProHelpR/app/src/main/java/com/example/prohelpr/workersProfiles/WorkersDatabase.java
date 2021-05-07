package com.example.prohelpr.workersProfiles;

public class WorkersDatabase {
    String w_name;
    String role;
    String w_contact;

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getW_contact() {
        return w_contact;
    }

    public void setW_contact(String w_contact) {
        this.w_contact = w_contact;
    }

    public String getW_address() {
        return w_address;
    }

    public void setW_address(String w_address) {
        this.w_address = w_address;
    }

    public String getW_place() {
        return w_place;
    }

    public void setW_place(String w_place) {
        this.w_place = w_place;
    }

    public String getW_category() {
        return w_category;
    }

    public void setW_category(String w_category) {
        this.w_category = w_category;
    }

    String w_address;
    String w_place;
    String w_category;
    public WorkersDatabase(){

    }

    public WorkersDatabase(String w_name,String role,String w_contact,String w_address,String w_category,String w_place ){
        this.w_name=w_name;
        this.w_contact=w_contact;
       this.w_address=w_address;
       this.role=role;
        this.w_category=w_category;
        this.w_place=w_place;
    }

}
