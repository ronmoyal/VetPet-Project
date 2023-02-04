package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VetEditFAQ extends AppCompatActivity implements View.OnClickListener {

    Button btnDogEatEdit;
    Button btnDogBurnEdit;
    Button btnDogBitEdit;
    Button btnDogTreatmentsEdit;
    Button btnDogNeuteringEdit;
    Button btnDogTrainEdit;
    Button btnCatVaccineEdit;
    Button btnCatWashEdit;
    Button btnCatMarchEdit;
    Button btnCatEatEdit;
    Button btnCatMilkEdit;
    Button btnCatPoopEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_edit_faq);

        btnDogEatEdit = (Button)findViewById(R.id.btnDogEatEdit);
        btnDogBurnEdit = (Button)findViewById(R.id.btnDogBurnEdit);
        btnDogBitEdit = (Button)findViewById(R.id.btnDogBitEdit);
        btnDogTreatmentsEdit = (Button)findViewById(R.id.btnDogTreatmentsEdit);
        btnDogNeuteringEdit = (Button)findViewById(R.id.btnDogNeuteringEdit);
        btnDogTrainEdit = (Button)findViewById(R.id.btnDogTrainEdit);
        btnCatVaccineEdit = (Button)findViewById(R.id.btnCatVaccineEdit);
        btnCatWashEdit = (Button)findViewById(R.id.btnCatWashEdit);
        btnCatMarchEdit = (Button)findViewById(R.id.btnCatMarchEdit);
        btnCatEatEdit = (Button)findViewById(R.id.btnCatEatEdit);
        btnCatMilkEdit = (Button)findViewById(R.id.btnCatMilkEdit);
        btnCatPoopEdit = (Button)findViewById(R.id.btnCatPoopEdit);

        btnDogEatEdit.setOnClickListener(this);
        btnDogBurnEdit.setOnClickListener(this);
        btnDogBitEdit.setOnClickListener(this);
        btnDogTreatmentsEdit.setOnClickListener(this);
        btnDogNeuteringEdit.setOnClickListener(this);
        btnDogTrainEdit.setOnClickListener(this);
        btnCatVaccineEdit.setOnClickListener(this);
        btnCatWashEdit.setOnClickListener(this);
        btnCatMarchEdit.setOnClickListener(this);
        btnCatEatEdit.setOnClickListener(this);
        btnCatMilkEdit.setOnClickListener(this);
        btnCatPoopEdit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnDogEatEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnDogBurnEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnDogBitEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnDogTreatmentsEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnDogNeuteringEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnDogTrainEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnCatVaccineEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnCatWashEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnCatMarchEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnCatEatEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnCatMilkEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
        if(v == btnCatPoopEdit ){
            Intent intent = new Intent(this , VetEditFAQnext.class);
            startActivity(intent);
        }
    }
}