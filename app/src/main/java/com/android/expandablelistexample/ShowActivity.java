package com.android.expandablelistexample;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    ArrayList<ModelNewList> modelArray;
    ModelNewList model;
    ArrayList<String> listArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent i = getIntent();
        if (i !=null) {
            model = (ModelNewList) i.getSerializableExtra("list");
        }
        System.out.println(" Модель " + model.getTitleGods());

    }


    }
