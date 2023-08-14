package com.android.expandablelistexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    DatabaseHelper myDB;
    ArrayList<String> id_row, one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele;
    ArrayList<String> id_row_d, one_d, two_d, three_d, four_d, fife_d, six_d, seven_d, eith_d, nine_d, thene_d, eleven_d, tvele_d;
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

        id_row_d = new ArrayList<>();
        one_d = new ArrayList<>();
        two_d = new ArrayList<>();
        three_d = new ArrayList<>();
        four_d = new ArrayList<>();
        fife_d = new ArrayList<>();
        six_d = new ArrayList<>();
        seven_d = new ArrayList<>();
        eith_d = new ArrayList<>();
        nine_d = new ArrayList<>();
        thene_d = new ArrayList<>();
        eleven_d = new ArrayList<>();
        tvele_d = new ArrayList<>();


        storeDataInArray();


        customAdapter = new CustomAdapter(ListActivity.this, this,
                id_row, one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele,
                id_row_d, one_d, two_d, three_d, four_d, fife_d, six_d, seven_d, eith_d, nine_d, thene_d, eleven_d, tvele_d);
        recyclerView.setAdapter(customAdapter);
        int i = customAdapter.getItemCount();
        if (i == 2){
            addButton.setVisibility(View.GONE);
            back_button.setVisibility(View.GONE);
            Toast.makeText(this, "Можно добавить только 2 записи", Toast.LENGTH_SHORT).show();
        } else {
            addButton.setVisibility(View.VISIBLE);
            back_button.setVisibility(View.VISIBLE);
        }
        System.out.println("Количество айтемов " + i);
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



        Cursor cursor_desc = myDB.readAllDesc_New();
        if (cursor.getCount()==0){
        }
        else while (cursor_desc.moveToNext()){
            id_row_d.add(cursor_desc.getString(0));
            one_d.add(cursor_desc.getString(2));
            two_d.add(cursor_desc.getString(3));
            three_d.add(cursor_desc.getString(4));
            four_d.add(cursor_desc.getString(5));
            fife_d.add(cursor_desc.getString(6));
            six_d.add(cursor_desc.getString(7));
            seven_d.add(cursor_desc.getString(8));
            eith_d.add(cursor_desc.getString(9));
            nine_d.add(cursor_desc.getString(10));
            thene_d.add(cursor_desc.getString(11));
            eleven_d.add(cursor_desc.getString(12));
            tvele_d.add(cursor_desc.getString(13));

        }

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
                SharedPreferences preferences = getSharedPreferences("Button", Context.MODE_PRIVATE);
                preferences.edit().clear().commit();

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
                myDB.deleteAllDataDesc();
                myDB.deleteAllDataDescNew();


                Intent intent = new Intent(ListActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}