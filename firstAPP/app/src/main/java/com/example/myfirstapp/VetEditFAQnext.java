package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VetEditFAQnext extends AppCompatActivity implements View.OnClickListener {

    EditText newQuestion, newAnswer;
    Button btnSumbit;
    FirebaseDatabase database;
    DatabaseReference postRef;

    String key;
    Post p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_edit_faqnext);

        database = FirebaseDatabase.getInstance();
        newQuestion = (EditText) findViewById(R.id.editNewQuestion);
        newAnswer = (EditText) findViewById(R.id.editNewAnswer);
        btnSumbit = (Button) findViewById(R.id.btnSendNewQA);

        btnSumbit.setOnClickListener(this);

    }

    // code needed - connect request ot fire base or send email .


    @Override
    public void onClick(View v) {

        String question = newQuestion.getText().toString().trim();
        String answer = newAnswer.getText().toString().trim();
        String email = "vetpetmanager@gmail.com";

        if (question.isEmpty() || answer.isEmpty()) {
            Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
        } else {
            String mail = "mailto:" + email + "?&question=" + Uri.encode(question) + "&answer=" + Uri.encode(answer);
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse(mail));
            //intent.putExtra(intent.EXTRA_SUBJECT,question);
            //intent.putExtra(intent.EXTRA_TEXT, answer);
            try {
                startActivity(Intent.createChooser(intent, "Sending Email..."));
            } catch (Exception e) {
                Toast.makeText(this, "Exception" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}