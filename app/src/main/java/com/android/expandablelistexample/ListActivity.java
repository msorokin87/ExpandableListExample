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
import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addButton;
    Button back_button, delete_button ;
    int size;

    ImageView empty_imageview;
    TextView no_data;
    ArrayList<ModelNewList> modelArray, modelGoodsArray;
    /*String one;
    String two;
    String three;
    String four;
    String fife;
    String six;
    String seven;
    String eith;
    String nine;
    String thene;
    String eleven;
    String tvele;*/

    DatabaseHelper myDB;
    ArrayList<String> newArraytoAdapter, id_row, one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);

        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        back_button = findViewById(R.id.back_button);
        delete_button = findViewById(R.id.delete_button);
        myDB = new DatabaseHelper(ListActivity.this);

        modelArray = new ArrayList<>();

        id_row = new ArrayList<>();
        one = new ArrayList<>();
        two = new ArrayList<>();
        three = new ArrayList<>();
        four = new ArrayList<>();
        fife = new ArrayList<>();
        six = new ArrayList<>();
        seven = new ArrayList<>();
        eith = new ArrayList<>();
        nine = new ArrayList<>();
        thene = new ArrayList<>();
        eleven = new ArrayList<>();
        tvele = new ArrayList<>();



        //newArraytoAdapter = new ArrayList<>();

        storeDataInArray();

        //sortetoNewTable();


       /* for (int i = 0; i< goods_title.size(); i++){
            newArraytoAdapter.add(goods_title.get(i));
            //modelArray.add(new ModelNewList(goods_title.get(i)));
        }*/


       /* for (int k = 0 ; k < newArraytoAdapter.size(); k++) {   //выводит по одному в список
           // modelArray.add(new ModelNewList(newArraytoAdapter.get(k)));

            //если так то в одном item все скопом, но в ShowActivity все приходит правильно
        }*/



           /* modelArray.add(new ModelNewList(newArraytoAdapter.toString()));*/

        customAdapter = new CustomAdapter(ListActivity.this, this, id_row, one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));


        backButon();
        deleteButon();
        addItem();

    }
    void storeDataInArray(){

        Cursor cursor = myDB.readAllSort();
        if (cursor.getCount()==0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }
        else while (cursor.moveToNext()){
            id_row.add(cursor.getString(0));
            one.add(cursor.getString(2));
            two.add(cursor.getString(3));
            three.add(cursor.getString(4));
            four.add(cursor.getString(5));
            fife.add(cursor.getString(6));
            six.add(cursor.getString(7));
            seven.add(cursor.getString(8));
            eith.add(cursor.getString(9));
            nine.add(cursor.getString(10));
            thene.add(cursor.getString(11));
            eleven.add(cursor.getString(12));
            tvele.add(cursor.getString(13));

        }
        empty_imageview.setVisibility(View.GONE);
        no_data.setVisibility(View.GONE);

    }

   /* void sortetoNewTable(){
        size = goods_title.size();
        System.out.println(size);

        for (int i = 0 ; i<size; i++){
            if (i == 0) {
                one = goods_title.get(0);
            }
            if (i == 1) {
                two = goods_title.get(1);
            }
            if (i == 2) {
                three = goods_title.get(2);
            }
            if (i == 3) {
                four = goods_title.get(3);
            }
            if (i == 4) {
                fife = goods_title.get(4);
            }
            if (i == 5) {
                six = goods_title.get(5);
            }
            if (i == 6) {
                seven = goods_title.get(6);
            }
            if (i == 7) {
                eith = goods_title.get(7);
            }
            if (i == 8) {
                nine = goods_title.get(8);
            }
            if (i == 9) {
                thene = goods_title.get(9);
            }
            if (i == 10) {
                eleven = goods_title.get(10);
            }
            if (i == 11) {
                tvele = goods_title.get(11);
            }



        }


        myDB = new DatabaseHelper(ListActivity.this);
        myDB.addAllinSort(one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele);
        myDB.deleteAllData();
    }*/

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
                myDB.deleteAllDataSort();


                Intent intent = new Intent(ListActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}