package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HealthLifeTips extends AppCompatActivity {

    TextView title, tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_life_tips);

        SharedPreferences sp = getSharedPreferences("AddTip",MODE_PRIVATE);
        String Title = sp.getString("title","");
        String Tip = sp.getString("tip","");

        title = (TextView)findViewById(R.id.tvDisplay);
        title.setText(Title);

        tip = (TextView) findViewById(R.id.tvDisplay2);
        tip.setText(Tip);
    }
}