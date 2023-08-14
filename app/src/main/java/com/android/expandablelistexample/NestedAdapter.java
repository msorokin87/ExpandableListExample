package com.android.expandablelistexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.NestedViewHolder> {

    private List<String> mList;
    Context context;
    Button save_buton;

    Activity activity;
    ArrayList<String> pre_goods = new ArrayList<>();
    ArrayList<String> pre_desc = new ArrayList<>();
    String one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele;
    String one_d, two_d, three_d, four_d, fife_d, six_d, seven_d, eith_d, nine_d, thene_d, eleven_d, tvele_d;
    int size, size_desc;
    DatabaseHelper myDB;
    EditText edit_name_list;
    String transfer;



    SharedPreferences.Editor sharedPreferences;
    SharedPreferences preferences;

    public NestedAdapter(List<String> mList, Context context, Button save_buton, String transfer){
        this.mList = mList;
        this.context = context;
        this.save_buton = save_buton;
        this.transfer = transfer;



    }
    @NonNull
    @Override
    public NestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_item , parent , false);

        return new NestedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedViewHolder holder, int position) {



        holder.mTv.setText(mList.get(position));
        holder.groop_index.setText(String.valueOf(holder.getAdapterPosition()));


        holder.checkBox.setChecked(getFromSave(holder.mTv.getText().toString() + holder.getAdapterPosition()));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveChecked(holder.mTv.getText() + String.valueOf(holder.getAdapterPosition()), isChecked);

                String text = holder.mTv.getText().toString();
                String edit = holder.text_desc.getText().toString();

                if (holder.checkBox.isChecked()){

                    holder.text_desc.setEnabled(false);
                    holder.text_desc.setHint(R.string.hint_block);

                    myDB = new DatabaseHelper(save_buton.getContext());
                    myDB.addGoods(text);
                    myDB.addDesc(edit);


                    } else if (edit.isEmpty()) {
                    //myDB = new DatabaseHelper(save_buton.getContext());

                }

                if (!holder.checkBox.isChecked()) {
                    holder.text_desc.setEnabled(true);
                    holder.text_desc.setHint(R.string.hint_add);

                    String untext = holder.mTv.getText().toString();
                    String unedit = holder.text_desc.getText().toString();
                    myDB = new DatabaseHelper(save_buton.getContext());
                    System.out.println("Снято " + untext);
                    myDB.deleteOneRaw(untext);
                    myDB.deleteOneRawDesc(unedit);
                }

            }
        });

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myDB.updateGroopName(holder.mTv.getText().toString(), transfer);
            }
        });
        save_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB = new DatabaseHelper(save_buton.getContext());
                Cursor cursor = myDB.readAllData();

                if (cursor.getCount()==0){
                    Toast.makeText(context, "Ничего не выбрано", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), ListActivity.class);
                    context.startActivity(intent);
                }
                else while (cursor.moveToNext()){
                    pre_goods.add(cursor.getString(1));
                }
                Cursor curesor_desc = myDB.readAllDesc();
                if (curesor_desc.getCount() ==0){

                }
                else while (curesor_desc.moveToNext()){
                    pre_desc.add(curesor_desc.getString(1));
                }
                size = pre_goods.size();
                size_desc = pre_desc.size();
                System.out.println(size);

                for (int i = 0; i<size_desc; i++){
                    if (i == 0) {
                        one_d = pre_desc.get(0);
                    }
                    if (i == 1) {
                        two_d = pre_desc.get(1);
                    }
                    if (i == 2) {
                        three_d = pre_desc.get(2);
                    }
                    if (i == 3) {
                        four_d = pre_desc.get(3);
                    }
                    if (i == 4) {
                        fife_d = pre_desc.get(4);
                    }
                    if (i == 5) {
                        six_d = pre_desc.get(5);
                    }
                    if (i == 6) {
                        seven_d = pre_desc.get(6);
                    }
                    if (i == 7) {
                        eith_d = pre_desc.get(7);
                    }
                    if (i == 8) {
                        nine_d = pre_desc.get(8);
                    }
                    if (i == 9) {
                        thene_d = pre_desc.get(9);
                    }
                    if (i == 10) {
                        eleven_d = pre_desc.get(10);
                    }
                    if (i == 11) {
                        tvele_d = pre_desc.get(11);
                    }
                }

                for (int i = 0 ; i<size; i++){
                    if (i == 0) {
                        one = pre_goods.get(0);
                    }
                    if (i == 1) {
                        two = pre_goods.get(1);
                    }
                    if (i == 2) {
                        three = pre_goods.get(2);
                    }
                    if (i == 3) {
                        four = pre_goods.get(3);
                    }
                    if (i == 4) {
                        fife = pre_goods.get(4);
                    }
                    if (i == 5) {
                        six = pre_goods.get(5);
                    }
                    if (i == 6) {
                        seven = pre_goods.get(6);
                    }
                    if (i == 7) {
                        eith = pre_goods.get(7);
                    }
                    if (i == 8) {
                        nine = pre_goods.get(8);
                    }
                    if (i == 9) {
                        thene = pre_goods.get(9);
                    }
                    if (i == 10) {
                        eleven = pre_goods.get(10);
                    }
                    if (i == 11) {
                        tvele = pre_goods.get(11);
                    }

                }
                myDB = new DatabaseHelper(save_buton.getContext());
                myDB.addAllinSort(one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele);
                myDB.addAllinDesc(one_d, two_d, three_d, four_d, fife_d, six_d, seven_d, eith_d, nine_d, thene_d, eleven_d, tvele_d);
                myDB.deleteAllData();
                myDB.deleteAllDataDesc();



                preferences = context.getSharedPreferences("Button", Context.MODE_PRIVATE);
                preferences.edit().clear().commit();
                Intent intent = new Intent(v.getContext(), ListActivity.class);
                context.startActivity(intent);


            }
        });


        
    }

    private void saveChecked(String s, boolean isChecked) {
         sharedPreferences =
                context.getSharedPreferences("Button", android.content.Context.MODE_PRIVATE)
                        .edit();
        sharedPreferences.putBoolean(s, isChecked);
        sharedPreferences.commit();
    }

    private boolean getFromSave(String s) {
        preferences = context.getSharedPreferences("Button", Context.MODE_PRIVATE);
        return preferences.getBoolean(s, false);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NestedViewHolder extends RecyclerView.ViewHolder{
        private CheckBox checkBox;
        private TextView mTv,  groop_index;
        EditText text_desc;
        Button save_button;
        public NestedViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.nestedItemTv);
            checkBox = itemView.findViewById(R.id.checkbox);
            save_button = itemView.findViewById(R.id.save_button);
            text_desc = itemView.findViewById(R.id.text_desc);
            groop_index = itemView.findViewById(R.id.groop_index);
            edit_name_list = itemView.findViewById(R.id.edit_name_list);



        }

    }


}

