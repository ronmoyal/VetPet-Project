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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class notFeelingWell extends AppCompatActivity implements View.OnClickListener {


    EditText etTitle, etBody;
    Button btnSave;
    Boolean isDone;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference postRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_feeling_well);

        firebaseDatabase=FirebaseDatabase.getInstance();

        etTitle = (EditText) findViewById(R.id.EDITsub);
        etBody = (EditText) findViewById(R.id.editBody);
        btnSave = (Button) findViewById(R.id.saveNFW);
        btnSave.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        if (btnSave == v) {
            String uid=FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
            Post p=new Post(uid,etTitle.getText().toString(),etBody.getText().toString(),"",false);
            postRef=firebaseDatabase.getReference("Post").push();
            p.key=postRef.getKey();
            postRef.setValue(p);
            Toast.makeText(notFeelingWell.this, "Send", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(notFeelingWell.this, ClientScreenMain.class);
            startActivity(intent);
        }
    }




}



