package com.example.myfirstapp;

public class User
{
    public String fullname,email,phone;

    public User(String fullname,String email,String phone){
        this.fullname=fullname;
        this.email=email;
        this.phone=phone;
    }
    public User (){

    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
