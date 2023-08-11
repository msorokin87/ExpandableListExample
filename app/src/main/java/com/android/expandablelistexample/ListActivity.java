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

    ImageView empty_imageview;
    TextView no_data;
    ArrayList<ModelNewList> modelArray, modelGoodsArray;
    String[] oneGods;
    String one = "";

    DatabaseHelper myDB;
    ArrayList<String> newArraytoAdapter, goods_title, arrayListtoAdapter;
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


        goods_title = new ArrayList<>();
        newArraytoAdapter = new ArrayList<>();

        storeDataInArray();


        for (int i = 0; i< goods_title.size(); i++){
            newArraytoAdapter.add(goods_title.get(i));
            //modelArray.add(new ModelNewList(goods_title.get(i)));
        }


        for (int k = 0 ; k < newArraytoAdapter.size(); k++) {
            //выводит по одному в список
           // modelArray.add(new ModelNewList(newArraytoAdapter.get(k)));

            //если так то в одном item все скопом, но в ShowActivity все приходит правильно
        }

            modelArray.add(new ModelNewList(newArraytoAdapter.toString()));



            oneGods = goods_title.toArray(new String[goods_title.size()]);
            System.out.println("Массив " + Arrays.toString(oneGods));
            one = oneGods[0];




        customAdapter = new CustomAdapter(ListActivity.this, this, modelArray, one);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));


        backButon();
        deleteButon();
        addItem();

    }
    void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount()==0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }
        else while (cursor.moveToNext()){
            goods_title.add(cursor.getString(1));

        }
        empty_imageview.setVisibility(View.GONE);
        no_data.setVisibility(View.GONE);

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


}