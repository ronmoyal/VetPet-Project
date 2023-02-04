package com.example.myfirstapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListUserAdapter extends ArrayAdapter {

    private Activity mContext;
    List<User> UserList;

    public ListUserAdapter(Activity mContext, List<User> UserList){
        super(mContext,R.layout.list_user_item,UserList);
        this.mContext = mContext;
        this.UserList = UserList;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_user_item,null,true);

        TextView tvUserName = listItemView.findViewById(R.id.tvUserName);
        TextView tvUserEmail = listItemView.findViewById(R.id.tvUserEmail);
        TextView tvUserPhone = listItemView.findViewById(R.id.tvUserPhone);

        User user = UserList.get(position);

        tvUserName.setText("Name - " + user.getFullname());
        tvUserEmail.setText("Email - " +user.getEmail());
        tvUserPhone.setText("Phone Number - " +user.getPhone());

        return listItemView;
    }
}
