package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {

    ListView myListviewUser;
    List<User> userList;

    DatabaseReference UserDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        myListviewUser = findViewById(R.id.myListViewUser);
        userList = new ArrayList<>();

        UserDbRef = FirebaseDatabase.getInstance().getReference("Users");

        UserDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userList.clear();

                for (DataSnapshot userDatasnap : snapshot.getChildren())
                {
                    User user = userDatasnap.getValue(User.class);
                    userList.add(user);
                }

                ListUserAdapter adapter = new ListUserAdapter(UserList.this,userList);
                myListviewUser.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}