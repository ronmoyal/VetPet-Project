package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AllHealthLifeTips extends AppCompatActivity {

    ListView lv;
    ArrayList<postManagerTips> posts;
    AllHealthLifeTipsAdapter allHealthLifeTipsAdapter;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_health_life_tips);

        database = FirebaseDatabase.getInstance().getReference("HealthLife");
        lv = (ListView) findViewById(R.id.lv);
        this.retriveData();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                postManagerTips p = posts.get(position);
                Intent intent = new Intent(AllHealthLifeTips.this, EditHealthLifeTips.class);
                intent.putExtra("key", p.key);
                startActivity(intent);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                postManagerTips p = posts.get(position);
                DatabaseReference current = FirebaseDatabase.getInstance().getReference("HealthLife/" + p.key);
                current.removeValue();
                Toast.makeText(AllHealthLifeTips.this, "Successfully deleted ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AllHealthLifeTips.this, HealthLifeEditManager.class);
                startActivity(intent);
                return true;
            }
        });
    }

    //lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    //        @Override
    //        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
    //          Post p = posts.get(position);
    //             DatabaseReference current = FirebaseDatabase.getInstance().getReference("Post/" + p.key);
    //            current.removeValue();
    //            Toast.makeText(AllPostActivity.this, "Successfully deleted ", Toast.LENGTH_SHORT).show();
    //            Intent intent = new Intent(AllPostActivity.this, VetScreen.class);
    //            startActivity(intent);
    //
    //            return true;
    //
    //
    //
    //        }
    //    });

    public void retriveData() {

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                posts = new ArrayList<postManagerTips>();
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    postManagerTips p = data.getValue(postManagerTips.class);
                    posts.add(p);
                }
                allHealthLifeTipsAdapter = new AllHealthLifeTipsAdapter(AllHealthLifeTips.this,0,0,posts);
                lv.setAdapter(allHealthLifeTipsAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}