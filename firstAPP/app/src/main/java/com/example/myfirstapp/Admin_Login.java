package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Admin_Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText editTextEmail,editTextPassword;
    private Button signInAdmin,forgetTextLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = (EditText)findViewById(R.id.et_AdminEmail);
        editTextPassword = (EditText)findViewById(R.id.et_passwordAdmin);
        forgetTextLink = (Button) findViewById(R.id.btn_forgetAdmin);
        forgetTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetEmail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password?");
                passwordResetDialog.setMessage("Enter your Email To received Reset Link");
                passwordResetDialog.setView(resetEmail);
                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the email and send the reset link
                        String mail = resetEmail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Admin_Login.this,"Reset link has sent to your email",Toast.LENGTH_SHORT);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Admin_Login.this,"Error",Toast.LENGTH_SHORT);
                            }
                        });
                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close the dialog
                    }
                });
                passwordResetDialog.create().show();
            }
        });
        signInAdmin =(Button)findViewById(R.id.btn_loginAdmin);
        signInAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminLogin();
            }

            private void AdminLogin() {
                String emaiL = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                if (emaiL.isEmpty()){
                    editTextEmail.setError("Email is required");
                    editTextEmail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(emaiL).matches()){
                    editTextEmail.setError("please enter a valid mail");
                    editTextEmail.requestFocus();
                    return;
                }
                if(password.isEmpty()){
                    editTextPassword.setError("password is required");
                    editTextPassword.requestFocus();
                    return;
                }

                mAuth.signInWithEmailAndPassword(emaiL, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //&& emaiL.equals("vetpet@gmail.com") && password.equals("vet123456")
                        if (task.isSuccessful() ) {
                            startActivity(new Intent(context, adminScreen.class));
                        } else {
                            Toast.makeText(context, "faild to login!", duration).show();
                        }
                    }
                });
            }
        });

    }
}