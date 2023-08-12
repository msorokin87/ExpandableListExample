package com.android.expandablelistexample;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {


        ArrayList<String> one;
        String id="";
        TextView text_data;
        DatabaseHelper myDB;
        int id_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        init();

        one = new ArrayList<>();
        //getAndSetIntent();
        /*if (getIntent().hasExtra("id")){


        id_new = Integer.parseInt(id);
        }*/id = getIntent().getStringExtra("id");

        System.out.println(id);

       /* Cursor cursor = myDB.readAllByID(id);
        if (cursor.getCount()==0){


        }
        else while (cursor.moveToNext()){
            // id_row.add(cursor.getString(0));
            one.add(cursor.getString(2));
            // two.add(cursor.getString(3));
            // three.add(cursor.getString(4));
            // four.add(cursor.getString(5));
            // fife.add(cursor.getString(6));
            /// six.add(cursor.getString(7));
            //  seven.add(cursor.getString(8));
            // eith.add(cursor.getString(9));
            //  nine.add(cursor.getString(10));
            //  thene.add(cursor.getString(11));
            //  eleven.add(cursor.getString(12));
            //  tvele.add(cursor.getString(13));
            System.out.println(one);

        }*/
    }

    void init(){
        text_data = findViewById(R.id.text_data);

    }

    void getAndSetIntent(){



        }
    }



