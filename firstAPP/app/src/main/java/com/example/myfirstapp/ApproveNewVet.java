package com.example.myfirstapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class ApproveNewVet extends AppCompatActivity implements View.OnClickListener{

    Button btnVetList, btnDiplomas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_new_vet);

        btnDiplomas= (Button) findViewById(R.id.btnDiplomas);
        btnVetList=(Button) findViewById(R.id.btnVetList);
        btnDiplomas.setOnClickListener(this);
        btnVetList.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (btnVetList == v) {
            Intent intent = new Intent(this, RetreiveDataActivity.class);
            startActivity(intent);
        }
        if (btnDiplomas == v) {
            Toast.makeText(this, "All Diplomas Are Valid In Database", Toast.LENGTH_SHORT).show();
        }
    }

}


