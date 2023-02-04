package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class VetEditProfile extends AppCompatActivity {
    EditText et_name,et_email,et_clinic,et_senior;
    Button button;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_edit_profile);
        DatabaseReference DbRef = FirebaseDatabase.getInstance().getReference("Vet");

        et_name = findViewById(R.id.et_name_up);
        et_email = findViewById(R.id.et_email_up);
        et_clinic = findViewById(R.id.et_clinic_up);
        et_senior = findViewById(R.id.et_senior_up);
        button = (Button)findViewById(R.id.btn_up);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }

            private void updateProfile() {
                String strname=et_name.getText().toString().trim();
                String stremail=et_email.getText().toString().trim();
                String strclinic=et_clinic.getText().toString().trim();
                String strsenior=et_senior.getText().toString().trim();
                if(!strname.isEmpty() && !stremail.isEmpty() && !strclinic.isEmpty() && !strsenior.isEmpty())
                {
                    DbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("fullname").setValue(strname);
                    DbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("email").setValue(stremail);
                    DbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("cliniclocation").setValue(strclinic);
                    DbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("senioryears").setValue(strsenior);
                    Toast.makeText(VetEditProfile.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), VetScreen.class));
                }else
                {
                    Toast.makeText(VetEditProfile.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }




}