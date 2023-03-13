package com.example.hello;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    private String Name;
    private String Email;
    private String password;
    public User(){}

    public User(String Name, String Email, String password){
        this.Name=Name;
        this.Email=Email;
        this.password=password;
    }
    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", password=" + password +
                '}';
    }
}
