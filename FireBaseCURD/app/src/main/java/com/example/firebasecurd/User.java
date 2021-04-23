package com.example.firebasecurd;
class User {
    private String name,mobileno,email,username,password;

    public User() {
    }

    public User(String name, String mobileno, String email, String username, String password) {
        this.name = name;
        this.mobileno = mobileno;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
