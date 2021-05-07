package com.example.prohelpr.users;

public class User_home_design {
    String role,address,category,name,contact,place;


    public User_home_design(String role, String address, String category, String name, String contact, String place) {
        this.role = role;
        this.address = address;
        this.category = category;
        this.name = name;
        this.contact = contact;
        this.place = place;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
