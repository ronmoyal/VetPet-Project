package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegVetActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;

    int SELECT_PICTURE = 200;

    boolean btn=false;


    // One Preview Image
    ImageView IVPreviewImage;

    private EditText pass1,pass2,email,phone,clinic_location,senior_years,fullName;
    private Button btnSave,btnDip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reg_vet);

        // register the UI widgets with their appropriate IDs
        IVPreviewImage = findViewById(R.id.IVPreviewImage);

        mAuth = FirebaseAuth.getInstance();

        fullName=(EditText)findViewById(R.id.editNameVetReg);

        pass1=(EditText) findViewById(R.id.editPassVetReg1);
        pass2=(EditText) findViewById(R.id.editPassVetReg2);

        email=(EditText)findViewById(R.id.editEmailVetReg);

        phone=(EditText)findViewById(R.id.editPhoneNumVetReg);

        clinic_location=(EditText)findViewById(R.id.editAddressVetReg);
        senior_years = (EditText)findViewById(R.id.editSeniorYears);

        btnSave = (Button)findViewById(R.id.btnSUVet);
        btnSave.setOnClickListener(this);

        btnDip=(Button) findViewById(R.id.btnDip);
        btnDip.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v==btnSave)
        {
            if(btn==true)
            registerVet();
            else
            {
                Toast toast = Toast.makeText(getApplicationContext(), "Please upload a diploma", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
        }
        if(v==btnDip)
        {
            btn=true;
            addDiploma();
        }

    }


    private void addDiploma()
    {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {

                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }

}


    private void registerVet()
    {
        String mail=email.getText().toString().trim();

        String name=fullName.getText().toString().trim();

        String p1=pass1.getText().toString().trim();
        String p2=pass2.getText().toString().trim();

        String pNum=phone.getText().toString().trim();
        String seniorStringYears = senior_years.getText().toString().trim();
        String ads=clinic_location.getText().toString().trim();

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if(name.isEmpty()||p1.isEmpty()||p2.isEmpty()||pNum.isEmpty()||ads.isEmpty()||mail.isEmpty()||seniorStringYears.isEmpty())
        {
            CharSequence text ="All fields are required";
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
            return;
        }
        if (pNum.length() < 10) {
            phone.setError("Short Number");
            phone.requestFocus();
            return;
        }
        if (!p1.equals(p2))
        {
            pass1.requestFocus();
            pass2.requestFocus();
            CharSequence text = "Invalid Password";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        if((p1.length()<8))
        {
            phone.setError("8 Charters min");
            pass1.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
        {
            email.setError("Please provide valid mail");
            email.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(mail,p1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                CharSequence textV = "Complete! please Wait for approve";
                CharSequence textX = "Failed to register,Try Again!";
                CharSequence textE = "Please wait for approve";
                if(task.isSuccessful())
                {
                    Vet vet=new Vet(name,mail,ads,seniorStringYears);
                    FirebaseDatabase.getInstance().getReference("Vet")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(vet).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {

                            if(task.isSuccessful())
                            {
                                Toast.makeText(context,textV,duration).show();
                            }
                            else
                            {
                                Toast.makeText(context,textX,duration).show();

                            }
                        }
                    });
                } else
                {
                    Toast.makeText(context,textE,duration).show();

                }
            }
        });
    }
}