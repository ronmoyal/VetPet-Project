package com.example.myfirstapp;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AllHealthLifeTipsAdapter extends ArrayAdapter<postManagerTips> {

    Context context;
    List<postManagerTips> objects;

    public AllHealthLifeTipsAdapter(Context context, int resource, int textViewResourceId, List<postManagerTips> objects){
        super(context, resource, textViewResourceId, objects);

        this.context=context;
        this.objects=objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_healthlifetips, parent, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        postManagerTips temp = objects.get(position);
        tvTitle.setText(temp.title);

        return view;
    }

}
