package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditHealthLifeTips extends AppCompatActivity implements View.OnClickListener{
    EditText etTitle, etTip;
    Button btnSave;
    FirebaseDatabase database;
    DatabaseReference tipsRef;

    String key;
    postManagerTips p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_health_life_tips);

        database = FirebaseDatabase.getInstance();
        etTitle = (EditText) findViewById(R.id.etTitle);
        etTip = (EditText) findViewById(R.id.etTip);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        Intent intent = getIntent();

        key = intent.getExtras().getString("key");
        tipsRef = database.getReference("HealthLife/" + key);
        this.retrieveData();
    }

    public void retrieveData(){
        tipsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                p = dataSnapshot.getValue(postManagerTips.class);
                etTip.setText(p.tip);
                etTitle.setText(p.title);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v){
        tipsRef = database.getReference("HealthLife/" + p.key);
        p.uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        p.title = etTitle.getText().toString();
        p.tip = etTip.getText().toString();
        p.likes = 0;
        tipsRef.setValue(p);

        finish();
    }
}