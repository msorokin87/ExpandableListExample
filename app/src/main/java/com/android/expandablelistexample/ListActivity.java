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

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addButton;
    Button back_button, delete_button;

    ImageView empty_imageview;
    TextView no_data;
    DatabaseHelper myDB;
    ArrayList<String> goods_id, goods_title, goods_desc;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();

    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        back_button = findViewById(R.id.back_button);
        delete_button = findViewById(R.id.delete_button);

        myDB = new DatabaseHelper(this);

        goods_id = new ArrayList<>();
        goods_title = new ArrayList<>();
        goods_desc = new ArrayList<>();

        addItem();
        storeDataInArray();
        startAdapter();
        backButon();
        deleteButon();
    }

    void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount()==0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }
        else while (cursor.moveToNext()){
            goods_id.add(cursor.getString(0));
            goods_title.add(cursor.getString(1));
            goods_desc.add(cursor.getString(2));

        }
        empty_imageview.setVisibility(View.GONE);
        no_data.setVisibility(View.GONE);
    }
    void startAdapter(){
        customAdapter = new CustomAdapter(ListActivity.this, this, goods_id, goods_title, goods_desc);
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