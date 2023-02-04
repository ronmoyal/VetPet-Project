package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class PushNotifications extends AppCompatActivity {
    private EditText title,message;
    private Button sentbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notifications);

        FirebaseMessaging.getInstance().subscribeToTopic("all");
        title = findViewById(R.id.title_id);
        message = findViewById(R.id.message_id);
        sentbtn = findViewById(R.id.setn_btn);

        sentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!title.getText().toString().isEmpty() && !message.getText().toString().isEmpty())
                {
                    FcmNotificationsSender notificationsSender = new FcmNotificationsSender("/topics/all",title.getText().toString(),message.getText().toString(),getApplicationContext(),PushNotifications.this);
                    notificationsSender.SendNotifications();
                    
                }else
                {
                    Toast.makeText(PushNotifications.this, "Please give your data", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}