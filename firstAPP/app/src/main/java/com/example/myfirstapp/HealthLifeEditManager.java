package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HealthLifeEditManager extends AppCompatActivity implements View.OnClickListener {

    EditText etTitle, etTip;
    Button btnSave, btnAllTips;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference postManagerTipsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_life_edit_manager);

        firebaseDatabase = FirebaseDatabase.getInstance();

        etTitle = (EditText) findViewById(R.id.etTitle);
        etTip = (EditText) findViewById(R.id.etTip);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnAllTips = (Button) findViewById(R.id.btnAllTips);
        btnAllTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthLifeEditManager.this, AllHealthLifeTips.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v){
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        postManagerTips p = new postManagerTips(uid,etTitle.getText().toString(),etTip.getText().toString(),0,"");
        postManagerTipsRef = firebaseDatabase.getReference("HealthLife/").push();
        p.key = postManagerTipsRef.getKey();
        postManagerTipsRef.setValue(p);
    }
}