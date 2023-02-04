package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class VetScreen extends AppCompatActivity implements View.OnClickListener {

    Button btnFell, btnLogout, btnWaiting, btnContact, btnHealth, btnEditQA,btnEditScreen,btnEditOW;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_screen);

        firebaseAuth = FirebaseAuth.getInstance();

        btnFell = (Button) findViewById(R.id.btnSick);
        btnLogout = (Button) findViewById(R.id.btnLogOutVet);
        btnWaiting = (Button) findViewById(R.id.btnWaiting);
        btnContact = (Button) findViewById(R.id.btnContact);
        btnEditScreen = (Button)findViewById(R.id.btn_editScreen);
        btnEditOW=(Button)findViewById(R.id.btnWound) ;

        btnHealth = (Button) findViewById(R.id.btnHealth);

        btnEditQA = (Button) findViewById(R.id.EditBtnQA);

        btnContact.setOnClickListener(this);
        btnFell.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
        btnWaiting.setOnClickListener(this);
        btnEditScreen.setOnClickListener(this);
        btnHealth.setOnClickListener(this);
        btnEditOW.setOnClickListener(this);
        btnEditQA.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (btnFell == v) {
            Intent intent = new Intent(this, AllPostActivity.class);
            startActivity(intent);
        }
        if (v == btnLogout) {
            firebaseAuth.signOut();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (btnWaiting == v) {
            Intent intent = new Intent(this, AllPostActivity.class);
            startActivity(intent);
        }
        if (v == btnContact) {
            Intent intent = new Intent(this, Contact_us.class);
            startActivity(intent);
        }

        if (v == btnHealth) {
            Intent intent = new Intent(this, HealthLifeEditManager.class);
            startActivity(intent);
        }

        if (v == btnEditQA) {
            startActivity(new Intent(this, VetEditFAQ.class));

        }
        if(v == btnEditScreen){
            startActivity(new Intent(this,VetEditProfile.class));
        }
        if(v==btnEditOW){
            startActivity(new Intent(this,AllPostActivityOW.class));

        }
    }
}