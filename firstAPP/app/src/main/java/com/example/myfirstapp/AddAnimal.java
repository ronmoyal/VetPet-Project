package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

import java.lang.ref.Reference;

public class AddAnimal extends AppCompatActivity implements View.OnClickListener {

    private  FirebaseDatabase database;
    private DatabaseReference myRef;


    private EditText breed,age,weight;
    private Button btnDog,btnCat,btnConfirm;

    boolean clickCat=false;
    boolean clickDog=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);


        database=FirebaseDatabase.getInstance();


        breed=(EditText) findViewById(R.id.editBreed);
        age=(EditText) findViewById(R.id.editAge);
        weight=(EditText) findViewById(R.id.editWeight);

        btnDog=(Button) findViewById(R.id.btnDog);
        btnCat=(Button) findViewById(R.id.btnCat);
        btnConfirm=(Button) findViewById(R.id.btnConfirm);

        btnDog.setOnClickListener(this);
        btnCat.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (btnCat==v)
        {
            clickCat=true;
            clickDog=false;
            btnCat.setBackgroundColor(Color.parseColor("#8b0000"));
            btnDog.setBackgroundColor(Color.parseColor("#DFD5C5"));

        }
        if (btnDog==v)
        {
            clickCat=false;
            clickDog=true;
            btnDog.setBackgroundColor(Color.parseColor("#8b0000"));
            btnCat.setBackgroundColor(Color.parseColor("#DFD5C5"));

        }
        if(btnConfirm==v)
        {

                addDataAnimel();
        }


    }

    private void addDataAnimel()
    {
        String strBreed=breed.getText().toString().trim();
        String strAge=age.getText().toString().trim();
        String strWeight=weight.getText().toString().trim();

        if (strBreed.isEmpty())
        {
            breed.setError("Enter Breed");
            breed.requestFocus();
            return;
        }
        if (strAge.isEmpty())
        {
            age.setError("Enter Age");
            age.requestFocus();
            return;
        }
        if (strWeight.isEmpty())
        {
            breed.setError("Enter Weight");
            breed.requestFocus();
            return;
        }

        if((clickCat)||(clickDog))
        {
            if(clickCat)
            {

                Cat cat=new Cat(strBreed,strAge,strWeight);
                myRef=database.getReference("Cat");

                DatabaseReference userRef = database.getReference("Users");

                userRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Cat")
                        .setValue(cat).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Added Cat successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), ClientScreenMain.class));

                        }
                    }
                });
            }
             else if(clickDog)
            {
                Dog dog=new Dog(strBreed,strAge,strWeight);
                myRef=database.getReference("Dog");
                DatabaseReference userRef = database.getReference("Users");

                userRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Dog")
                        .setValue(dog).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Added Dog successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), ClientScreenMain.class));

                        }
                    }
                });

            }
        }



    }
}