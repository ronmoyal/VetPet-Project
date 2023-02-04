package com.example.myfirstapp;

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

public class RetreiveDataActivity extends AppCompatActivity {

    ListView myListview;
    List<Vet> vetList;

    DatabaseReference VetDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreive_data);

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
                ListAdapter adapter = new ListAdapter(RetreiveDataActivity.this,vetList);
                myListview.setAdapter(adapter);
            }
            //Until here is without update

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
        AlertDialog.Builder mDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View mDialogView = inflater.inflate(R.layout.update_dialog,null);

        mDialog.setView(mDialogView);
        EditText etUpdatefullname = mDialogView.findViewById(R.id.etUpdatefullname);
        EditText etUpdateEmail = mDialogView.findViewById(R.id.etUpdateEmail);
        EditText etUpdateClincLocation = mDialogView.findViewById(R.id.etUpdateClinic);
        EditText etUpdateSeniorYears = mDialogView.findViewById(R.id.etUpdateSenior);
        Button btnUpdate = mDialogView.findViewById(R.id.btnUpdate);

        mDialog.setTitle("Updating" + name + "record");
        AlertDialog dialog =
        mDialog.show();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here i update database from firebase

                String newName =etUpdatefullname.getText().toString();
                String newEmail =etUpdateEmail.getText().toString();
                String newClinic = etUpdateClincLocation.getText().toString();
                String newSenior = etUpdateSeniorYears.getText().toString();
                updateData(newName,newEmail,newClinic,newSenior);
                Toast.makeText(RetreiveDataActivity.this, "", Toast.LENGTH_SHORT).show();

            }

        });


    }
    private void updateData(String name,String email,String clinic,String senior){
        //create database ref
        DatabaseReference DbRef = FirebaseDatabase.getInstance().getReference("Vet").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        Vet vet = new Vet(name,email,clinic,senior);
        DbRef.setValue(vet);


    }
}