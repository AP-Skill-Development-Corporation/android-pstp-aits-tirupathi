package com.example.firebasecurd;
class User {
    private String name;
    private String mobile;
    private String email;
    private String filepath;

    public User() {
    }

    public User(String name, String mobile, String email, String filepath) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.filepath = filepath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
