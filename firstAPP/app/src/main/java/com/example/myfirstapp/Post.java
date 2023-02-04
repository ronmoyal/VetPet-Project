package com.example.myfirstapp;

public class Post {
    public String key,uid,body,title;
    public boolean flg;

    public Post(){
    }
    public Post(String uid,String title,String body,String key,boolean flg)
    {
        this.uid=uid;
        this.key=key;
        this.body=body;
        this.title=title;
        this.flg=flg;
    }




}
