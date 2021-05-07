package com.example.prohelpr.models;

public class Worker {

    String Role;
    String  Name;
    String Number;
    String Mail;
    String Address;
    String Place;
    String Category;
    String PostalCode;
    String Status;
    String Amount;

    public Worker(String role, String name, String number, String mail, String address, String place, String category, String postalCode, String status, String amount) {
        Role = role;
        Name = name;
        Number = number;
        Mail = mail;
        Address = address;
        Place = place;
        Category = category;
        PostalCode = postalCode;
        Status = status;
        Amount = amount;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
