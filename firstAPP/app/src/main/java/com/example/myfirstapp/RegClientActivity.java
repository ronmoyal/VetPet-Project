
package com.example.myfirstapp;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.regex.Pattern;

public class RegClientActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;


    private EditText pass1,pass2,email,phone,address,fullName;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_client);

        mAuth = FirebaseAuth.getInstance();

        fullName=(EditText)findViewById(R.id.editNameUserReg);

        pass1=(EditText) findViewById(R.id.editPassUserReg1);
        pass2=(EditText) findViewById(R.id.editPassUserReg2);

        email=(EditText)findViewById(R.id.editEmailUserReg);

        phone=(EditText)findViewById(R.id.editPhoneNumUserReg);

        address=(EditText)findViewById(R.id.editAddressUserReg);

        btnSave = (Button)findViewById(R.id.btnSUUet);
        btnSave.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        if(v==btnSave)
        {
            registerUser();

        }

    }


    private void registerUser()
    {
        String mail=email.getText().toString().trim();

        String name=fullName.getText().toString().trim();

        String p1=pass1.getText().toString().trim();
        String p2=pass2.getText().toString().trim();

        String pNum=phone.getText().toString().trim();

        String ads=address.getText().toString().trim();

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if(name.isEmpty()||p1.isEmpty()||p2.isEmpty()||pNum.isEmpty()||ads.isEmpty()||mail.isEmpty())
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
                CharSequence textV = "User hes been register";
                CharSequence textX = "Failed to register,Try Again!";
                CharSequence textE = "This user already Exits";
                if(task.isSuccessful())
                {
                    User user=new User(name,mail,pNum);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
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
