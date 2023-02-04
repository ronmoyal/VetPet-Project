package com.example.myfirstapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VetStockManager extends AppCompatActivity implements View.OnClickListener {

    ListView myListview;
    List<Vet> vetList;

    DatabaseReference VetDbRef;

    Dialog d;

    Button btnChatHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_stock_manager);

        myListview = findViewById(R.id.myListView);
        vetList = new ArrayList<>();

        VetDbRef = FirebaseDatabase.getInstance().getReference("Vet");

        VetDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                vetList.clear();
                for (DataSnapshot VetDataSnap : snapshot.getChildren())
                {
                    Vet vet = VetDataSnap.getValue(Vet.class);
                    vetList.add(vet);
                }
                ListAdapter adapter = new ListAdapter(VetStockManager.this,vetList);
                myListview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Vet vet = vetList.get(position);
                showUpdateDialog(vet.getFullname());
                showUpdateDialog(vet.getEmail());
                showUpdateDialog(vet.getCliniclocation());
                showUpdateDialog(vet.getSenioryears());
                return false;
            }
        });

    }
    private void showUpdateDialog(String name){
        d= new Dialog(this);
        d.setContentView(R.layout.custom_vet_stock_manager);
        d.setTitle("Login");
        d.setCancelable(true);
        btnChatHistory=(Button)d.findViewById(R.id.btnChatHistory);
        btnChatHistory.setOnClickListener(this);
        d.show();
    }

    @Override
    public void onClick(View v)
    {
        if(v==btnChatHistory)
        {
            Intent intent = new Intent(this, AllPostActivity.class);
            startActivity(intent);
        }
    }
}