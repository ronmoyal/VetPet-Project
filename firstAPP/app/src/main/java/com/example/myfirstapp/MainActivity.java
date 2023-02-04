package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity{
    AdView mAdView;
    Button RegAsVet;
    Button RegAsClient;
    Button ClickLogIn;
    Button ClickLogInVet;
    Button ClickLogInAdmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RegAsVet = (Button)findViewById(R.id.btn_registerVet);
        RegAsClient = (Button)findViewById(R.id.btn_registerClient);
        ClickLogIn = (Button) findViewById(R.id.btn_login);
        ClickLogInVet = (Button) findViewById(R.id.btn_loginVET);
        ClickLogInAdmin = (Button)findViewById(R.id.btn_loginAdmin);




        RegAsClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRegClientActivity();
            }
        });

        RegAsVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRegVetActivity();
            }
        });

        ClickLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLoginActivity();
            }
        });

        ClickLogInVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRegVetActivityVet();
            }
        });
        ClickLogInAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               OpenLogInAdminActivity();
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void OpenRegClientActivity(){
        Intent intentClient = new Intent(this,RegClientActivity.class);
        startActivity(intentClient);
    }

    public void OpenRegVetActivity(){
        Intent intentVet = new Intent(this,RegVetActivity.class);
        startActivity(intentVet);
    }

    public void OpenLoginActivity(){
        Intent intentLogin = new Intent(this,LoginActivity.class);
        startActivity(intentLogin);
    }

    public void OpenRegVetActivityVet(){
        Intent intentLoginVet = new Intent(this,LoginActivityVet.class);
        startActivity(intentLoginVet);
    }

    public void OpenLogInAdminActivity()
    {
        Intent intentLoginAdmin = new Intent(this,Admin_Login.class);
        startActivity(intentLoginAdmin);
    }
}