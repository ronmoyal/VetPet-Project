package com.example.myfirstapp;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class postManagerTips {

    public String key;
    public String uid;
    public String title;
    public String tip;
    public int likes = 0;

    public postManagerTips() {

    }

    public postManagerTips(String uid, String title, String tip, int likes, String key){
        this.uid=uid;
        this.likes=likes;
        this.title=title;
        this.tip=tip;
        this.key=key;
    }
}