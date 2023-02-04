package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class adminScreen extends AppCompatActivity implements View.OnClickListener {
    Button btnLogout,btnPushNot,btnVetList ,btnEditQAadmin,btnUsersList,btnHealthEdit,btnVetProfile,btnAddP,btnNewVets;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);
        mAuth = FirebaseAuth.getInstance();

        btnVetList = (Button)findViewById(R.id.btnVets);
        btnLogout=(Button) findViewById(R.id.btnLogOutAdmin);
        btnPushNot = (Button)findViewById(R.id.btnPush);
        btnEditQAadmin = (Button)findViewById(R.id.btnEditQAadmin);
        btnUsersList = (Button)findViewById(R.id.btnUsers);
        btnHealthEdit = (Button)findViewById(R.id.btnHealthEdit);
        btnVetProfile = (Button)findViewById(R.id.btnVetProfile);
        btnNewVets = (Button)findViewById(R.id.btnNewVets);

        btnNewVets.setOnClickListener(this);
        btnVetProfile.setOnClickListener(this);
        btnHealthEdit.setOnClickListener(this);
        btnUsersList.setOnClickListener(this);
        btnAddP = (Button)findViewById(R.id.btnAddP);
        btnPushNot.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
        btnVetList.setOnClickListener(this);
        btnEditQAadmin.setOnClickListener(this);
        btnAddP.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnLogout)
        {
            mAuth.signOut();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (v == btnPushNot)
        {
            Intent intent = new Intent(this, PushNotifications.class);
            startActivity(intent);
        }
        if (v == btnVetProfile)
        {
            Intent intent = new Intent(this, RetreiveDataActivity.class);
            startActivity(intent);
        }
        if(v == btnEditQAadmin){
            Intent intent = new Intent(this , AdminEditFAQ.class);
            startActivity(intent);
        }
        if(v == btnUsersList)
        {
            Intent intent = new Intent(this , UserList.class);
            startActivity(intent);
        }
        if (v == btnHealthEdit){
            Intent intent = new Intent(this , HealthLifeEditManager.class);
            startActivity(intent);
        }
        if (v == btnHealthEdit){
            Intent intent = new Intent(this , HealthLifeEditManager.class);
            startActivity(intent);
        }
        if (v == btnVetList){
            Intent intent = new Intent(this , VetStockManager.class);
            startActivity(intent);
        }
        if(v == btnAddP) {
            Intent intent = new Intent(this, AddPirsomet.class);
            startActivity(intent);
        }
        if(v == btnNewVets) {
            Intent intent = new Intent(this, ApproveNewVet.class);
            startActivity(intent);
        }
    }
}
