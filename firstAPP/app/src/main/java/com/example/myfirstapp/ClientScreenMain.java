package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ClientScreenMain extends AppCompatActivity implements View.OnClickListener {
    private TextView welcome;
    private Button btnAdd,btnLife,btnFaq,btnnfw,btnAnsFell , btnInfo,btnVetList,clickWound,btnAnsOw;
    private Button logout;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_screen_main);

        welcome=(TextView) findViewById(R.id.welcomeClient);
        btnAdd=(Button)findViewById(R.id.btn_Add);
        logout=(Button)findViewById(R.id.btnLogOutClient);
        btnLife=(Button)findViewById(R.id.btn_Health) ;
        btnFaq=(Button)findViewById(R.id.btn_FAQ) ;
        btnnfw=(Button)findViewById(R.id.btn_NFWell) ;
        btnAnsFell=(Button)findViewById(R.id.btn_NFWellAnswer) ;
        btnInfo=(Button)findViewById(R.id.btn_Info);
        btnVetList = (Button)findViewById(R.id.btn_VetList);
        clickWound=(Button)findViewById(R.id.btn_OpenWound);
        btnAnsOw=(Button)findViewById(R.id.btn_OWAnswer) ;

        firebaseAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();// this user

        btnAdd.setOnClickListener(this);
        logout.setOnClickListener(this);
        btnLife.setOnClickListener(this);
        btnFaq.setOnClickListener(this);
        btnnfw.setOnClickListener(this);
        btnAnsFell.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnVetList.setOnClickListener(this);
        clickWound.setOnClickListener(this);
        btnAnsOw.setOnClickListener(this);

        reference= FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("fullname").getValue().toString();
                welcome.setText("Welcome: "+""+name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        if(btnnfw==v)
        {
            startActivity(new Intent(this,notFeelingWell.class));
        }
        if(btnAnsFell==v)
        {
            startActivity(new Intent(this,UserPostActivity.class));

        }
        if (btnAdd==v)
        {
            startActivity(new Intent(this,AddAnimal.class));
        }
        if(btnLife==v)
        {
            startActivity(new Intent(this,AllHealthLifeTips.class));
        }
        if(btnFaq==v)
        {
            startActivity(new Intent(this,FAQUser.class));
        }
        if(btnInfo == v){
            startActivity(new Intent(this,Information.class));
        }
        if (logout==v) {
            firebaseAuth.signOut();
            startActivity(new Intent(this, MainActivity.class));
        }
        if(btnVetList == v)
        {
            startActivity(new Intent(this,VetData_User.class));
        }
        if(clickWound==v)
        {
            startActivity(new Intent(this,openWound.class));
        }
        if(btnAnsOw==v)
        {
            startActivity(new Intent(this,UserPostActivityOW.class));
        }
    }
}