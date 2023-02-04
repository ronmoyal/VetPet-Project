package com.example.myfirstapp;

public class Vet {

    public String fullname,email,cliniclocation,senioryears;

        public Vet(){
        }

        public Vet(String fullname,String email,String cliniclocation,String senioryears){
            this.fullname = fullname;
            this.email = email;
            this.cliniclocation = cliniclocation;
            this.senioryears = senioryears;
        }
    public String getFullname() {
            return fullname;
        }

    public String getCliniclocation() {
        return cliniclocation;
    }

    public String getSenioryears() {
        return senioryears;
    }

    public String getEmail() {
            return email;
        }

}


