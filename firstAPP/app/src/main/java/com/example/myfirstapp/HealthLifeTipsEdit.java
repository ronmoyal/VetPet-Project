package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HealthLifeTipsEdit extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences sp;
    Button btnSave, btnRemove;
    EditText etTitle, etTip;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_life_tips_edit);

        btnSave=(Button)findViewById(R.id.btnSubmit);
        btnRemove=(Button)findViewById(R.id.btnRemove);
        btnSave.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        etTitle=(EditText)findViewById(R.id.etTitle);
        etTip=(EditText)findViewById(R.id.etTip);
        sp=getSharedPreferences("AddTip",0);
        tvDisplay=(TextView)findViewById(R.id.tvDisplay);
        String strTitle = sp.getString("title",null);
        String strTip = sp.getString("tip",null);
    }

    @Override
    public void onClick(View v) {
        if(btnSave==v)
        {
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("title",etTitle.getText().toString());
            editor.putString("tip",etTip.getText().toString());
            editor.commit();
            Toast.makeText(this, "The tip is added", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HealthLifeTips.class);
            startActivity(intent);
        }
        if(btnRemove==v){
            String strTitle = sp.getString("title",null);
            String strTip = sp.getString("tip",null);
            if(strTitle!=null&&strTip!=null){
                sp.edit().remove("title").commit();
                sp.edit().remove("tip").commit();
                Toast.makeText(this, "The last tip is removed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HealthLifeTips.class);
                startActivity(intent);
            }
        }
    }
}