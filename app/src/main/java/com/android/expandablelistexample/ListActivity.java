package com.android.expandablelistexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addButton;
    Button back_button, delete_button;

    ImageView empty_imageview;
    TextView no_data;
    DatabaseHelper myDB;
    ArrayList<String> goods_id, goods_title, goods_desc;
    String one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvelve;
    ArrayList<String> one1, two2, three3, four4, fife5, six6, seven7, eith8, nine9, thene10, eleven11, tvelve12;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();
        storeDataInArray();
        addDataFromSort();
        startAdapter();


        getDataNewString();
        startAdapter();
        backButon();
        deleteButon();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        back_button = findViewById(R.id.back_button);
        delete_button = findViewById(R.id.delete_button);
        myDB = new DatabaseHelper(ListActivity.this);

       /* myDB = new DatabaseHelper(this);
        mList = new ArrayList<>();*/

       /* data = new ArrayList<>();
        goods_id = new ArrayList<>();*/
        goods_title = new ArrayList<>();
      //  goods_desc = new ArrayList<>();

        one1 = new ArrayList<>();
        two2 = new ArrayList<>();
        three3 = new ArrayList<>();
        four4= new ArrayList<>();
        fife5 = new ArrayList<>();
        six6 = new ArrayList<>();
        seven7 = new ArrayList<>();
        eith8 = new ArrayList<>();
        nine9 = new ArrayList<>();
        thene10 = new ArrayList<>();
        eleven11 = new ArrayList<>();
        tvelve12 = new ArrayList<>();




        addItem();






    }

    void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount()==0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }
        else while (cursor.moveToNext()){
            //goods_id.add(cursor.getString(0));
            goods_title.add(cursor.getString(1));
         // goods_desc.add(cursor.getString(2));



        }
        empty_imageview.setVisibility(View.GONE);
        no_data.setVisibility(View.GONE);
    }
    void getDataNewString(){
        for (int i = 0; i < 1; i++) {
            one= goods_title.get(i);
            System.out.println(one);
        }
        for (int i = 1; i < 2; i++) {
            two=goods_title.get(i);
        }
        for (int i = 2; i < 3; i++) {
            three=goods_title.get(i);
        }
        for (int i = 3; i < 4; i++) {
            four=goods_title.get(i);
        }
        for (int i = 4; i < 5; i++) {
            fife=goods_title.get(i);
        }
        for (int i = 5; i < 6; i++) {
            six=goods_title.get(i);
        }
        for (int i = 6; i < 7; i++) {
            seven=goods_title.get(i);
        }
        for (int i = 7; i < 8; i++) {
            eith=goods_title.get(i);
        }
        for (int i = 8; i < 9; i++) {
            nine=goods_title.get(i);
        }
        for (int i = 9; i < 10; i++) {
            thene=goods_title.get(i);
        }
        for (int i = 10; i < 11; i++) {
            eleven=goods_title.get(i);
        }
        for (int i = 11; i < 12; i++) {
            tvelve=goods_title.get(i);
            System.out.println(tvelve);
        }

        myDB.addAllinSort(one, two, three, four, fife, six, seven, eith, nine,
                thene, eleven, tvelve);

    }

    void addDataFromSort() {
        Cursor cursor = myDB.readAllSort();
        if (cursor.getCount() == 0){


        } else {
            while (cursor.moveToNext()){
                one1.add(cursor.getString(0));
                two2.add(cursor.getString(1));
                three3.add(cursor.getString(2));
                four4.add(cursor.getString(3));
                fife5.add(cursor.getString(4));
                six6.add(cursor.getString(5));
                seven7.add(cursor.getString(6));
                eith8.add(cursor.getString(7));
                nine9.add(cursor.getString(8));
                thene10.add(cursor.getString(9));
                eleven11.add(cursor.getString(10));
                tvelve12.add(cursor.getString(11));
            }

        }
    }



    void startAdapter(){

        customAdapter = new CustomAdapter(ListActivity.this, this,  one1, two2, three3,
                four4,fife5,six6,seven7,eith8,nine9,thene10,tvelve12,tvelve12);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1) {
            recreate();
        }
    }
    void addItem() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class );
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });
    }

    void backButon(){
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    void deleteButon(){
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB = new DatabaseHelper(ListActivity.this);
                myDB.deleteAllData();
                Intent intent = new Intent(ListActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        customAdapter.notifyDataSetChanged();
    }
}