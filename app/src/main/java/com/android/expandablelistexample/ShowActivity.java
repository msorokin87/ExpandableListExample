package com.android.expandablelistexample;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ShowActivity extends AppCompatActivity {

        RecyclerView recyclerView;
        CustomAdapterShow adapterShow;
        ArrayList<String> one, two1, desc, desc_two;
        String id="";
        TextView text_data;
        DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        init();
        myDB = new DatabaseHelper(ShowActivity.this);

        one = new ArrayList<>();
        desc = new ArrayList<>();

        two1 = new ArrayList<>();
        desc_two = new ArrayList<>();

        Cursor cursor = myDB.readAllData();
        if (cursor.getCount()==0){
        }
        else while (cursor.moveToNext()){
            one.add(cursor.getString(1));

        }
        List<String> list = new ArrayList<>(one);
        for (String lis : list){
            if (!lis.equals("null")){
                two1.add(lis);

            }
        }

        Cursor cursor_desc = myDB.readAllDesc();
        if (cursor_desc.getCount()==0){
        }
        else while (cursor_desc.moveToNext()){
            desc.add(cursor_desc.getString(1));

        }
        List<String> list_desc = new ArrayList<>(desc);
        for (String lis_d : list_desc){
            if (lis_d.equals("null") || lis_d.equals("")){

                desc_two.add("");

            } else desc_two.add(lis_d);

            System.out.println(desc_two);
        }


        System.out.println("Выход из цикла " + two1);


        adapterShow = new CustomAdapterShow(ShowActivity.this, this, two1, desc_two);
        recyclerView.setAdapter(adapterShow);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowActivity.this));
    }




    void init(){
        text_data = findViewById(R.id.text_data);
        recyclerView = findViewById(R.id.recyclerView);

    }


    @Override
    protected void onStop() {
        super.onStop();
        myDB.deleteAllData();
        myDB.deleteAllDataDesc();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.deleteAllData();
        myDB.deleteAllDataDesc();
    }
}



